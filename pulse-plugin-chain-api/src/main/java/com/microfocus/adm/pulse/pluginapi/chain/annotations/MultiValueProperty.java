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
 * Used to indicate that a value is actually a string containing multiple values. The annotations configuration controls how the
 * string is split into multiple strings. Not needed if the target POJO property is a {@link java.util.List} or
 * {@link java.util.Set} and the default values would be needed, Pulse will assume the defaults.
 * </p>
 *
 * @since 19.1.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface MultiValueProperty {
    /**
     * <p>
     * Separator between the values. By default this is "\n", but if you need another character such as "\t" then control it with
     * this.
     * </p>
     *
     * @return Character that separates the key and value pairs.
     * @since 19.1.1
     */
    String value() default "\n";

    /**
     * <p>
     * Controls how whitespace should be treated when splitting the values. By default whitespace is discarded, but if you want to
     * keep the whitespace for values, set this to "false".
     * </p>
     *
     * @return True if the values should be trimmed of white space.
     * @since 19.1.1
     */
    boolean trim() default true;

    /**
     * <p>
     * Whether to keep empty values, or discard them. By default empty values are discarded, but this can be disabled by setting
     * this to "true".
     * </p>
     *
     * @return True if empty values should be kept.
     * @since 19.1.1
     */
    boolean allowEmpty() default false;
}
