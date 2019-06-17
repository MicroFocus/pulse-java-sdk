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

import java.util.Map;

/**
 * <p>
 * Provides access to the user supplied environment variables for this run of the plugin. The map passed via this interface is
 * writable, but any modifications will be lost between steps.
 * </p>
 * <p>
 * All properties are returned as string values and it is up to the plugin to convert them into a format that it requires.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseEnvironmentVariableAware {
    /**
     * <p>
     * Set the environment supplied configuration for this expert as a {@link Map}.
     * </p>
     *
     * @param variables
     *            Environment variables. Will not be null.
     * @since 19.1.1
     */
    void setEnvironmentVariables(Map<String, String> variables);
}
