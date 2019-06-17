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

import java.util.Collection;

import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseChange;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMeasurement;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetric;

/**
 * <p>
 * The measurement reporter is used by the experts to record measurements of the experts metrics. Measurements can't be made of
 * metrics that haven't been registered yet and will be ignored if they are attempted. Also an expert can't provide a measurement of
 * a metric owned by another expert.
 * </p>
 *
 * <p>
 * The current version of the Pulse framework only accepts one measurement per metric.
 * </p>
 *
 * <p>
 * For more information see {@link PulseMetricRegistrar} where the types of metrics are discussed.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseMeasurementReporter {

    /**
     * <p>
     * Create a builder that can be used to build measurements to be recorded.
     * </p>
     *
     * @return New measurements builder. Can not be null.
     * @since 19.1.1
     */
    PulseMeasurementBuilder getMeasurementBuilder();

    /**
     * <p>
     * Returns the definitions of the metrics that have had a measurement reported to this measurement reporter.
     * </p>
     *
     * @return Metrics that have been recorded with this reporter. Can not be null.
     * @since 19.1.1
     */
    Iterable<PulseMetric> getMeasuredMetrics();

    /**
     * <p>
     * Add the supplied measurement to the measurement recordings. The metric this is a measurement for must have been registered
     * before this is called.
     * </p>
     *
     * @param measurement
     *            Measurement to be recorded.
     * @since 19.1.1
     */
    void addMeasurement(PulseMeasurement measurement);

    /**
     * <p>
     * Add the supplied measurements to the measurement recordings. The metrics these are a measurement for must have been
     * registered before this is called. The measurements can be for different metrics.
     * </p>
     *
     * @param measurements
     *            Measurements to be recorded.
     * @since 19.1.1
     */
    void addAllMeasurements(Collection<PulseMeasurement> measurements);

    /**
     * <p>
     * Return the measurements taken for the supplied metric. If no measurements have been made for the supplied metric an empty
     * array will be returned.
     * </p>
     *
     * @param metric
     *            Metric to return the measurements for.
     * @return Measurements for the metric.
     * @since 19.1.1
     */
    Collection<PulseMeasurement> getMeasurementsForMetric(PulseMetric metric);

    /**
     * <p>
     * Returns the collection of changes that have been measured by this measurement reporter. Measurements are related to
     * {@link PulseChange} objects via the {@link PulseMeasurement#getPath()} property.
     * </p>
     *
     * @return Changes in the changeset that have been measured.
     * @since 19.1.1
     */
    Collection<PulseChange> getChangesMeasured();

    /**
     * <p>
     * Returns the collection of measurements that have been made against the selected change.
     * </p>
     *
     * @param change
     *            Change to return measurements for.
     * @return Measurements made against the change. Can not be null.
     * @since 19.1.1
     */
    Collection<PulseMeasurement> getMeasurementsForChange(PulseChange change);

    /**
     * <p>
     * Returns the collection of measurements that have been made against the changeset but not against a particular change.
     * </p>
     *
     * @return Measurements made. Can not be null.
     * @since 19.1.1
     */
    Collection<PulseMeasurement> getGlobalMeasurements();
}
