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

import com.microfocus.adm.pulse.pluginapi.event.dto.PulseChain;

/**
 * <p>
 * Allows a plugin to find out about chains.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseChainService {
    /**
     * <p>
     * Lists all the chains known to Pulse.
     * </p>
     *
     * @return List of chain details.
     * @since 19.1.1
     */
    List<PulseChain> getChains();

    /**
     * <p>
     * Given the unique key for a chain, returns details about the chain.
     * </p>
     *
     * @param key
     *            Unique key for the chain.
     * @return Details about the chain.
     * @throws PulseChainNotFoundException
     *             Thrown if the chain is not known to Pulse.
     * @since 19.1.1
     */
    PulseChain getChainByKey(String key) throws PulseChainNotFoundException;

    /**
     * <p>
     * Given the full title for a chain, returns details about the chain. The full title includes the suite, product and stream.
     * </p>
     *
     * @param title
     *            Full title for the chain.
     * @return Details about the chain.
     * @throws PulseChainNotFoundException
     *             Thrown if the chain is not known to Pulse.
     * @since 19.1.1
     */
    PulseChain getChainByTitle(String title) throws PulseChainNotFoundException;

    /**
     * <p>
     * Requests the supplied chain is queued to be run.
     * </p>
     *
     * @param chain
     *            Chain to be queued. Should be an object returned from getChains(), getChainByKey() or getChainByTitle().
     * @return Unique identifier for the chain run.
     * @throws PulseChainNotQueuedException
     *             Thrown if the chain could not be queued.
     * @since 19.1.1
     */
    String runChain(PulseChain chain) throws PulseChainNotQueuedException;

    /**
     * <p>
     * Asks the chain to be run on the supplied change sets.
     * </p>
     *
     * @param chain
     *            Chain to be queued. Should be an object returned from getChains(), getChainByKey() or getChainByTitle().
     * @param changeSetIds
     *            Pulse SCM changeset identifiers of the changesets to run the chain on.
     * @return Unique identifier for the chain run.
     * @throws PulseChainNotQueuedException
     *             Thrown if the chain could not be queued.
     * @since 19.1.1
     */
    String runChainOnChangeSets(PulseChain chain, List<String> changeSetIds) throws PulseChainNotQueuedException;

    /**
     * <p>
     * Returns the chains that are associated with the stream of the review identified by its label. This isn't necessarily the same
     * set of chains that have been run on the review, but the list that can be run on the review.
     * </p>
     *
     * @param reviewLabel
     *            Label of the review to return the chains for.
     * @return Chains associated with the review. An empty list is returned if their are no chains associated with the review
     *         stream.
     * @throws PulseReviewNotFoundException
     *             Thrown if the review is not known to Pulse.
     * @since 19.1.1
     */
    List<PulseChain> getChainsForReviewByLabel(String reviewLabel) throws PulseReviewNotFoundException;
}
