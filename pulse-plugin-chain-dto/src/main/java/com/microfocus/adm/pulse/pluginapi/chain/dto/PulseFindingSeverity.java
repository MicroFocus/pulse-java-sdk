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
 * <p>
 * The severity of the {@link PulseFinding}:
 * </p>
 * <ul>
 * <li>{@link #FATAL}</li>
 * <li>{@link #ERROR}</li>
 * <li>{@link #WARNING}</li>
 * <li>{@link #INFO}</li>
 * <li>{@link #IGNORE}</li>
 * </ul>
 *
 * @since CM_14.2
 */
public enum PulseFindingSeverity {
    /**
     * @since 19.1.1
     */
    FATAL,
    /**
     * @since 19.1.1
     */
    ERROR,
    /**
     * @since 19.1.1
     */
    WARNING,
    /**
     * @since 19.1.1
     */
    INFO,
    /**
     * @since 19.1.1
     */
    IGNORE
}
