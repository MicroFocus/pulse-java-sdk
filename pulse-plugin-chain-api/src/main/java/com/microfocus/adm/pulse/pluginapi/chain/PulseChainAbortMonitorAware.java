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
 * Implement to receive the {@link PulseChainAbortMonitor} instance to use to detect when a chain step plugin should prematurely
 * stop processing the current step because the user has asked for the chain to stop.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseChainAbortMonitorAware {
    /**
     * <p>
     * Set the {@link PulseChainAbortMonitor} used to monitor whether a chain step plugin should stop processing the current step.
     * </p>
     *
     * @param chainAbortMonitor
     *            Alert {@link PulseChainAbortMonitor}. Will not be null.
     * @since 19.1.1
     */
    void setChainAbortMonitor(PulseChainAbortMonitor chainAbortMonitor);
}
