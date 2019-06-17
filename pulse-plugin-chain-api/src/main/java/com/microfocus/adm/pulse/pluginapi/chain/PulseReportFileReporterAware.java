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

package com.microfocus.adm.pulse.pluginapi.chain;

/**
 * Implement to receive the {@link PulseReportFileReporter} instance to use to report a file to Pulse for the current step.
 */
public interface PulseReportFileReporterAware {
    /**
     * <p>
     * Receives the {@link PulseReportFileReporter} used to report a file that contains information about the analysis in a third
     * party system.
     * </p>
     *
     * @param reportFileReporter
     *            File reporter. Will not be null.
     * @since 19.1.1
     */
    void setReportFileReporter(PulseReportFileReporter reportFileReporter);
}
