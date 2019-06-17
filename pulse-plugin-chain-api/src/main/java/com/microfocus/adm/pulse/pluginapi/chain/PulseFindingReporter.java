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

import java.util.Collection;

import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseFinding;

/**
 * <p>
 * The findings reporter is used by the experts to annotate the files that have changed. They provide the ability to describe an
 * issue with a particular line in a file or with the whole file if a line number of 0 is specified.
 * </p>
 * <p>
 * Findings should be built using the {@link PulseFindingBuilder} returned by {@link #getFindingBuilder()}. Pulse will reject
 * findings that haven't been constructed this way with an {@link IllegalArgumentException}.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseFindingReporter {
    /**
     * <p>
     * Add the supplied finding to the set of findings reported by this expert run.
     * </p>
     *
     * @param finding
     *            Finding to be recorded. Must have come from the {@link PulseFindingBuilder} returned by
     *            {@link #getFindingBuilder()}.
     * @since 19.1.1
     */
    void addFinding(PulseFinding finding);

    /**
     * <p>
     * Add the supplied findings to the set of findings reported by this expert run.
     * </p>
     *
     * @param findings
     *            Findings to be recorded. All of the findings must have come from the {@link PulseFindingBuilder} returned by
     *            {@link #getFindingBuilder()}.
     * @since 19.1.1
     */
    void addAllFindings(Collection<PulseFinding> findings);

    /**
     * <p>
     * Create a builder that can be used to build findings to be recorded by this reporter.
     * </p>
     *
     * @return New findings builder. Will not be null.
     * @since 19.1.1
     */
    PulseFindingBuilder getFindingBuilder();
}
