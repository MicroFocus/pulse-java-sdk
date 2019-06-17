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

public enum PulseChainRunState {
    /**
     * <p>
     * Chain run is successful.
     * </p>
     *
     * @since CM_14.5
     */
    COMPLETED_SUCCESS,

    /**
     * <p>
     * Chain run is unstable.
     * </p>
     *
     * @since CM_14.5
     */
    COMPLETED_UNSTABLE,

    /**
     * <p>
     * Chain run failed.
     *
     * @since CM_14.5
     */
    COMPLETED_FAILURE,

    /**
     * <p>
     * Chain run is aborted because of error.
     * </p>
     *
     * @since CM_14.5
     */
    COMPLETED_ABORTED,

    /**
     * <p>
     * Chain has queued something with an external process and keeps working.
     * </p>
     * <p>
     * Use it when register callback only, otherwise returned value will be treated as {@link #COMPLETED_ABORTED}.
     * </p>
     *
     * @since CM_14.5
     */
    CONTINUE_NOTSTARTED,

    /**
     * <p>
     * Chain has started an external process and waiting on it.
     * </p>
     * <p>
     * Use it when register callback only, otherwise returned value will be treated as {@link #COMPLETED_ABORTED}.
     * </p>
     *
     * @since CM_14.5
     */
    CONTINUE_INPROGRESS,

    /**
     * <p>
     * Chain sends a signal to stop the chain. Can be returned from both expert and callback classes at any time. Any registered
     * callback is ignored.
     * </p>
     *
     * @since CM_14.5
     */
    TERMINATE_CHAIN
}
