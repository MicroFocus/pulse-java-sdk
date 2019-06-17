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
 * Provides a means for a {@link PulseChainStepPlugin} to report messages in the activity feed within Pulse. It should be used to
 * report small pieces of pertinent information that has affected the chain run, i.e. a network server was unavailable. It is not
 * meant as a means of reporting on the quality or issues with the code being analysed where the {@link PulseFindingReporter} set
 * by {@link PulseFindingReporterAware} should be used instead. It is also not meant as a replacement for the
 * {@link PulseConsoleLogger} but rather as a conduit to the user to raise important issues.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseAlertWriter {
    /**
     * <p>Write the message to the alert for the chain step. The message supports <code>{}</code> as markers for injecting the
     * params into the message in the same way as <code>org.slf4j.log</code>.</p>
     *
     * @param message
     *            Message to be written.
     * @param params
     *            Optional parameters for the message.
     * @since 19.1.1
     */
    void println(String message, Object... params);
}
