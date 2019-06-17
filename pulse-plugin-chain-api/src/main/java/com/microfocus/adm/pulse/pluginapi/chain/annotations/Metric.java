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

package com.microfocus.adm.pulse.pluginapi.chain.annotations;

import java.lang.annotation.Repeatable;

import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetricCoreRealm;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetricDirection;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetricStorage;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetricType;

/**
 * <p>
 * Used to register known metrics for a {@link com.microfocus.adm.pulse.pluginapi.chain.PulseChainStepPlugin}. Use of this
 * annotation saves a plugin having to register metrics at run time. It should be applied to the plugin implementation class.
 * </p>
 *
 * @since 19.1.1
 */
@Repeatable(Metrics.class)
public @interface Metric {
    /**
     * See {@link com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetric#getRealm()}
     *
     * @since 19.1.1
     */
    PulseMetricCoreRealm realm();

    /**
     * See {@link com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetric#getDisplayName()}
     *
     * @since 19.1.1
     */
    String name();

    /**
     * See {@link com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetric#getDescription()}
     *
     * @since 19.1.1
     */
    String description();

    /**
     * See {@link com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetric#getValueType()}
     *
     * @since 19.1.1
     */
    PulseMetricType valueType();

    /**
     * See {@link com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetric#getStorage()}
     *
     * @since 19.1.1
     */
    PulseMetricStorage storage() default PulseMetricStorage.DATABASE;

    /**
     * See {@link com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetric#getDirection()}
     *
     * @since 19.1.1
     */
    PulseMetricDirection direction() default PulseMetricDirection.NONE;

    /**
     * See {@link com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetric#getLowerScaleBound()}
     *
     * @since 19.1.1
     */
    double lowerScaleBound() default 0;

    /**
     * See {@link com.microfocus.adm.pulse.pluginapi.chain.dto.PulseMetric#getUpperScaleBound()}
     *
     * @since 19.1.1
     */
    double upperScaleBound() default 0;
}
