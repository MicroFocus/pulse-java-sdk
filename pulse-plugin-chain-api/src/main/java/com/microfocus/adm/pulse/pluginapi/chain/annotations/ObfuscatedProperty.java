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
 * Marks a property as being obfuscated, for example a password. Applying this to a property will ensure that the plugin receives
 * the un-obfuscated value. It can also be used to mark a property as not requiring de-obfuscating, although the default when a
 * property has this annotation is to de-obfuscate.
 * </p>
 *
 * @since 19.1.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface ObfuscatedProperty {
    /**
     * <p>
     * Control whether this property should be de-obfuscated before the plugin receives it.
     * </p>
     *
     * @return True if the property should be de-obfuscated.
     * @since 19.1.1
     */
    boolean value() default true;
}
