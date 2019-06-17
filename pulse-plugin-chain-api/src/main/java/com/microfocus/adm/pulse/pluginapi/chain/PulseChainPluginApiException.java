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

import com.microfocus.adm.pulse.pluginapi.PulsePluginApiException;

public class PulseChainPluginApiException extends PulsePluginApiException {
    public PulseChainPluginApiException() {
        super();
    }

    public PulseChainPluginApiException(final Throwable t) {
        super(t.getMessage(), t);
    }

    public PulseChainPluginApiException(final String message, final Throwable t) {
        super(message, t);
    }

    public PulseChainPluginApiException(final String message) {
        super(message);
    }
}
