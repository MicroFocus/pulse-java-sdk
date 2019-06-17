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

import com.microfocus.adm.pulse.pluginapi.event.dto.PulseEmail;

/**
 * <p>
 * The email reporter allows experts to report email messages.
 * </p>
 * <p>
 * Emails should be built using the {@link PulseEmailBuilder} returned by {@link #getEmailBuilder()}.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseEmailService {

    /**
     * <p>
     * Create a builder that can be used to build emails to be sent by this reporter.
     * </p>
     *
     * @return New emails builder. Can not be null.
     * @since 19.1.1
     */
    PulseEmailBuilder getEmailBuilder();

    /**
     * <p>
     * Send an email {@link PulseEmail} created by builder {@link PulseEmailBuilder}.
     * </p>
     *
     * @param email
     *            Email to be sent. Must have come from the {@link PulseEmailBuilder} returned by {@link #getEmailBuilder()}.
     * @since 19.1.1
     */
    void sendEmail(String repositoryKey, PulseEmail email);
}
