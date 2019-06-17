/*
 * MIT License
 *
 * Copyright (c) 2019 Micro Focus or one of its affiliates.
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/MIT
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 *
 */

package com.microfocus.pulse.example.worddetector;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.microfocus.adm.pulse.pluginapi.chain.annotations.Metric;
import com.microfocus.adm.pulse.pluginapi.chain.PulseChainStepConfigAware;
import com.microfocus.adm.pulse.pluginapi.chain.PulseChainStepPlugin;
import com.microfocus.adm.pulse.pluginapi.chain.annotations.PulseChainStepPluginDefinition;
import com.microfocus.adm.pulse.pluginapi.chain.PulseChainStepPluginException;
import com.microfocus.adm.pulse.pluginapi.chain.PulseConsoleLoggerAware;
import com.microfocus.adm.pulse.pluginapi.chain.PulseFindingBuilder;
import com.microfocus.adm.pulse.pluginapi.chain.PulseFindingReporter;
import com.microfocus.adm.pulse.pluginapi.chain.PulseFindingReporterAware;
import com.microfocus.adm.pulse.pluginapi.chain.PulseConsoleLogger;
import com.microfocus.adm.pulse.pluginapi.chain.PulseMeasurementReporter;
import com.microfocus.adm.pulse.pluginapi.chain.PulseMeasurementReporterAware;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseChainContext;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseChainStepPluginCategory;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseChange;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseChange.ChangeType;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseChangeset;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseFindingSeverity;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetricCoreRealm;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetricDirection;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetricType;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseState;

/**
 * Simple chain plugin that searches for words in the files in the workspace. When it finds a word it generates a finding for the
 * line containing the word. Plugin also generates a metric that measures the total number words found.
 */

@PulseChainStepPluginDefinition(groupId = "com.microfocus.pulse.example", pluginId = "worddetector", version = "0", displayName = "Word Detector", category = PulseChainStepPluginCategory.OTHER, description = "Checks for words (example plugin)")
@Metric(realm = PulseMetricCoreRealm.SIZE, name = "Word Count", description = "Number of words found", direction = PulseMetricDirection.WORSE, valueType = PulseMetricType.INTEGER)
public class WordDetectorPulseExample implements PulseChainStepPlugin, PulseConsoleLoggerAware, PulseMeasurementReporterAware,
        PulseFindingReporterAware, PulseChainStepConfigAware<PluginConfiguration> {

    private PulseConsoleLogger consoleLogger;
    private PulseFindingReporter findingsReporter;
    private PulseMeasurementReporter measurementReporter;
    private PluginConfiguration config;

    @Override
    public void setConsoleLogger(final PulseConsoleLogger consoleLogger) {
        this.consoleLogger = consoleLogger;
    }

    @Override
    public void setFindingReporter(final PulseFindingReporter findingReporter) {
        this.findingsReporter = findingReporter;
    }

    @Override
    public void setMeasurementReporter(final PulseMeasurementReporter measurementReporter) {
        this.measurementReporter = measurementReporter;
    }

    @Override
    public void setChainStepConfig(final PluginConfiguration config) {
        this.config = config;
    }

    @Override
    public PulseState doStep(final PulseChainContext context) throws PulseChainStepPluginException {
        consoleLogger.debug("Inspection started.");

        // Check we have a context
        if (context.getChangesets().isEmpty()) {
            consoleLogger.error("No changeset to analyze");
            return PulseState.COMPLETED_ABORTED;
        }

        if (config.words.isEmpty()) {
            consoleLogger.info("No words to search for");
            return PulseState.COMPLETED_SUCCESS;
        }

        // Read each file checking it for the words...
        int wordCount = 0;
        final Set<String> paths = new HashSet<>();
        for (final PulseChangeset changeset : context.getChangesets()) {
            for (final PulseChange change : changeset.getChanges()) {
                if (change.getType() == ChangeType.ADDED || change.getType() == ChangeType.MODIFIED
                        || change.getType() == ChangeType.RENAMED_AND_MODIFIED) {
                    paths.add(change.getPathAfter());
                }
            }
        }
        for (final String path : paths) {
            final int wordsFound = scanFile(context.getWorkspaceRoot(), path, config.words);
            if (wordsFound > 0) {
                wordCount += wordsFound;
                consoleLogger.info("Found {0} words in {1}", wordsFound, path);
            }
        }

        // Report the total found
        measurementReporter.addMeasurement(
                measurementReporter.getMeasurementBuilder().metricByName("Word Count").integerValue(wordCount).build());
        consoleLogger.debug("Inspection finished.");
        return PulseState.COMPLETED_SUCCESS;
    }

    private int scanFile(final String workspaceRoot, final String path, final List<String> words) {
        try {
            // Build a regex pattern to find the words
            Pattern pattern = createPattern(words);

            final File workFile = new File(workspaceRoot, path);
            if (workFile.isFile()) {
                final PulseFindingBuilder builder = findingsReporter.getFindingBuilder().path(path)
                        .severity(PulseFindingSeverity.WARNING);

                // Scan each line of the file
                int lineNumber = 1;
                final Scanner scanner = new Scanner(workFile);
                int count = 0;
                while (scanner.hasNextLine()) {
                    final String line = scanner.nextLine();
                    // Find words on the line using the regex
                    final Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        // Report each finding on this line
                        findingsReporter.addFinding(builder.line(lineNumber).message("Found " + matcher.group(1)).build());
                        count++;
                    }
                    lineNumber++;
                }
                scanner.close();
                return count;
            }
        } catch (FileNotFoundException e) {
            consoleLogger.debug("File not found '" + path + "': " + e.getMessage());
        }
        return 0;
    }

    private Pattern createPattern(final List<String> words) {
        StringBuilder sb = new StringBuilder();
        sb.append("\\b(");
        final Iterator<String> parts = words.iterator();
        if (parts.hasNext()) {
            sb.append(parts.next());
            while (parts.hasNext()) {
                sb.append("|");
                sb.append(parts.next());
            }
        }
        sb.append(")\\b");
        return Pattern.compile(sb.toString());
    }
}
