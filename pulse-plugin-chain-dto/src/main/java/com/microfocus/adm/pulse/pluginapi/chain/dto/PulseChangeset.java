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

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Describes the changes that make up the changeset within the repository that is to be analysed by the expert. The changeset
 * represents a single delivery to the repository.
 * </p>
 *
 * @since CM_14.2
 */
public interface PulseChangeset {

    /**
     * <p>
     * Get the UTC date when the changeset was delivered.
     * </p>
     *
     * @return UTC Date.
     * @since CM_14.2
     */
    Date getDate();

    /**
     * <p>
     * Get the location of the directory that contains copies of the files and directories for the changeset pulled from the source
     * repository.The files and directories are in a hierarchy that matches the structure of the files and directories as they were
     * delivered.
     * </p>
     * <p>
     * The directory can be considered to have parity with a workspace but without any supported means of delivering the items.It is
     * worth noting that the content of the directory and its sub-directories may contain additional files from the source control
     * system used to populate the directory.
     * </p>
     *
     * @return Absolute path to the directory.
     * @since CM_14.2
     */
    String getDirectory();

    /**
     * <p>
     * Get the message provided by the user at the time the changeset was committed. Multi-line commit messages are returned in the
     * single string.
     * </p>
     *
     * @return Commit message for the changeset. Can not be null, but can be empty.
     * @since CM_14.2
     */
    String getMessage();

    /**
     * <p>
     * Get the Pulse login name of the user that delivered the changeset.
     * </p>
     *
     * @return Pulse login name. Can not be null or empty.
     * @since CM_14.2
     */
    String getLoginName();

    /**
     * <p>
     * Get a unique identifier of the changeset within the repository. This is equivalent to a changeset ID within the repository.
     * For Dimensions CM repositories, this is the forest version number.
     * </p>
     *
     * @return Unique identifier. Can not be null.
     * @since CM_14.2
     */
    String getId();

    /**
     * <p>
     * Get the unique identifier of the changeset within the stream. For Dimensions CM repositories, this is the stream version
     * number.
     * </p>
     *
     * @return Stream version unique identifier. Can not be null.
     * @since CM_14.2
     */
    String getStreamVersionId();

    /**
     * <p>
     * Get the name of the Pulse stream this changeset is associated with.
     * </p>
     *
     * @return Name of the stream. Can not be null or empty.
     * @since CM_14.2
     */
    String getStreamTitle();

    /**
     * <p>
     * Get the name of the Pulse product this changeset is associated with.
     * </p>
     *
     * @return Name of the product. Can not be null or empty.
     * @since CM_14.2
     */
    String getProductTitle();

    /**
     * <p>
     * Get the name of the Pulse suite this changeset is associated with.
     * </p>
     *
     * @return Name of the suite. Can not be null or empty.
     * @since CM_14.2
     */
    String getSuiteTitle();

    /**
     * <p>
     * Get an opaque string that uniquely identifies the repository. Using this in combination with {@link #getId()} provides a way
     * of uniquely identifying a changeset within a collection of repositories.
     * </p>
     *
     * @return Unique identifier for the repository.
     * @since CM_14.2
     */
    String getScmConnectionUri();

    /**
     * <p>
     * Get a list of changes that made up the changeset. This can be used by an expert to reduce the set of items it works on to
     * just those in the changeset.
     * </p>
     *
     * @return List of changes. Can not be null.
     * @since CM_14.2
     */
    List<PulseChange> getChanges();

    /**
     * <p>
     * Get a list of requests that the changeset was delivered against.
     * </p>
     *
     * @return List of requests. Can not be null.
     * @since CM_14.2
     */
    List<PulseRequest> getRequests();

    /**
     * <p>
     * Get a list of files (not directories) in the workspace that are part of the change. This does not include files that were
     * deleted. If a file was renamed, the file will appear in the list with the new filename. For more details about an individual
     * change associated with one of the paths returned in this array use {@link #getChangeForPath(String)}. For details about all
     * the changes in a changeset see {@link #getChanges()}.
     * </p>
     *
     * @return List of files that were changed as part of the changeset.
     * @since CM_14.2
     */
    List<String> getPaths();

    /**
     * <p>
     * Gets the change associated with the path supplied. The path will be expected to be the after path within the change unless
     * the change was a deletion in which case it will be the before path. If the changes in the workspace include a deletion and
     * addition for the path the addition change will be returned.
     * </p>
     *
     * @param path
     *            Path to return the change for.
     * @return Change for the path or null if there isn't one.
     * @since CM_14.2
     */
    PulseChange getChangeForPath(String path);
}
