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

import java.util.List;

public interface PulseChain {
    String getKey();

    String getTitle();

    String getNote();

    PulseChainScheduleType getScheduleType();

    boolean isFetchStream();

    boolean isRunEvenIfNoChangesets();

    Long getLastBuildNumber();

    List<String> getIncludePaths();

    List<String> getTriggerPaths();

    List<String> getCapabilities();

    List<PulseChainStep> getSteps();

    PulseBranch getBranch();

    PulseRepository getRepository();
}
