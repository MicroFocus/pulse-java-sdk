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

import com.microfocus.adm.pulse.pluginapi.event.dto.PulseChainPlugin;

/**
 * <p>
 * Allows a plugin to get some details about a chain plugin, such as a displayable name.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseChainPluginService {
    /**
     * <p>
     * Gets a data structure that has some details about the specified Pulse chain plugin.
     * </p>
     *
     * @param pluginFqn
     *            Fully qualified name of the plugin to return.
     * @return Description of the Pulse chain plugin.
     * @throws PulseChainPluginNotFoundException
     *             No plugin with the provided fqn is registered with Pulse.
     * @since 19.1.1
     */
    PulseChainPlugin getPluginByFqn(String pluginFqn) throws PulseChainPluginNotFoundException;
}
