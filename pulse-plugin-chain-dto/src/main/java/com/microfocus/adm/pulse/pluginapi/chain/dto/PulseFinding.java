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

package com.microfocus.adm.pulse.pluginapi.chain.dto;

/**
 * <p>
 * Represents something that has been discovered about either the whole file or a particular line in the file. Findings can also be
 * reported against directories and can be thought of as being like compiler warnings, errors or static analysis issues. They allow
 * an expert to mark things of interest that will be show up in a Pulse review so that a reviewer can use the information to make
 * informed decisions on the changeset.
 * </p>
 * <p>
 * Findings reported against a whole file or directory will have a line number of 0.
 * </p>
 *
 * @since CM_14.2
 */
public interface PulseFinding {
    /**
     * <p>
     * Gets the type of finding this instance represents. See {@link PulseFindingType} for a description of each type.
     * </p>
     *
     * @return Type of finding
     * @since CM_14.2
     */
    PulseFindingType getType();

    /**
     * <p>
     * Gets the path of the item in the changeset the finding is associated with. The path is always the "after" path of the change
     * in the changeset this finding relates to.
     * </p>
     *
     * @return Path the finding is associated with. Can not be null.
     * @since CM_14.2
     */
    String getPath();

    /**
     * <p>
     * Gets the line number the finding is associated with. If the finding is for the whole file or a directory, the line number
     * will be 0.
     * </p>
     *
     * @return Line number for the finding.
     * @since CM_14.2
     */
    int getLine();

    /**
     * <p>
     * Gets the label for the message. This will be displayed with the message within the user interface and can be something that
     * identifies the message, i.e. a compiler error number or a security alert reference.
     * </p>
     *
     * @return Label associated with the finding.
     * @since CM_14.2
     */
    String getLabel();

    /**
     * <p>
     * Gets the message that describes the finding the expert has made for the item. This is the string that will be displayed to
     * users within the Pulse user interface and will be made available via any REST api.
     * </p>
     *
     * @return Message describing the finding.
     * @since CM_14.2
     */
    String getMessage();

    /**
     * <p>
     * Gets the severity of the finding. This should be viewed as an indication of how bad the finding is shown to users within the
     * Pulse user interface. See {@link PulseFindingSeverity} for suggestions about when to use each severity.
     * </p>
     *
     * @return Severity of the finding.
     * @since CM_14.2
     */
    PulseFindingSeverity getSeverity();

    /**
     * <p>
     * Ascending number that can be used to determine the order in which findings were presented to the reporter for an expert
     * instance.
     * </p>
     *
     * @return Sequence number for the finding.
     * @since CM_14.2
     */
    int getSequence();
}
