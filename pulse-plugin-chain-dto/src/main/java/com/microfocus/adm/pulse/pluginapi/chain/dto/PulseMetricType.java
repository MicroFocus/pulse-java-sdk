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
 * The metric type can be one of:
 * <ul>
 * <li>{@link #INTEGER}</li>
 * <li>{@link #STRING}</li>
 * <li>{@link #DOUBLE}</li>
 * <li>{@link #BOOLEAN}</li>
 * <li>{@link #DURATION}</li>
 * <li>{@link #SCALE}</li>
 * <li>{@link #SEVERITY}</li>
 * </ul>
 *
 * @since CM_14.2
 */
public enum PulseMetricType {
    /**
     * <p>
     * Numeric value with no fractional part. Fractional values will be rounded as if processed by {@link Math#round(double)}.
     * </p>
     *
     * @since CM_14.2
     */
    INTEGER(true),
    /**
     * <p>
     * Simple string value.
     * </p>
     *
     * @since CM_14.2
     */
    STRING(false),
    /**
     * <p>
     * Numeric value with a fractional part.
     * </p>
     *
     * @since CM_14.2
     */
    DOUBLE(true),
    /**
     * <p>
     * Value that can be either true or false.
     * </p>
     *
     * @since CM_14.2
     */
    BOOLEAN(true),
    /**
     * <p>
     * Numeric value with a fractional part. Units are seconds.
     * </p>
     *
     * @since CM_14.2
     */
    DURATION(true),
    /**
     * <p>
     * Value that can be between two numeric values. Can have a fractional component.
     * </p>
     *
     * @since CM_14.2
     */
    SCALE(true),
    /**
     * <p>
     * Severity value. Not currently supported and will be treated as {@link #DOUBLE}.
     * </p>
     *
     * @since CM_14.2
     */
    SEVERITY(false);

    private final boolean numeric;

    PulseMetricType(final boolean numeric) {
        this.numeric = numeric;
    }

    public boolean isNumeric() {
        return numeric;
    }
}
