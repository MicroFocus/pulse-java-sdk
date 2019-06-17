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

import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseChainStepPluginCategory;

/**
 * <p>
 * Annotation that should be applied to Java implementations of
 * {@linkplain com.microfocus.adm.pulse.pluginapi.chain.PulseChainStepPlugin} to provide default values for <code>groupId</code>,
 * <code>pluginId</code>, <code>version</code>, <code>displayName</code> and <code>description</code> so that the plugin descriptor
 * file, <em>plugin.json</em>, only needs to contain the plugin's <code>className</code>.
 * </p>
 *
 * @since 19.1.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface PulseChainStepPluginDefinition {
    /**
     * <p>
     * Plugin's <code>groupId</code> should be modelled on the reversed domain name, like Java package names are. For example,
     * "<code>com.mycompany.pulseplugins</code>". It should contain components that start with a lowercase letter, contain digits or
     * lowercase letters, and are separated by '<code>.</code>'.
     * </p>
     *
     * @return The plugin's group identifier (normally associated with the plugin's author).
     * @since 19.1.1
     */
    String groupId();

    /**
     * <p>
     * Plugin's <code>pluginId</code> should be a short name that describes what the plugin does and is unique within the
     * <code>groupId</code>. For example, "<code>checklineendings</code>". It should start with a lowercase letter and contain just
     * digits and lowercase letters.
     * </p>
     *
     * @return The plugin's plugin identifier (should uniquely identify this plugin within <code>groupId</code>).
     * @since 19.1.1
     */
    String pluginId();

    /**
     * <p>
     * Plugin's <code>version</code> should be an indication of what changes have happened to a particular plugin by giving each
     * release a comparable version. For example, "<code>1.0.0</code>". It should consist of up to 3 numeric components that are
     * separated by '<code>.</code>'.
     * </p>
     *
     * @return The plugin's version (typically <code>x.y.z</code>, where x, y and z are integers).
     * @since 19.1.1
     */
    String version();

    /**
     * <p>
     * An optional readable name for the plugin to present in the UI.
     * </p>
     *
     * @return The plugin's presentation name.
     * @since 19.1.1
     */
    String displayName() default "";

    /**
     * <p>
     * An optional readable category for the plugin to present in the UI.
     * </p>
     *
     * @return The plugin's category name.
     * @since 19.1.1
     */
    String category() default PulseChainStepPluginCategory.OTHER;

    /**
     * <p>
     * An optional readable description of what the plugin does, which may be presented in some parts of the UI.
     * </p>
     *
     * @return The plugin's presentation description.
     * @since 19.1.1
     */
    String description() default "";
}
