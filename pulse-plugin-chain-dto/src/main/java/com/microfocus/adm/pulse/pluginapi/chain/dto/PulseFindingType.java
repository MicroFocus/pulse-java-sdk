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
 * The type of the {@link PulseFinding}:
 * </p>
 * <ul>
 * <li>{@link #LINE}</li>
 * <li>{@link #FILE}</li>
 * <li>{@link #CHANGESET}</li>
 * </ul>
 *
 * @since 19.1.1
 */
public enum PulseFindingType {
    /**
     * <p>
     * Finding relates to a specific line in a file in the changeset.
     * </p>
     *
     * @since 19.1.1
     */
    LINE,
    /**
     * <p>
     * Finding relates to a file in the changeset, but no particular line.
     * </p>
     *
     * @since 19.1.1
     */
    FILE,
    /**
     * <p>
     * Finding relates to the changeset, but no particular file or directory.
     * </p>
     *
     * @since 19.1.1
     */
    CHANGESET
}
