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

/**
 * <p>
 * Implement to receive the {@link PulseMeasurementReporter} instance to use to report measurements of metrics to Pulse.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseMeasurementReporterAware {
    /**
     * <p>
     * Receives the {@link PulseMeasurementReporter} used to record measurements for previously registered metrics. Only metrics
     * registered using the {@link PulseMetricRegistrar} set by
     * {@link PulseMetricRegistrarAware#setMetricRegistrar(PulseMetricRegistrar)} can be recorded. See
     * {@link PulseMetricRegistrar}, {@link com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetric} and
     * {@link com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMeasurement} for more details about metrics and how to record values
     * for them.
     * </p>
     *
     * @param measurementReporter
     *            Measurement reporter the expert should use. Can not be null.
     * @since 19.1.1
     */
    void setMeasurementReporter(PulseMeasurementReporter measurementReporter);
}
