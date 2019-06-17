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

/**
 * Describes the review comment event that has occurred.
 */
public interface PulseCommentEvent {
    /**
     * @return Type of action that occurred to the comment.
     */
    PulseCommentAction getAction();

    /**
     * @return Unique identifier for the comment thread.
     */
    String getThreadId();

    /**
     * @return Date the comment or response was made.
     */
    Date getDate();

    /**
     * @return Login for the user who made the comment or response.
     */
    String getLoginName();

    /**
     * If the comment is a response to another comment, this is the unique identifier of the response. The threadId holds the
     * identifier of the thread that this comment belongs to.
     *
     * @return Identifier of the comment this is a response to or null if not a response.
     */
    String getResponseId();

    /**
     * If the comment was made in the context of a review, this is the review label.
     *
     * @return Label of the review or null if the comment is made outside of a review.
     */
    String getReviewLabel();

    /**
     * @return Current body of the comment. Valid only for {@link PulseCommentAction#CREATED} and {@link PulseCommentAction#EDITED}
     *         events.
     */
    String getBody();

    /**
     * @return Previous body of the comment. Valid only for {@link PulseCommentAction#EDITED} and {@link PulseCommentAction#DELETED}
     *         events.
     */
    String getPreviousBody();

    /**
     * If the comment is on a file this is the path to the file.
     *
     * @return File path or null if not a comment on a file.
     */
    String getPath();

    /**
     * If the comment is on a file this is the SCM identifier for the file.
     *
     * @return SCM identifier of the file or null if not comment is not for a file.
     */
    String getFileScmId();

    /**
     * SCM identifier of the changeset the file belongs to. Only valid if the comment is about a file.
     *
     * @return Changeset SCM identifier or null if not comment is not for a file.
     */
    String getChangesetId();

    /**
     * If the comment is on a file, this is the starting line number within the file the comment applies to. If the comment is not
     * on a file, then this will be 0.
     *
     * @return First line in the file the comment applies to.
     */
    int getStartLine();

    /**
     * If the comment is on a file, this is the end line number within the file the comment applies to. If the comment is on a
     * single line, then this will be the same as the start line number. If the comment is not on a file, then this will be 0.
     *
     * @return Last line in the file the comment applies to.
     */
    int getEndLine();
}
