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
 * Allow a plugin to access the console log for the chain run.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseConsoleLoggerAware {
    /**
     * <p>
     * Sets the {@link PulseConsoleLogger} that can be used to write to the console log for the chain run. Note that the console
     * logger logs all levels and allows them to be filtered at a later date in the Pulse UI.
     * </p>
     *
     * @param consoleLogger
     *            Logger for the console. Will not be null.
     *
     * @see PulseConsoleLogger
     * @since 19.1.1
     */
    void setConsoleLogger(PulseConsoleLogger consoleLogger);
}
