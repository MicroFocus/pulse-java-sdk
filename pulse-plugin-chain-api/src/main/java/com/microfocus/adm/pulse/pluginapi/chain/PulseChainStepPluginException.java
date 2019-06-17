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
 * General exception that can be thrown by an expert or the Pulse plugin framework when an exception has occurred. If a chain step
 * plugin throws this exception a number of things will happen:
 * </p>
 * <ul>
 * <li>the message contained within will be recorded automatically by the {@link java.io.PrintWriter} set by
 * {@link PulseAlertWriterAware#setAlertWriter(PulseAlertWriter)}}.</li>
 * <li>a state of {@link com.microfocus.adm.pulse.pluginapi.chain.dto.PulseState#COMPLETED_ABORTED} will be recorded.</li>
 * </ul>
 *
 * @since 19.1.1
 */
public class PulseChainStepPluginException extends PulseChainPluginApiException {
    public PulseChainStepPluginException(final String message) {
        super(message);
    }

    public PulseChainStepPluginException(final String message, final Throwable t) {
        super(message, t);
    }

    public PulseChainStepPluginException(final Throwable t) {
        super(t);
    }
}
