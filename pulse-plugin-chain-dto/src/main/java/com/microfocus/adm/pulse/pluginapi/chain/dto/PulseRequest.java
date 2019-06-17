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
 * Where a changeset is associated with a request, this interface provides a means of requesting additional information about the
 * request.
 * </p>
 * <p>
 * Note: Requesting the status or title of the request may be a costly operation and may not be cached by Pulse.
 * </p>
 *
 * @since CM_14.2
 */
public interface PulseRequest {
    /**
     * <p>
     * The request label associated with the changeset.
     * </p>
     *
     * @return Request label
     * @since CM_14.2
     */
    String getLabel();

    /**
     * <p>
     * The request id associated with the changeset.
     * </p>
     *
     * @return Request identifier
     * @since CM_14.2
     */
    String getId();

    /**
     * <p>
     * Get the status of the request from the request system.
     * </p>
     *
     * @return Status of the request.
     * @since CM_14.2
     */
    String getStatus();

    /**
     * <p>
     * Get the title of the request from the request system.
     * </p>
     *
     * @return Title of the request.
     * @since CM_14.2
     */
    String getTitle();
}
