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

/**
 * Represents a user within the system.
 */
public interface PulseUser {
    /**
     * Login name for the user.
     *
     * @return Never null.
     */
    String getLoginName();

    /**
     * Optional display name for the user.
     *
     * @return Maybe null if the user does not have a display name.
     */
    String getDisplayName();

    /**
     * Optional email address for the user.
     *
     * @return Maybe null if the user does not have a email address.
     */
    String getEmailAddress();
}
