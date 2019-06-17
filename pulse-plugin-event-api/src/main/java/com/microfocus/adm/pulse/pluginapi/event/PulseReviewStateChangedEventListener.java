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

package com.microfocus.adm.pulse.pluginapi.event;

import com.microfocus.adm.pulse.pluginapi.event.dto.PulseReview;
import com.microfocus.adm.pulse.pluginapi.event.dto.PulseReviewState;

/**
 * <p>
 * Listener interface called when a review state changes.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseReviewStateChangedEventListener extends PulseReviewEventPlugin {
    /**
     * <p>
     * Called to tell the plugin when a review changes state.
     * </p>
     *
     * @param review
     *            Details about the review that changed state.
     * @param oldState
     *            Old state of the review.
     * @param newState
     *            New state of the review.
     * @since 19.1.1
     */
    void reviewStateChanged(PulseReview review, PulseReviewState oldState, PulseReviewState newState) throws Exception;
}
