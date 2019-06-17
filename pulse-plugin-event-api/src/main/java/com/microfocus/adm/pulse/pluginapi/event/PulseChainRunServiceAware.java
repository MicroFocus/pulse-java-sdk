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

package com.microfocus.adm.pulse.pluginapi.event;

/**
 * <p>
 * Plugins implement this interface if they want to be able to get information about Pulse chain runs.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseChainRunServiceAware {

    /**
     * <p>
     * Sets the {@link PulseChainRunService} to use to get information about Pulse chain runs.
     * </p>
     *
     * @param pulseChainRunService
     *            Service that can provide information about Pulse chain runs.
     * @since 19.1.1
     */
    void setPulseChainRunService(PulseChainRunService pulseChainRunService);

}
