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
 * Represents a measurement made by an expert of a metric. Measurements should be constructed using the
 * {@link com.microfocus.adm.pulse.pluginapi.chain.PulseMeasurementBuilder} returned from
 * {@link com.microfocus.adm.pulse.pluginapi.chain.PulseMeasurementReporter#getMeasurementBuilder()}. Any measurements not constructed
 * from the builder will not be accepted by the Pulse framework.
 * </p>
 * <p>
 * Measurements are subject to the following restrictions:
 * </p>
 * <ol>
 * <li>Null values are forbidden.</li>
 * <li>Double values can not be NaN, NEGATIVE_INFINITY or POSITIVE_INFINITY</li>
 * <li>Values are read only, once a value has been set on a value, it can not be changed.</li>
 * <li>Value type is enforced such that setting a string on a numeric type is disallowed etc.</li>
 * </ol>
 *
 * @since CM_14.2
 */
public interface PulseMeasurement {
    /**
     * <p>
     * Gets the metric definition that this is a measurement for.
     * </p>
     *
     * @return Metric definition. Can not be null.
     * @since CM_14.2
     */
    PulseMetric getMetric();

    /**
     * <p>
     * Optional path of the item this measurement is for. Currently Pulse will ignore this when displaying values, however a future
     * release may use this value to provide more precise measurements.
     * </p>
     *
     * @return Optional item path.
     * @since CM_14.2
     */
    String getPath();

    /**
     * <p>
     * Gets the string value for the measurement. If the metric is not a string value, an string representation of the value will be
     * attempted depending on the type. For example a boolean value will return <code>true</code> or <code>false</code> for its
     * string value.
     * </p>
     *
     * @return String value for the measurement.
     * @since CM_14.2
     */
    String getStringValue();

    /**
     * <p>
     * Gets the double value for the measurement. If the metric is a string based type, this will return null. If the metric type is
     * {@link PulseMetricType#BOOLEAN}, this method will return 0.0 for false and 1.0 for true.
     * </p>
     *
     * @return Double value. Can be null depending on metric type.
     * @since CM_14.2
     */
    Double getDoubleValue();

    /**
     * <p>
     * Gets the boolean value for the measurement. If the metric is a string based type, this will return null. For numeric metric
     * types, this will return true if the numeric value is not 0.0 and false if the measurement value is 0.0
     * </p>
     *
     * @return Boolean value. Can be null depending on metric type.
     * @since CM_14.2
     */
    Boolean getBooleanValue();

    /**
     * <p>
     * Gets the integer value for the measurement. If the metric is a string based type, this will return null. For numeric metric
     * types, this will return the rounded value as returned from {@link Math#round(double)}. If the metric type is
     * {@link PulseMetricType#BOOLEAN} this will return 0 if the measurement value is false and 1 if the measurement value is true.
     * </p>
     *
     * @return Integer value. Can be null depending on metric type.
     * @since CM_14.2
     */
    Integer getIntegerValue();
}
