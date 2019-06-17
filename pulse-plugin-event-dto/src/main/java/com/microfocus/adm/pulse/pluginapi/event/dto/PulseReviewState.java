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

public enum PulseReviewState {
    NOT_AVAILABLE           /* no review. This can be only used in DTOs for null reviews. */,
    DRAFT                   /* review still being put together by owner */,
    IN_REVIEW               /* published for review by reviewers */,
    REWORK                  /* reviewers sent for rework by owner */,
    APPROVED                /* review has been approved by reviewers */,
    COMPLETED               /* review is ended with positive result */,
    ABANDONED               /* review is ended with ambiguous result */,
    APPROVED_IN_MERGE       /* approved PR review is merging to parent stream */,
    APPROVED_MERGE_FAILURE  /* approved PR review failed to merge to parent stream */,
    NEW                     /* new review */
}
