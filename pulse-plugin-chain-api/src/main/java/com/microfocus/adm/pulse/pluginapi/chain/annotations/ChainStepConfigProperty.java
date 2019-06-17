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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Provides the default value(s) and alternative name for a PulseChainStepPlugin configuration property.lastValue
 * </p>
 *
 * @since 19.1.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface ChainStepConfigProperty {
    /**
     * <p>
     * Alternative name of the property. This allows the POJO property name to be different from the property in the configuration.
     * For example if you rename the POJO property, you can use this to specify the old name in the configuration without providing
     * any upgrade steps to convert the old name.
     * </p>
     *
     * @since 19.1.1
     */
    String name() default "";

    /**
     * <p>
     * Provides the default value for the property. Note that if the target property is a long or integer then Pulse will attempt to
     * convert this value into the correct type. Likewise if the target is a list, this value can be a list of values where the
     * separator is controlled by {@link MultiValueProperty}.
     * </p>
     *
     * @since 19.1.1
     */
    String value() default "";

    /**
     * <p>
     * Sequence of default values. Like {@link #value()} but where the first value that changes after being passed through the
     * tokenizer is used. This allows you to specify a number of tokenize values to use as the default and have the first one that
     * has a value to be used. If non of the values are replace, the last value is taken.
     * </p>
     * <p>
     * Can be useful if you want to allow some variables to act as a default, i.e. "${tool.path}", "tool" would use the variable for
     * "tool.path" if defined, otherwise it would use "tool" as a value.
     * </p>
     * <p>
     * Like {@link #value()}, Pulse will try and coerce the value into the correct type.
     * </p>
     *
     * @since 19.1.1
     */
    String[] firstOf() default {};
}
