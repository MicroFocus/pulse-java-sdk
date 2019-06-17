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

import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseFinding;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseFindingSeverity;
import com.microfocus.adm.pulse.pluginapi.chain.dto.PulseFindingType;

/**
 * <p>
 * Used to create findings that will be recorded using {@link PulseFindingReporter}. Findings describe issues discovered by an
 * expert about items in a changeset.
 * </p>
 * <p>
 * The same builder can be used to create multiple findings, allowing for an expert to generate all the findings for the same item
 * by setting the path on this builder and the varying the other properties. This will mean that {@link PulseFinding} returned from
 * {@link #build()} will all have the same path value.
 * </p>
 * <p>
 * Each property setter returns this builder allowing property calls to be chained together, e.g.
 * <code>builder.path("/src/main.java").line(10).message("Unreachable code").build()</code>
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseFindingBuilder {
    /**
     * <p>
     * Create a new {@link PulseFinding} using the current properties of this builder.
     * </p>
     *
     * @return New {@link PulseFinding}. Can not be null.
     * @exception IllegalStateException
     *                thrown if the {@link PulseFinding} state would be invalid.
     * @since 19.1.1
     */
    PulseFinding build();

    /**
     * <p>
     * Set the type of finding to build. By default the builder will create {@link PulseFindingType#FILE} findings. Changing the
     * finding type will not reset the path or line number for the builder but if the type does not need them, they will be ignored
     * when the finding is built.
     * </p>
     *
     * @param type
     *            Type of finding to build.
     * @return This builder to allow chaining.
     * @since 19.1.1
     */
    PulseFindingBuilder type(PulseFindingType type);

    /**
     * <p>
     * Set the path the finding relates to. The path is always the "after" path for the associated change in the changeset. A path
     * must be provided to successfully build a {@link PulseFindingType#FILE} or {@link PulseFindingType#LINE} finding. Attempting
     * to build a finding for those types with no path will result in an {@link IllegalStateException} being thrown by the
     * {@link #build()} method.
     * </p>
     *
     * @param path
     *            Path of the change the finding is associated with.
     * @return This builder to allow chaining.
     * @since 19.1.1
     */
    PulseFindingBuilder path(String path);

    /**
     * <p>
     * Set the line number the finding relates to. If the finding is a {@link PulseFindingType#FILE} or
     * {@link PulseFindingType#LINE}, the line number is not required and will be ignored. The line number defaults to 0.
     * </p>
     *
     * @param line
     *            Line number the finding was found on.
     * @return This builder to allow chaining.
     * @since 19.1.1
     */
    PulseFindingBuilder line(int line);

    /**
     * <p>
     * Set the label for the message. This will be displayed with the message within the user interface and can be something that
     * identifies the message, i.e. a compiler error number or a security alert reference.
     * </p>
     *
     * @param label
     *            String version of the label.
     * @return This builder to allow chaining.
     * @since 19.1.1
     */
    PulseFindingBuilder label(String label);

    /**
     * <p>
     * Set the message that will be displayed to Pulse users for this finding. A message must be provided to successfully build a
     * finding. Attempting to build a finding with no message will result in an {@link IllegalStateException} being thrown by the
     * {@link #build()} method.
     * </p>
     *
     * @param message
     *            String that describes the finding in a human readable way.
     * @return This builder to allow chaining.
     * @since 19.1.1
     */
    PulseFindingBuilder message(String message);

    /**
     * <p>
     * Set the severity of the finding. Severity of findings default to {@link PulseFindingSeverity#INFO}.
     * </p>
     *
     * @param severity
     *            Severity of the finding
     * @return This builder to allow chaining.
     * @since 19.1.1
     */
    PulseFindingBuilder severity(PulseFindingSeverity severity);
}
