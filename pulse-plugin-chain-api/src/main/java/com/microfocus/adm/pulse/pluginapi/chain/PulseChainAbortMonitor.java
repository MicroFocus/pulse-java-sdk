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
 * Allows a {@link PulseChainStepPlugin} to check to see if the chain has been aborted and allow it to stop processing the step.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseChainAbortMonitor {
    /**
     * <p>
     * Call to check if the current step should be aborted. This can be used as an indicator by the chain plugin to safely stop
     * processing and release any resources it has. It is recommended to make use of this rather than risk the plugin being shutdown
     * forcibly by the Pulse Agent.
     * </p>
     *
     * @return true if the chain has been aborted and the chain step should stop.
     * @since 19.1.1
     */
    boolean isChainAborted();
}
