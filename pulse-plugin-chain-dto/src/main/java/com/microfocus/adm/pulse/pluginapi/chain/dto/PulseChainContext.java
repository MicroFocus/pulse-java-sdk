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

package com.microfocus.adm.pulse.pluginapi.chain.dto;

import java.util.List;

/**
 * <p>
 * A chain run executes its steps sequentially one by one, where each plugin is invoked with an instance of this interface to
 * describe the current state of the chain run.
 * </p>
 *
 * <p>
 * It is safe to hold on to the objects returned by this interface between
 * {@link com.microfocus.adm.pulse.pluginapi.chain.PulseChainStepPlugin#doStep(PulseChainContext)} calls, but it isn't recommended
 * because of the low cost in requesting the objects from the context.
 * </p>
 *
 * <p>
 * Do not use a {@link PulseChainContext} obtained from another PulseExpertContext. The results are undefined.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseChainContext {
    /**
     * <p>
     * Get a string that represents the name of the chain to which this run belongs.
     * </p>
     *
     * @return chain name for this chain run. Can not be null or empty.
     * @since 19.1.1
     */
    String getChainName();

    /**
     * <p>
     * Get a string that represents a unique identifier for this chain run.
     * </p>
     *
     * @return chain run number. Can not be null or empty.
     * @since 19.1.1
     */
    String getBuildNumber();

    /**
     * <p>
     * Root of the workspace directory for this chain run.
     * </p>
     *
     * @return Workspace directory. Can not be null or empty.
     * @since 19.1.1
     */
    String getWorkspaceRoot();

    /**
     * <p>
     * Get a string that can be used as a unique identifier for the run of the expert. Pulse guarantees that this value will not
     * change for each run of an expert and will be unique for each run. No assumption should be made as to the meaning of its
     * content, other than it is a unique identifier.
     * </p>
     *
     * @return Unique identifier for chain run step. Can not be null or empty.
     * @since 19.1.1
     */
    String getIdentifier();

    /**
     * <p>
     * Gets the execution state of the previous chain step.
     * </p>
     *
     * @return state of previous chain step
     * @since 19.1.1
     */
    PulseState getLastChainStepState();

    /**
     * <p>
     * Get details about the changesets to be processed. The collection includes the changesets in the stream back to (but not
     * including) the previous chain run. A chain is always run against at least one changeset (the one associated with the content
     * that would be fetched into the workspace).
     * </p>
     *
     * <p>
     * The changesets are ordered, most recent (latest) first.
     * </p>
     *
     * @return Details of the changesets since the last chain run. Can not be null.
     * @since 19.1.1
     */
    List<PulseChangeset> getChangesets();
}
