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
 * The report file reporter is used by the experts to record a report file they want to make available to Dimensions Pulse. The
 * report file could be set at any time during expert run but only the last one is made available to Pulse.
 * </p>
 *
 * <p>
 * The expected use of the property reporter is to provide additional details that expert produced during its run.
 * </p>
 *
 * @since 19.1.1
 */
public interface PulseReportFileReporter {
    /**
     * <p>
     * Sets the report file for the current run, which can contain more detailed information about the current analysis. It can be a
     * text file's content, an HTML file's content or an image file's content, but it should be small or (if not small) highly
     * compressible. The correct MIME content type for the <code>content</code> should be provided.
     * </p>
     *
     * <p>
     * <b>NOTE:</b><br>
     * The <code>content</code> will be compressed using GZIP compression and the compressed data size must be less than 512 kB;
     * <code>fileName</code> must be 128 characters or fewer; and <code>mimeType</code> must be 255 characters or fewer.
     * </p>
     *
     * @param fileName
     *            Name of the report file. File with this name will be available to download from the review page.
     * @param mimeType
     *            MIME content type of the report file (for example, "text/plain", "text/html", or "image/png").
     * @param content
     *            Content of the report file.
     * @throws PulseChainStepPluginException
     *             if the <em>compressed</em> <code>content</code> size is larger than 512 kB; if <code>fileName</code> is longer
     *             than 128 characters; or if <code>mimeType</code> is longer than 255 characters.
     * @since 19.1.1
     */
    void setReportFile(String fileName, String mimeType, byte[] content) throws PulseChainStepPluginException;
}
