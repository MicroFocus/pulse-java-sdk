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

import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMeasurement;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetric;

/**
 * <p>
 * Builder used to create measurements of previously registered metrics. Only measurements constructed with this builder are
 * accepted by the Pulse framework. The builder can be used to create multiple measurements by varying the properties between each
 * call to {@link #build()}, with each property being persisted between each call.
 * </p>
 * <p>
 * Only a single value can be held by the builder at any one time. Calling a value setter will reset the value to that type
 * automatically such that if one metric is a string value and the next is a double value, calling {@link #doubleValue(double)}
 * would drop the string value.
 * </p>
 * <p>
 * The builder doesn't perform validation on the values provided until a measurement is built with a call to {@link #build()} at
 * which time the current value contained in the builder
 * </p>
 * <p>
 * Each property setter returns this builder allowing property calls to be chained together, e.g.
 * <code>builder.metric(linesOfCode).integerValue(32768.build()</code>
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseMeasurementBuilder {

    /**
     * <p>
     * Build the measurement. If the values provided to the builder would result in an invalid measurement this method will throw an
     * {@link IllegalStateException} exception, for example if you provide an invalid double value to a numeric type.
     * </p>
     * <p>
     * Enforced limitations are;
     * </p>
     * <ul>
     * <li>A value must be provided.</li>
     * <li>The metric definition this is a measurement for must be provided and come from {@link PulseMetricRegistrar}.</li>
     * <li>Numeric values can not be {@link Double#NaN}, {@link Double#NEGATIVE_INFINITY} or {@link Double#POSITIVE_INFINITY}</li>
     * <li>String values can be empty but not null.</li>
     * </ul>
     *
     * @return New {@link PulseMeasurement} ready for recording via {@link PulseMeasurementReporter}. Can not be null.
     * @since 19.1.1
     */
    PulseMeasurement build();

    /**
     * <p>
     * Set the metric definition for the measurement being made.
     * </p>
     *
     * @param metric
     *            Metric definition from {@link PulseMetricRegistrar}
     * @return This measurement builder. Will not be null.
     * @since 19.1.1
     */
    PulseMeasurementBuilder metric(PulseMetric metric);

    /**
     * <p>
     * Set the metric definition for the measurement being made using the metric name
     * </p>
     *
     * @param name
     *            Name of the metric definition.
     * @return This measurement builder. Will not be null.
     * @throws IllegalStateException if the metric has not already been registered via the {@link com.microfocus.adm.pulse.pluginapi.chain.annotations.Metric} annotation or {@link PulseMetricRegistrar}
     * @since 19.1.1
     */
    PulseMeasurementBuilder metricByName(String name);

    /**
     * <p>
     * Set the optional path of the item this measurement relates to. This value should be the path returned from
     * {@link com.microfocus.adm.pulse.pluginapi.chain.dto.PulseChange#getPathAfter()} for the associated change. See
     * {@link PulseMeasurementReporter} for limitations on the number of measurements that can be made for a metric.
     * </p>
     *
     * @param path
     *            Path of the item being measured.
     * @return This measurement builder. Will not be null.
     * @since 19.1.1
     */
    PulseMeasurementBuilder path(String path);

    /**
     * <p>
     * Set the integer value for the measurement. No validation is performed by this method, but for measurement limitations see the
     * overview for {@link PulseMeasurementBuilder}.
     * </p>
     *
     * @param value
     *            Integer value for the measurement.
     * @return This measurement builder. Will not be null.
     * @since 19.1.1
     */
    PulseMeasurementBuilder integerValue(int value);

    /**
     * <p>
     * Set the double value for the measurement. No validation is performed by this method, but for measurement limitations see the
     * overview for {@link PulseMeasurementBuilder}.
     * </p>
     *
     * @param value
     *            Double value for the measurement.
     * @return This measurement builder. Will not be null.
     * @since 19.1.1
     */
    PulseMeasurementBuilder doubleValue(double value);

    /**
     * <p>
     * Set the boolean value for the measurement. No validation is performed by this method, but for measurement limitations see the
     * overview for {@link PulseMeasurementBuilder}.
     * </p>
     *
     * @param value
     *            Boolean value for the measurement.
     * @return This measurement builder. Will not be null.
     * @since 19.1.1
     */
    PulseMeasurementBuilder booleanValue(boolean value);

    /**
     * <p>
     * Set the string value for the measurement No validation is performed by this method, but for measurement limitations see the
     * overview for {@link PulseMeasurementBuilder}.
     * </p>
     *
     * @param value
     *            String value for the measurement.
     * @return This measurement builder. Will not be null.
     * @since 19.1.1
     */
    PulseMeasurementBuilder stringValue(String value);
}
