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

/**
 * <p>
 * The metrics registrar is used by the experts to register metrics. Measurements can't be made of metrics that haven't been
 * registered yet and will be ignored if they are attempted. Also an expert can't provide a measurement of a metric owned by another
 * expert.
 * </p>
 *
 * <p>
 * Metrics can be broken down into two variants, functional and static.
 * </p>
 *
 * <p>
 * Static metrics are single measurements calculated and recorded once. Multiple instances can be recorded by a plugin, but only if
 * they are recorded against a path, and then only once per path.
 * </p>
 *
 * <p>
 * When registering a metric, an expert must also declare whether measurements of the metric should be stored in the database or if
 * they are transient values, that are discarded at the end of an evaluation.
 * </p>
 *
 * <p>
 * Each metric belongs to an expert, but also is defined by a realm and name. Realms can span across experts and are used to group
 * metrics together into groups, i.e. "SIZE", "TEST", "COMPLEXITY", or "PERFORMANCE". Built in realms are defined by the enum
 * {@link com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetricCoreRealm} but are passed into the registration methods as strings
 * to allow experts to have their own.
 * </p>
 *
 * <p>
 * The name of the metric should be unique within the expert. Metrics are actually known by their FQN which is made up of the expert
 * FQN, realm and metric name.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseMetricRegistrar {

    /**
     * <p>
     * Get a builder that can be used to provide the properties that make up the metric being registered. Every call to this method
     * will return a new build with no properties set, however it is acceptable to reuse a single builder where metrics are similar.
     * </p>
     *
     * @return Builder to be used to provide the metric properties.
     * @since 19.1.1
     */
    PulseMetricBuilder getMetricBuilder();

    /**
     * <p>
     * Given a metric created by the PulseMetricBuilder, registers a metric with the system. The returned instance should be used
     * when recording measurements.
     * </p>
     *
     * @param metric
     *            Metric to register.
     * @return Registration of the metric.
     * @throws PulseMetricNotRegisteredException
     *             If the metric fails to be be registered this is thrown.
     * @since 19.1.1
     */
    PulseMetric registerMetric(PulseMetric metric) throws PulseMetricNotRegisteredException;

    /**
     * <p>
     * Return the metric for the name local to the expert. Throws PulseMetricNotFoundException if no matching metric.
     * </p>
     *
     * @param name
     *            Name of the metric.
     * @return Metric matching the name
     * @since 19.1.1
     */
    PulseMetric findByName(String name) throws PulseMetricNotFoundException;

    /**
     * <p>
     * Return the metric for the fully qualified name. Throws PulseMetricNotFoundException if no matching metric.
     * </p>
     *
     * @param fqn
     *            Fully qualified name of the metric
     * @return Metric matching the fqn
     * @since 19.1.1
     */
    PulseMetric findByFqn(String fqn) throws PulseMetricNotFoundException;
}
