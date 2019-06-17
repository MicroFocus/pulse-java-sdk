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
 * For values that are to be assigned to a map, this annotation allows you to control how the conversion of the value is controlled.
 * By default Pulse will assume the key/value pairs of the strings are separated by "=", are to have all white space trimmed, and
 * empty values are allowed.
 * </p>
 *
 * @since 19.1.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface KeyValueProperty {
    /**
     * <p>
     * Separator between the key and value pairs. By default this is "=", but if you need another character such as "\t" then
     * control it with this.
     * </p>
     *
     * @return Character that separates the key and value pairs.
     * @since 19.1.1
     */
    String value() default "=";

    /**
     * <p>
     * Controls how whitespace should be treated when splitting the key and value pairs. By default whitespace is discarded, but if
     * you want to keep the whitespace for values, set this to "false".
     * </p>
     *
     * @return True if the values should be trimmed of white space.
     * @since 19.1.1
     */
    boolean trim() default true;

    /**
     * <p>
     * Whether to keep empty values, or discard them. By default empty values are kept, but this can be disabled by setting this to
     * "false".
     * </p>
     *
     * @return True if empty values should be kept.
     * @since 19.1.1
     */
    boolean allowEmpty() default true;
}
