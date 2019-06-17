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

import java.nio.file.Path;

/**
 * <p>
 * Allows a plugin to be told where the config directory is for Pulse. This allows the plugin to load configuration from the
 * directory.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseConfigDirectoryAware {
    /**
     * <p>
     * Set the path for the config directory for Pulse.
     * </p>
     *
     * @param directory
     *            Directory that holds the configuration for Pulse.
     * @since 19.1.1
     */
    void setConfigDirectory(Path directory);
}
