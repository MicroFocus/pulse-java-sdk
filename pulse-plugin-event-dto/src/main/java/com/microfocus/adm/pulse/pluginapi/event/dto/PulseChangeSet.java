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

package com.microfocus.adm.pulse.pluginapi.event.dto;

import java.util.Date;
import java.util.List;

/**
 * Represents a changeset
 */
public interface PulseChangeSet {
    /**
     * Date when the changeset was delivered.
     *
     * @return Date of the changeset
     */
    Date getDate();

    /**
     * Commit message for the changeset.
     *
     * @return Message for the changeset.
     */
    String getMessage();

    /**
     * Identifier in the SCM for the changeset, i.e. the forest version for DCM or the hash for Git.
     *
     * @return Identifier of the changeset.
     */
    String getIdentifier();

    /**
     * Login for the author of the changeset.
     *
     * @return Changeset authors login
     */
    String getLoginName();

    /**
     * Optional email address of the author.
     *
     * @return Email address of the author or null if not available.
     */
    String getEmailAddress();

    /**
     * Branch the changeset was delivered on.
     *
     * @return Details of the branch containing the changeset.
     */
    PulseBranch getBranch();

    /**
     * Optional list of changes that make up the changeset. Not all events will include this information.
     *
     * @return Optional list of changes. If not available will be null.
     */
    List<PulseChangeSetChange> getChanges();

    /**
     * Optional list of requests that the changeset was associated with.
     *
     * @return List of requests. If not available will be null. If the changeset has no associated requests, will be an empty
     *         collection.
     */
    List<PulseRequest> getRequests();

    /**
     * Repository the changeset came from.
     *
     * @return Details of the repository the changeset came from.
     */
    PulseRepository getRepository();

    /**
     * If the changeset if provided as part of a chain event, this flag indicates that the changeset was a contributor to the chain
     * run. If not part of a chain event, the flag is false.
     *
     * @return Indicates changeset contributed to a chain run.
     */
    boolean isChainRunContributor();
}
