/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.strategicgains.restexpress.loader.config;

import com.strategicgains.restexpress.loader.dto.BaseBean;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class MetricsConfig extends BaseBean {
    //~ Static fields/initializers =====================================================================================

    /**  */
    private static final long serialVersionUID = 1L;

    //~ Instance fields ================================================================================================

    private Boolean isEnabled;
    private Boolean isGraphiteEnabled;
    private Integer graphitePort;
    private Integer publishSeconds;
    private String graphiteHost;
    private String machineName;

    //~ Methods ========================================================================================================

    /**
     * DOCUMENT ME!
     *
     * @return the graphiteHost
     */
    public String getGraphiteHost() {
        return graphiteHost;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the graphitePort
     */
    public Integer getGraphitePort() {
        return graphitePort;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the isEnabled
     */
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the isGraphiteEnabled
     */
    public Boolean getIsGraphiteEnabled() {
        return isGraphiteEnabled;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the machineName
     */
    public String getMachineName() {
        return machineName;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the publishSeconds
     */
    public Integer getPublishSeconds() {
        return publishSeconds;
    }

    /**
     * DOCUMENT ME!
     *
     * @param graphiteHost the graphiteHost to set
     */
    public void setGraphiteHost(String graphiteHost) {
        this.graphiteHost = graphiteHost;
    }

    /**
     * DOCUMENT ME!
     *
     * @param graphitePort the graphitePort to set
     */
    public void setGraphitePort(Integer graphitePort) {
        this.graphitePort = graphitePort;
    }

    /**
     * DOCUMENT ME!
     *
     * @param isEnabled the isEnabled to set
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * DOCUMENT ME!
     *
     * @param isGraphiteEnabled the isGraphiteEnabled to set
     */
    public void setIsGraphiteEnabled(Boolean isGraphiteEnabled) {
        this.isGraphiteEnabled = isGraphiteEnabled;
    }

    /**
     * DOCUMENT ME!
     *
     * @param machineName the machineName to set
     */
    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    /**
     * DOCUMENT ME!
     *
     * @param publishSeconds the publishSeconds to set
     */
    public void setPublishSeconds(Integer publishSeconds) {
        this.publishSeconds = publishSeconds;
    }
}
