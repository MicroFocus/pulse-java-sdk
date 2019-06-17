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
 * Marks a property as being tokenized and requiring the tokens to be replaced. Applying this to a property will ensure that the
 * plugin receives a value with the tokens replaced. The default is to do token replacement.
 * </p>
 *
 * @since 19.1.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface TokenisedProperty {
    /**
     * <p>
     * Control whether the property is subject to token replacement. The default is to pass a property value through the token
     * replacement engine, but setting this to false will prevent that.
     * </p>
     *
     * @return True if the property should be subjected to token replacement.
     * @since 19.1.1
     */
    boolean value() default true;
}
