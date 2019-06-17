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

import java.util.Map;

public interface PulseRepositoryContextAware {
    /**
     * <p>
     * Sets an unmodifiable map of properties with connection details to the repository, which was used to fetch the work area. <br>
     * For a Dimensions CM repository:
     * </p>
     * <ul>
     * <li><code>username</code> will be the Dimensions CM user name of the "service account" for this repository in Pulse;</li>
     * <li><code>password</code> will be the Dimensions CM password of the "service account" for this repository in Pulse;</li>
     * <li><code>server</code> will be the server name, where is located Dimensions CM application server;</li>
     * <li><code>dbname</code> will be the database name, used by Dimensions CM;</li>
     * <li><code>dsn</code> will be the data source name, used by Dimensions CM;</li>
     * <li><code>scmUrl</code> dbname + dsn + server combined into one string in URL format;</li>
     * <li><code>scmUri</code> dbname + dsn + server combined into one string in URI format;</li>
     * <li><code>ssoToken</code> will contain SSO token, used for login to Dimensions CM (optional).</li>
     * </ul>
     *
     * For a Git repository:
     * </p>
     * <ul>
     * <li><code>username</code> will be the Git user name of the "service account" for this repository in Pulse;</li>
     * <li><code>password</code> will be the Git password of the "service account" for this repository in Pulse;</li>
     * <li><code>server</code> will be the location of Git repository (local file or remote Http);</li>
     * <li><code>dbname</code> contains null as not relevant for Git;</li>
     * <li><code>dsn</code> contains null as not relevant for Git;</li>
     * <li><code>scmUrl</code> server combined into one string in URL format;</li>
     * <li><code>scmUri</code> server combined into one string in URI format;</li>
     * <li><code>ssoToken</code> will contain SSO token, used for login to remote Git repository.</li>
     * </ul>
     *
     * @since 19.1.1
     */
    void setRepositoryContext(Map<String, String> repositoryContext);
}
