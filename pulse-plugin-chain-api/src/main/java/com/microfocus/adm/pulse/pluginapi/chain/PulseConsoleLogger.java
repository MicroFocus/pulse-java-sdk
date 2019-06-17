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
 * Allows logging at different logging levels. Messages can be up to 2000 characters long, but may be truncated if longer.
 * </p>
 *
 * <p>
 * <tt>error</tt> should be used to log serious issues &gt;<br>
 * <tt>warn</tt> for slightly less serious warnings &gt;<br>
 * <tt>info</tt> for informational messages to the user &gt;<br>
 * <tt>debug</tt> for messages used to diagnose issues &gt;<br>
 * <tt>trace</tt> for very fine-grained logging used during development.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseConsoleLogger {
    /**
     * <p>
     * Write the message at the error level. The message supports <code>{}</code> as markers for injecting the * params into the
     * message in the same way as <code>org.slf4j.log</code>.
     * </p>
     *
     * @param message
     *            Message to be written.
     * @param params
     *            Optional parameters for the message.
     * @since 19.1.1
     */
    void error(String message, Object... params);

    /**
     * <p>
     * Write the message at the warn level. The message supports <code>{}</code> as markers for injecting the * params into the
     * message in the same way as <code>org.slf4j.log</code>.
     * </p>
     *
     * @param message
     *            Message to be written.
     * @param params
     *            Optional parameters for the message.
     * @since 19.1.1
     */
    void warn(String message, Object... params);

    /**
     * <p>
     * Write the message at the info level. The message supports <code>{}</code> as markers for injecting the * params into the
     * message in the same way as <code>org.slf4j.log</code>.
     * </p>
     *
     * @param message
     *            Message to be written.
     * @param params
     *            Optional parameters for the message.
     * @since 19.1.1
     */
    void info(String message, Object... params);

    /**
     * <p>
     * Write the message at the debug level. The message supports <code>{}</code> as markers for injecting the * params into the
     * message in the same way as <code>org.slf4j.log</code>.
     * </p>
     *
     * @param message
     *            Message to be written.
     * @param params
     *            Optional parameters for the message.
     * @since 19.1.1
     */
    void debug(String message, Object... params);

    /**
     * <p>
     * Write the message at the trace level. The message supports <code>{}</code> as markers for injecting the * params into the
     * message in the same way as <code>org.slf4j.log</code>.
     * </p>
     *
     * @param message
     *            Message to be written.
     * @param params
     *            Optional parameters for the message.
     * @since 19.1.1
     */
    void trace(String message, Object... params);
}
