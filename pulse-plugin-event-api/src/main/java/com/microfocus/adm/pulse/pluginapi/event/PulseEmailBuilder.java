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

import java.util.List;

import com.microfocus.adm.pulse.pluginapi.event.dto.PulseEmail;

/**
 * <p>
 * Used to create emails that will be sent using {@link PulseEmailService}.
 * </p>
 * <p>
 * The same builder can be used to create multiple emails.
 * </p>
 * <p>
 * Each property setter returns this builder allowing property calls to be chained together, e.g.
 * <code>builder.to(Arrays.asList("dmsys", "dawn")).subject("message subject").body("message body").build()</code>
 * </p>
 * <p>
 * At least one recipient which is Pulse login name must be provided in {@link #to(List)} or {@link #cc(List)} or {@link #bcc(List)}
 * methods to successfully build an email. Attempting to build an email with no recipients will result in an
 * {@link IllegalStateException} being thrown by the {@link #build()} method.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseEmailBuilder {

    /**
     * <p>
     * Create a new {@link PulseEmail} using the current properties of this builder.
     * </p>
     *
     * @return New {@link PulseEmail}. Can not be null.
     * @exception IllegalStateException
     *                thrown if the {@link PulseEmail} recipient doesn't provided.
     * @since 19.1.1
     */
    PulseEmail build();

    /**
     * <p>
     * Set the list of recipients from Pulse users for whom this email will be sent in the TO emails field. At least one recipient
     * must be provided in <code>#to(List)</code> or {@link #cc(List)} or {@link #bcc(List)} methods to successfully build an email.
     * Attempting to build an email with no recipients will result in an {@link IllegalStateException} being thrown by the
     * {@link #build()} method.
     * </p>
     *
     * @param recipients
     *            List of recipients from Pulse login names to send.
     * @return This builder to allow chaining.
     * @since 19.1.1
     */
    PulseEmailBuilder to(List<String> recipients);

    /**
     * <p>
     * Set the list of recipients from Pulse users for whom this email will be sent in the CC emails field. At least one recipient
     * must be provided in {@link #to(List)} or <code>#cc(List)</code> or {@link #bcc(List)} methods to successfully build an email.
     * Attempting to build an email with no recipients will result in an {@link IllegalStateException} being thrown by the
     * {@link #build()} method.
     * </p>
     *
     * @param recipients
     *            List of recipients from Pulse login names to send.
     * @return This builder to allow chaining.
     * @since 19.1.1
     */
    PulseEmailBuilder cc(List<String> recipients);

    /**
     * <p>
     * Set the list of recipients from Pulse users for whom this email will be sent in the BCC emails field. At least one recipient
     * must be provided in {{@link #to(List)} or {@link #cc(List)} or <code>#bcc(List)</code> methods to successfully build an
     * email. Attempting to build an email with no recipients will result in an {@link IllegalStateException} being thrown by the
     * {@link #build()} method.
     * </p>
     *
     * @param recipients
     *            List of recipients from Pulse login names to send.
     * @return This builder to allow chaining.
     * @since 19.1.1
     */
    PulseEmailBuilder bcc(List<String> recipients);

    /**
     * <p>
     * Set the message subject that will be sent to Pulse users for this email.
     * </p>
     *
     * @param subject
     *            Subject of email message to be sent.
     * @return This builder to allow chaining.
     * @since 19.1.1
     */
    PulseEmailBuilder subject(String subject);

    /**
     * <p>
     * Set the message body that will be sent to Pulse users for this email. The body message allows HTML or Plain text. The message
     * has limit on the length of the body in 1MB. Attempting to build an email with body size greater then 1MB will result in
     * truncated message to 1MB.
     * </p>
     *
     * @param body
     *            Body of email message to be sent.
     * @return This builder to allow chaining.
     * @since 19.1.1
     */
    PulseEmailBuilder body(String body);
}
