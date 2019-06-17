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
 * Describes whether a measurement for a metric is {@link #TRANSIENT} and shouldn't be recorded in the datatbase or
 * {@link #DATABASE} where it should be recorded in the database. Transient metrics are handy for measurements used by a functional
 * metric and can be though of as workspace like.
 * </p>
 *
 * @since CM_14.2
 */
public enum PulseMetricStorage {
    /**
     * <p>
     * Value is not persisted to the database and is only available while the expert is running.
     * </p>
     *
     * @since CM_14.2
     */
    TRANSIENT,
    /**
     * <p>
     * Value is persisted to the database when the expert completes.
     * </p>
     *
     * @since CM_14.2
     */
    DATABASE
}
