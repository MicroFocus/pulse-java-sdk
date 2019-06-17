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
 * Describes one change that makes up the changeset. This can be used to work out what the changes that make up a changeset and can
 * be used by an expert to locate the files that may be of interest. Some experts will just be interested in every file in the
 * workspace but others may limit themselves to the files that have changed.
 * </p>
 *
 * @since CM_14.2
 */
public interface PulseChange {

    /**
     * <p>
     * Type of change a {@link PulseChange} represents:
     * </p>
     * <ul>
     * <li>{@link #ADDED}</li>
     * <li>{@link #REMOVED}</li>
     * <li>{@link #MODIFIED}</li>
     * <li>{@link #RENAMED}</li>
     * <li>{@link #RENAMED_AND_MODIFIED}</li>
     * </ul>
     *
     * @since CM_14.2
     */
    enum ChangeType {
        /**
         * Item was added to the repository.
         *
         * @since CM_14.2
         */
        ADDED,
        /**
         * Item was removed from the repository.
         *
         * @since CM_14.2
         */
        REMOVED,
        /**
         * Item was modified.
         *
         * @since CM_14.2
         */
        MODIFIED,
        /**
         * Item was renamed/moved in the repository.
         *
         * @since CM_14.2
         */
        RENAMED,
        /**
         * Item was renamed/movied and modified in a single operation.
         *
         * @since CM_14.2
         */
        RENAMED_AND_MODIFIED
    }

    /**
     * <p>
     * Get a flag that indicates whether the change represents a change to a directory.
     * </p>
     *
     * @return True if the change is about a directory.
     * @since CM_14.2
     */
    boolean isDirectory();

    /**
     * <p>
     * Get the kind of modification this change represents. This can never be null.
     * </p>
     *
     * @return Type of change that was made.
     * @since CM_14.2
     */
    ChangeType getType();

    /**
     * <p>
     * Get the path of the item that was changed before the change was carried out. Will be null if the change type is
     * {@link ChangeType#ADDED} or {@link ChangeType#MODIFIED}. This value is for informational purposes and shouldn't be used to
     * locate the item in the changeset workspace.
     * </p>
     *
     * @return Path of the item before the change.
     * @since CM_14.2
     */
    String getPathBefore();

    /**
     * <p>
     * Get the path after the change. This can be used to locate the file content in the workspace by appending it to the directory
     * returned by {@link PulseChangeset#getDirectory()}. Will be null if the change type is {@link ChangeType#REMOVED}.
     * </p>
     *
     * @return Path of the item after the change.
     * @since CM_14.2
     */
    String getPathAfter();
}
