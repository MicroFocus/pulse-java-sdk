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
 * Indicates whether an increasing value is better or worse. This is used to influence the display of the metric. By default metrics
 * have a direction of none.
 * </p>
 * <p>
 * Can be one of:
 * </p>
 * <ul>
 * <li>{@link #NONE},</li>
 * <li>{@link #BETTER},</li>
 * <li>{@link #WORSE}</li>
 * </ul>
 *
 * @since CM_14.2
 */
public enum PulseMetricDirection {
    /**
     * <p>
     * Default direction. The change in value has no meaning about whether the metric is improving or worsening.
     * </p>
     *
     * @since CM_14.2
     */
    NONE,
    /**
     * <p>
     * If the measurement value increases, the metric is assumed to be improving.
     * </p>
     *
     * @since CM_14.2
     */
    BETTER,
    /**
     * <p>
     * If the measurement value increases, the metric is assumed to be worsening.
     * </p>
     *
     * @since CM_14.2
     */
    WORSE
}
