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

package com.microfocus.pulse.example.worddetector;

import java.util.List;

import com.microfocus.adm.pulse.pluginapi.chain.annotations.MultiValueProperty;
import com.microfocus.adm.pulse.pluginapi.chain.annotations.TokenisedProperty;

/**
 * Configuration class is automatically created by the framework and passed into the plugin via the
 * {@link com.microfocus.adm.pulse.pluginapi.chain.PulseChainStepConfigAware#setChainStepConfig(Object)} method.
 */
public class PluginConfiguration {
    @MultiValueProperty(value = ",") // Property is held as a multi valued string, with commas as separators
    @TokenisedProperty(value = false) // Values don't contain tokens, so don't try to expand them.
    public List<String> words; // Properties need to be public to allow the framework to set them.
}
