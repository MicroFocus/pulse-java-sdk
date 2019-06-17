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
 * Allows a string to have variable tokens replaced.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseVariableTokenizer {
    /**
     * <p>
     * Replace the variable tokens in the supplied string. Token values are looked for in order of chain variables, agent variables
     * and then system variables. As soon as a variable is found the search will stop.
     * </p>
     *
     * @param source
     *            String to replace the tokens within.
     * @since 19.1.1
     */
    String replaceTokens(String source);
}
