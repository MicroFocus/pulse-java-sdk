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
 * Allows a plugin to be given a directory to store data in, currently located within Pulses <code>_caches</code> directory, but
 * could change in future releases. Plugins should be aware that the directories within the <code>_caches</code> directory can be
 * deleted between runs of Pulse, however it provides a place where the plugin can store data such as a small database of
 * signatures.
 * </p>
 * <p>
 * Plugins should create a sub-directory within the directory.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseCachesDirectoryAware {
    /**
     * <p>
     * Set the path for the plugin to use as a data store. Plugins should create a sub-directory within the directory.
     * </p>
     *
     * @param directoryPath
     *            Path given to the plugin to store data within.
     */
    void setCachesDirectory(Path directoryPath);
}
