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
 * <p>
 * Implement to receive the {@link PulseUrlReporter} instance to use to report a URL to Pulse for the current step.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseUrlReporterAware {
    /**
     * <p>
     * Receives the {@link PulseUrlReporter} used to report a URL that contains information about the analysis in a third party
     * system.
     * </p>
     *
     * @param urlReporter
     *            URL reporter. Can not be null.
     * @since 19.1.1
     */
    void setUrlReporter(PulseUrlReporter urlReporter);
}
