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

import java.util.List;

/**
 * Represents a review within the system.
 */
public interface PulseReview {
    /**
     * Label for the review. Unique within the system.
     *
     * @return Never null and can be used as a key for the review.
     */
    String getLabel();

    /**
     * Title of the review which can be changed by a user over time.
     *
     * @return Never null.
     */
    String getTitle();

    /**
     * Text that describes the review, normally the commit message of the first changeset.
     *
     * @return Never null.
     */
    String getBody();

    /**
     * Get the type of review
     * @return Never null.
     */
    PulseReviewType getReviewType();

    /**
     * Current state of the review, which might be a later state than the notification is for.
     *
     * @return Current state of the review.
     */
    PulseReviewState getState();

    /**
     * Who currently owns the review, normally the changeset author
     *
     * @return Null if there is no owner.
     */
    PulseUser getOwner();

    /**
     * List of reviewers for the review.
     *
     * @return List of reviewers
     */
    List<PulseReviewer> getReviewers();

    /**
     * Set of requests that are associated with the changesets for the review. This is captured when the changesets are attached to
     * the review.
     *
     * @return Empty collection if no requests are associated with the review.
     */
    List<PulseRequest> getRequests();

    /**
     * Set of changesets (in date order) that make up the review.
     *
     * @return Changesets being reviewed.
     */
    List<PulseChangeSet> getChangeSets();
}
