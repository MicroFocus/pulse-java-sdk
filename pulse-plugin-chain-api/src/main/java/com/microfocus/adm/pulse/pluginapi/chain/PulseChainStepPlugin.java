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

import com.microfocus.adm.pulse.pluginapi.PulsePlugin;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseChainContext;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseState;

/**
 * <p>
 * Every chain step plugin implemented in Java must provide an implementation of this interface which is used to ask the plugin to
 * inspect one or more changesets. Pulse will automatically scan for plugins at start-up and attempt to register the plugins.
 * </p>
 * <p>
 * Plugins that are run after the step has completed to capture findings from the console or files do not need to implement this
 * interface, they can implement {@link PulseFindingsInConsolePlugin} or {@link PulseFindingsInFilePlugin} instead.
 * </p>
 * <p>
 * During start-up, Pulse will scan the plugins looking for a <code>com.serena.starlight.experts</code> file normally located in the
 * containing JAR files <code>META-INF/experts</code> resource directory. Each of the Pulse chain step plugins implemented in the
 * JAR file should be listed in the file with each full class name listed on a separate line. For every class listed in the file,
 * Pulse will instantiate an instance in order to register the metrics and extract information from the associated
 * {@link com.microfocus.adm.pulse.pluginapi.chain.annotations.PulseChainStepPluginDefinition} annotation. The file allows the use
 * of * <code>#</code> at the start of a line to indicate a comment.
 * </p>
 * <p>
 * Although a chain step plugin can register metrics at any time it is preferable to register them using the
 * {@link com.microfocus.adm.pulse.pluginapi.chain.annotations.Metric} annotation so that they are available to users in reports
 * etc, before the plugin has been run for the first time.
 * </p>
 * <p>
 * When a chain is being processed a new instance of the class that provides the implementation of this class will be instantiated
 * by Pulse. Once then chain has completed, Pulse will consider the instance spent and will dispose of it. It is possible to have
 * static resources within an expert, for expensive resources but they will not be notified of the application closing and are not
 * recommended if this could be an issue.
 * </p>
 * Interface for the main class that makes up a Pulse expert implementation.
 *
 * @since 19.1.1
 */
public interface PulseChainStepPlugin extends PulsePlugin {
    /**
     * Optional method called before the step is to be executed, but after the plugin has been wired with the "Aware" interfaces and
     * its configuration.
     *
     * @param chainContext
     *            Context the step is running in.
     * @throws PulseChainStepPluginException
     *             If a fatal error occurs, a plugin should throw this interface.
     * @since 19.1.1
     */
    default void beforeStep(PulseChainContext chainContext) throws PulseChainStepPluginException {
    }

    /**
     * Plugins should do the majority of their work in this method call.
     *
     * @param chainContext
     *            Context the step is running in.
     * @return If a fatal error occurs, a plugin should throw this interface.
     * @throws PulseChainStepPluginException
     *             If a fatal error occurs, a plugin should throw this interface.
     * @since 19.1.1
     */
    default PulseState doStep(PulseChainContext chainContext) throws PulseChainStepPluginException {
        return PulseState.COMPLETED_SUCCESS;
    }

    /**
     * Optional method called after the step has executed.
     *
     * @param chainContext
     *            Context the step is running in.
     * @throws PulseChainStepPluginException
     *             If a fatal error occurs, a plugin should throw this interface.
     * @since 19.1.1
     */
    default void afterStep(PulseChainContext chainContext) throws PulseChainStepPluginException {
    }
}
