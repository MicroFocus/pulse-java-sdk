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

import java.io.File;

/**
 * <p>
 * Provides the plugin with a directory it can persist data into between runs. Care should be taken as this directory is shared
 * between plugin instances including two plugins running at the same time in different workspaces.
 * </p>
 */
public interface PulsePersistentDirectoryAware {
    /**
     * <p>
     * Sets the {@link File} persistent (temporary folder). This directory will be the same between runs of a plugin so care should
     * be taken to ensure that two plugin instances running at the same time don't clash.
     * </p>
     * <p>
     * It is important to keep the use of this directory to a minimum to ensure that it does not consume too much space. If you need
     * temporary space, you should use the {@link PulseTemporaryDirectoryAware} interface which is unique to the run of the chain
     * and is automatically disposed of by the Agent.
     * </p>
     *
     * @param persistentDirectory
     *            Persistent directory as a {@link File} object.
     * @since 19.1.1
     */
    void setPersistentDirectory(File persistentDirectory);
}
