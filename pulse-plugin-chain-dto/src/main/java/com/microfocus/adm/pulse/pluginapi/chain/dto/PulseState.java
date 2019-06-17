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
 * Indicates the state of the chain plugin to the Pulse framework. A chain plugin must return one of these values at the end of a
 * {@link com.microfocus.adm.pulse.pluginapi.chain.PulseChainStepPlugin#doStep(PulseChainContext)} method.
 * </p>
 * <p>
 * The state can be one of:
 * </p>
 * <ul>
 * <li>{@link #COMPLETED_SUCCESS}</li>
 * <li>{@link #COMPLETED_UNSTABLE}</li>
 * <li>{@link #COMPLETED_FAILURE}</li>
 * <li>{@link #COMPLETED_ABORTED}</li>
 * <li>{@link #CONTINUE_NOTSTARTED}</li>
 * <li>{@link #CONTINUE_INPROGRESS}</li>
 * </ul>
 *
 * @since CM_14.2
 */
public enum PulseState {
    /**
     * <p>
     * Expert run is successful.
     * </p>
     *
     * @since CM_14.2
     */
    COMPLETED_SUCCESS,

    /**
     * <p>
     * Expert run is unstable.
     * </p>
     *
     * @since CM_14.2
     */
    COMPLETED_UNSTABLE,

    /**
     * <p>
     * Expert run failed.
     *
     * @since CM_14.2
     */
    COMPLETED_FAILURE,

    /**
     * <p>
     * Expert run is aborted because of error.
     * </p>
     *
     * @since CM_14.2
     */
    COMPLETED_ABORTED,

    /**
     * <p>
     * Expert has queued something with an external process and keeps working.
     * </p>
     * <p>
     * Use it when register callback only, otherwise returned value will be treated as {@link #COMPLETED_ABORTED}.
     * </p>
     *
     * @since CM_14.2
     */
    CONTINUE_NOTSTARTED,

    /**
     * <p>
     * Expert has started an external process and waiting on it.
     * </p>
     * <p>
     * Use it when register callback only, otherwise returned value will be treated as {@link #COMPLETED_ABORTED}.
     * </p>
     *
     * @since CM_14.2
     */
    CONTINUE_INPROGRESS,

    /**
     * <p>
     * Expert sends a signal to stop the chain. Can be returned from both expert and callback classes at any time. Any registered
     * callback is ignored.
     * </p>
     *
     * @since CM_14.3
     */
    TERMINATE_CHAIN
}
