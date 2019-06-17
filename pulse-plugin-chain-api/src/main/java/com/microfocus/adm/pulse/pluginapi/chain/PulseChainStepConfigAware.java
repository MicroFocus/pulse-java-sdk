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

/**
 * <p>
 * If a {@link PulseChainStepPlugin} needs configuration from the step it can use this interface to receive the configuration as a
 * Java POJO. The type of object it receives is defined by the {@linkplain CONFIG_TYPE}.
 * </p>
 * <p>
 * The target class can use the {@link com.microfocus.adm.pulse.pluginapi.chain.annotations.ChainStepConfigProperty},
 * {@link com.microfocus.adm.pulse.pluginapi.chain.annotations.ObfuscatedProperty}, and
 * {@link com.microfocus.adm.pulse.pluginapi.chain.annotations.TokenisedProperty} annotations to control how the mapping from the
 * chain step configuration into the POJO is performed. By default each configuration parameter is mapped into a matching property
 * in the POJO unless one of the annotations is used to override the mapping.
 * </p>
 *
 * @param <CONFIG_TYPE> POJO class that should injected with the plugins configuration.
 * @since 19.1.1
 */
public interface PulseChainStepConfigAware<CONFIG_TYPE> {
    /**
     * <p>
     * Sets the configuration object for the step. Called before one of the {@link PulseChainStepPlugin} step methods are called.
     * </p>
     *
     * @param config
     *            Object the configuration has been mapped into.
     * @since 19.1.1
     */
    void setChainStepConfig(CONFIG_TYPE config);
}
