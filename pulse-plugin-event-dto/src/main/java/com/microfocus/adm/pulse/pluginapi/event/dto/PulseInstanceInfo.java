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

package com.microfocus.adm.pulse.pluginapi.event.dto;

/**
 * <p>
 * Provides a way of identifying the Pulse cluster a plugin is running in, effectively the Pulse DB this pulse is connected to.
 * </p>
 */
public interface PulseInstanceInfo {
    /**
     * <p>
     * Unique identifier for the Pulse cluster.
     * </p>
     *
     * @return Unique identifier for the Pulse cluster.
     */
    String getInstanceId();
}
