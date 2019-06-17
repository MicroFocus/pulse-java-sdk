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

import com.microfocus.adm.pulse.pluginapi.event.dto.PulseChainRun;

/**
 * <p>
 * Plugins that implement this interface will receive a notification when a chain finishes.
 * </p>
 * <p>
 * See also {@link PulseChainStartedEventListener} and {@link PulseChainQueuedEventListener}.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseChainFinishedEventListener extends PulseChainEventPlugin {
    /**
     * <p>
     * Chain has finished running. Only the primary Pulse will generate these events.
     * </p>
     *
     * @param run
     *            Details about the chain run.
     * @since 19.1.1
     */
    void chainFinished(PulseChainRun run);
}
