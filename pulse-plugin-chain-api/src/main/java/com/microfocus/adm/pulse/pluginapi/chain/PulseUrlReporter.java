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

package com.microfocus.adm.pulse.pluginapi.chain;

/**
 * <p>
 * The URL reporter is used by the experts to report a URL they want to make available to Dimensions Pulse. The URL could be set at
 * any time during expert run and could be available immediately to Pulse.
 * </p>
 *
 * <p>
 * The expected use of the URL reporter is to provide additional details that the expert produced during its run.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseUrlReporter {
    /**
     * <p>
     * Set a URL the expert makes available on its run. This can be updated multiple times, but only the last value is recorded
     * permanently.
     * </p>
     *
     * @param url
     *            URL for the expert run.
     * @since 19.1.1
     */
    void setUrl(String url);
}
