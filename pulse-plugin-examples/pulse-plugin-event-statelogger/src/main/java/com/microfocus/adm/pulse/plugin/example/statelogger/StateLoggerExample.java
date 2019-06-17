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

package com.microfocus.adm.pulse.plugin.example.statelogger;

import com.microfocus.adm.pulse.pluginapi.event.PulseChainEventPluginException;
import com.microfocus.adm.pulse.pluginapi.event.PulseReviewStateChangedEventListener;
import com.microfocus.adm.pulse.pluginapi.event.annotations.PulseEventPluginDefinition;
import com.microfocus.adm.pulse.pluginapi.event.dto.PulseReview;
import com.microfocus.adm.pulse.pluginapi.event.dto.PulseReviewState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Event plugin that logs the review event transmitted.
 */
@PulseEventPluginDefinition(groupId = "com.microfocus.pulse.example", pluginId = "statelogger", version = "0", displayName = "Review state event logger")
public class StateLoggerExample implements PulseReviewStateChangedEventListener {
    private Logger log = LoggerFactory.getLogger(StateLoggerExample.class);

    @Override
    public void reviewStateChanged(final PulseReview review, final PulseReviewState oldState, final PulseReviewState newState) {
        log.info("reviewStateChanged({}, {}, {})", review, oldState, newState);
    }

    @Override
    public boolean init() throws PulseChainEventPluginException {
        // Initialise the plugin and return true if it succeeded - flag allows for the plugin to be disabled.
        // Throw a ChainEventPluginException if the plugin had an error during initialisation.
        return true;
    }

    @Override
    public void close() throws IOException {
        // Called when Pulse is shutting down to allow it to clean up any resources.
    }
}
