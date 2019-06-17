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

import java.util.Date;
import java.util.List;

public interface PulseChainRun {
    String getKey();

    PulseChain getChain();

    Date getStart();

    Date getEnd();

    /**
     * <p>
     * Gets the health state of this chain run - this is the overall state of the chain run so far (as if the chain had finished
     * with the previous step). If no step has returned anything (it was missing or an exception occurred), then it returns
     * {@link com.microfocus.adm.pulse.pluginapi.event.dto.PulseChainRunState#COMPLETED_ABORTED}.
     * </p>
     *
     * @return health state of this chain run so far.
     * @since CM_14.5
     */
    PulseChainRunState getFinalState();

    boolean isKeepForever();

    PulseTriggeredBy getTriggeredBy();

    List<PulseChangeSet> getChangesets();

    Long getDurationEstimateSeconds();

    String getBuildNumber();

    String getBranchKey();

}
