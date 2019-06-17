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

import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetric;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetricDirection;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetricStorage;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetricType;

/**
 * <p>
 * Builder is used to create a metric definition to be registered via {@link PulseMetricRegistrar#registerMetric(PulseMetric)}.
 * Measurements can not be made against a metric until the metric has been registered with the Pulse framework. Only metrics
 * constructed by this builder are accepted by the Pulse framework.
 * </p>
 * <p>
 * No validation is performed on the properties until {@link #build()} is called. If the validation fails an
 * {@link IllegalStateException} exception will be thrown. Current validations enforced are:
 * </p>
 * <ul>
 * <li>Realm must be specified.</li>
 * <li>Name must be specified.</li>
 * <li>Value type must be specified.</li>
 * <li>If the metric is a {@link PulseMetricType#SCALE} the upper bound must be higher than the lower bound.</li>
 * </ul>
 * <p>
 * The same builder can be used to create multiple metrics, allowing for an expert to generate all the metrics for the same type by
 * setting the valueType on this builder and the varying the other properties. This will mean that {@link PulseMetric} returned from
 * {@link #build()} will all have the same valueType.
 * </p>
 * <p>
 * Each property setter returns this builder allowing property calls to be chained together, e.g.
 * <code>builder.valueType(PulseMetricType.INTEGER).name("Lines of code").build()</code>
 * </p>
 * <p>
 * Registering the same metric more than once is permitted and has no adverse side effects. The second and subsequent calls will
 * return a valid registration that can safely be used to report a measurement for the metric.
 * </p>
 * <p>
 * Registering a metric for a second time allows the following metric properties to be changed:
 * </p>
 * <ul>
 * <li>Description.</li>
 * <li>Direction.</li>
 * </ul>
 *
 * @since 19.1.1
 */
public interface PulseMetricBuilder {

    /**
     * <p>
     * Create a builder that can be used to build metrics to be recorded.
     * </p>
     *
     * @return New measurements builder. Can not be null.
     * @since 19.1.1
     */
    PulseMetric build();

    /**
     * <p>
     * Set the realm the metric belongs to. The core realms are defined by
     * {@link com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetricCoreRealm}. A definition must have a realm, but the realm can
     * be user defined. Realms are used to group together similar types of metrics.
     * </p>
     *
     * @param realm
     *            Realm of metrics this belongs to.
     * @return This metric builder. Can not be null.
     * @since 19.1.1
     */
    PulseMetricBuilder realm(String realm);

    /**
     * <p>
     * Set the name of the metric. This will uniquely identify the metric within the experts namespace which allows metrics from
     * different experts to have the same name. A name must be specified and can not be null or empty. The name will be displayed in
     * the user interface.
     * </p>
     *
     * @param name
     *            Name of the metric local to the plugin it belongs to.
     * @return This metric builder. Can not be null.
     * @since 19.1.1
     */
    PulseMetricBuilder name(String name);

    /**
     * <p>
     * Set the description of the metric. This will be displayed in the user interface to aid the user in understanding the metric.
     * It is an optional property.
     * </p>
     *
     * @param description
     *            Short description for this metric.
     * @return This metric builder. Can not be null.
     * @since 19.1.1
     */
    PulseMetricBuilder description(String description);

    /**
     * <p>
     * Set the type of value the metric measurement will be. This is not optional and can not be changed once the metric has been
     * registered.
     * </p>
     *
     * @param valueType
     *            The type of the value for a measurement of this metric.
     * @since 19.1.1
     * @return This metric builder. Can not be null.
     */
    PulseMetricBuilder valueType(PulseMetricType valueType);

    /**
     * <p>
     * Set how the measurements will be stored. By default the storage property is {@link PulseMetricStorage#DATABASE} and therefore
     * measurements are stored in the database. If the measurement is only used to generate another measurement, then the storage
     * should be set to {@link PulseMetricStorage#TRANSIENT} so that the measurement is discarded once the expert has completed.
     * </p>
     *
     * @param storage
     *            How to store the measurement. By default all metrics are stored in the database.
     * @return This metric builder. Can not be null.
     * @since 19.1.1
     */
    PulseMetricBuilder storage(PulseMetricStorage storage);

    /**
     * <p>
     * Set the meaning of a directional change for this measurement. This is used by Pulse to make an informed decision on whether
     * an increase in value is good or bad.
     * </p>
     *
     * @param direction
     *            Indicates if an increasing value is better or worse
     * @return This metric builder. Can not be null.
     * @since 19.1.1
     */
    PulseMetricBuilder direction(PulseMetricDirection direction);

    /**
     * <p>
     * Set the lower bound for a {@link PulseMetricType#SCALE} type of metric.
     * </p>
     *
     * @param lowerScaleBound
     *            For a scale metric, this is the lower bound
     * @return This metric builder. Can not be null.
     * @since 19.1.1
     */
    PulseMetricBuilder lowerScaleBound(double lowerScaleBound);

    /**
     * <p>
     * Set the upper bound for a {@link PulseMetricType#SCALE} type of metric.
     * </p>
     *
     * @param upperScaleBound
     *            For a scale metric, this is the upper bound
     * @return This metric builder. Can not be null.
     * @since 19.1.1
     */
    PulseMetricBuilder upperScaleBound(double upperScaleBound);
}
