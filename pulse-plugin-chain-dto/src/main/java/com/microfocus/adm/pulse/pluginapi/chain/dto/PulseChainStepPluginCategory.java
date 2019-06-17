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

/**
 * Provides a known set of categories that experts can implement. An expert can declare it is a member other categories not listed
 * here if it wants, and Pulse will display and group the experts in the category together. For example a company writing its own
 * internal experts might give them a category of the company name so that they are obvious within the Pulse UI.
 *
 * @since CM_14.4
 */
public final class PulseChainStepPluginCategory {
    private PulseChainStepPluginCategory() {
        // Expert category definitions
    }

    public static final String BUILD = "BUILD";
    public static final String STATIC_ANALYSIS = "STATIC_ANALYSIS";
    public static final String SECURITY = "SECURITY";
    public static final String CAPTURE_ARTIFACTS = "CAPTURE_ARTIFACTS";
    public static final String SCM = "SCM";
    public static final String DEPLOYMENT = "DEPLOYMENT";
    public static final String CONTAINER = "CONTAINER";
    public static final String OTHER = "OTHER";
}
