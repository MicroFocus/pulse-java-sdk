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
 * Allows the Plugin to receive the tokenizer that can be used to retrieve variables from Pulse.
 * </p>
 * <p>
 * Variable substitution works in order of chain variables, agent variables and then system variables. This means if a variable is
 * defined in all three contexts, then the variable from the chain context will be used, likewise if there is definition of the
 * variable on the chain but one on the agent, the agent context definition will be used.
 * </p>
 * @since 19.1.1
 */
public interface PulseVariableTokenizerAware {
    /**
     * <p>
     * Set the {@link PulseVariableTokenizer} that can be used to replace variable tokens in a string..
     * </p>
     *
     * @param variableTokenizer
     *            Variable tokenizer to use. Will not be null.
     * @since 19.1.1
     */
    void setVariableTokenizer(PulseVariableTokenizer variableTokenizer);
}
