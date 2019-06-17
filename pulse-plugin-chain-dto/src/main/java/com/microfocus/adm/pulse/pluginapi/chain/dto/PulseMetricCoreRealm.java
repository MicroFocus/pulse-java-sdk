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
 * All metrics belong to a realm that helps to group the metrics together into similar blocks of measurement types. This helps the
 * Pulse framework understand what the metric is trying to achieve.
 * </p>
 * <p>
 * New realms can be defined by an expert as a simple string, but these are some that Pulse understands by default:
 * </p>
 * <p>
 * The core realms that {@link PulseMetric} can use:
 * </p>
 * <ul>
 * <li>{@link #SIZE}</li>
 * <li>{@link #BUILD}</li>
 * <li>{@link #TEST}</li>
 * <li>{@link #QUALITY}</li>
 * <li>{@link #SECURITY}</li>
 * </ul>
 *
 * @since CM_14.2
 */
public enum PulseMetricCoreRealm {
    /**
     * Metrics related to sizes/quantity/amounts, e.g. number of files or lines of code
     *
     * @since CM_14.2
     **/
    SIZE,
    /**
     * Metrics related to build or compilation
     *
     * @since CM_14.2
     **/
    BUILD,
    /**
     * Metrics related to testing, e.g. unit testing results
     *
     * @since CM_14.2
     **/
    TEST,
    /**
     * Metrics related to software quality, e.g. static analysis results
     *
     * @since CM_14.2
     **/
    QUALITY,
    /**
     * Metrics related to software security, e.g. security scan metrics
     *
     * @since CM_14.2
     **/
    SECURITY,
    /**
     * Metrics related to fetching/checking out source/items
     *
     * @since CM_14.5
     **/
    CHECKOUT,
    /**
     * Metrics related to execution time
     *
     * @since Pulse 19.1
     **/
    EXECUTION
}
