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

import com.microfocus.adm.pulse.pluginapi.event.dto.PulseChainRun;

/**
 * <p>
 * Allows a plugin to get details about a chain run.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseChainRunService {

    /**
     * <p>
     * Returns details about the specified chain run.
     * </p>
     *
     * @param key
     *            Key for the chain run to return the details of.
     * @return Details for the chain run. Will not be null.
     * @throws PulseChainRunNotFoundException
     *             Thrown if Pulse does not know the about the chain run.
     * @since 19.1.1
     */
    PulseChainRun getChainRun(String key) throws PulseChainRunNotFoundException;

    /**
     * <p>
     * Given a chain run, returns the previous chain run. This allows a Pulse plugin to walk back through the history of the runs
     * for a chain.
     * </p>
     *
     * @param key
     *            Key for the chain run to return the previous chain run.
     * @return Previous chain run or null if there is no previous run.
     * @throws PulseChainRunNotFoundException
     *             Thrown if Pulse does not know the about the chain run.
     * @since 19.1.1
     */
    PulseChainRun getPreviousChainRun(String key) throws PulseChainRunNotFoundException;

}
