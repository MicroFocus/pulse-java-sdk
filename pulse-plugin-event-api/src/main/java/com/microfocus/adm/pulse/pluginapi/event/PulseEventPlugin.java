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

import java.io.Closeable;

import com.microfocus.adm.pulse.pluginapi.PulsePlugin;

/**
 * <p>
 * Base interface for the event plugins.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseEventPlugin extends PulsePlugin, Closeable {
    /**
     * <p>
     * Called to allow the plugin to initialise. By the time this method is called, all of the <code>Aware</code> interfaces will
     * have been called to provide the plugin with everything that it needs from Pulse.
     * </p>
     * <p>
     * If for some reason the plugin does not want to be used by Pulse, it can return <code>false</code> and Pulse will disable the
     * plugin from being called.
     * </p>
     *
     * @return True if the plugin has been initialised and should be used by Pulse.
     * @throws PulseChainEventPluginException
     *             Throw if something goes wrong and you want it to be reported. If this is thrown, Pulse will disable the Plugin.
     * @since 19.1.1
     */
    boolean init() throws PulseChainEventPluginException;
}
