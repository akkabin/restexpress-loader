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

import java.util.List;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class AppConfiguration extends BaseBean {
    //~ Static fields/initializers =====================================================================================

    /**  */
    private static final long serialVersionUID = 1L;

    //~ Instance fields ================================================================================================

    private List<String> serviceClasses;
    private MetricsConfig metricsConfig;
    private String baseUrl;
    private String defaultFormat;
    private String dtoPackage;
    private String exceptionMapper;
    private int executorThreadPoolSize;
    private int port;

    //~ Methods ========================================================================================================

    /**
     * DOCUMENT ME!
     *
     * @return the baseUrl
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the defaultFormat
     */
    public String getDefaultFormat() {
        return defaultFormat;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the dtoPackage
     */
    public String getDtoPackage() {
        return dtoPackage;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the exceptionMapper
     */
    public String getExceptionMapper() {
        return exceptionMapper;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the executorThreadPoolSize
     */
    public int getExecutorThreadPoolSize() {
        return executorThreadPoolSize;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the metricsConfig
     */
    public MetricsConfig getMetricsConfig() {
        return metricsConfig;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the serviceClasses
     */
    public List<String> getServiceClasses() {
        return serviceClasses;
    }

    /**
     * DOCUMENT ME!
     *
     * @param baseUrl the baseUrl to set
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * DOCUMENT ME!
     *
     * @param defaultFormat the defaultFormat to set
     */
    public void setDefaultFormat(String defaultFormat) {
        this.defaultFormat = defaultFormat;
    }

    /**
     * DOCUMENT ME!
     *
     * @param dtoPackage the dtoPackage to set
     */
    public void setDtoPackage(String dtoPackage) {
        this.dtoPackage = dtoPackage;
    }

    /**
     * DOCUMENT ME!
     *
     * @param exceptionMapper the exceptionMapper to set
     */
    public void setExceptionMapper(String exceptionMapper) {
        this.exceptionMapper = exceptionMapper;
    }

    /**
     * DOCUMENT ME!
     *
     * @param executorThreadPoolSize the executorThreadPoolSize to set
     */
    public void setExecutorThreadPoolSize(int executorThreadPoolSize) {
        this.executorThreadPoolSize = executorThreadPoolSize;
    }

    /**
     * DOCUMENT ME!
     *
     * @param metricsConfig the metricsConfig to set
     */
    public void setMetricsConfig(MetricsConfig metricsConfig) {
        this.metricsConfig = metricsConfig;
    }

    /**
     * DOCUMENT ME!
     *
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * DOCUMENT ME!
     *
     * @param serviceClasses the serviceClasses to set
     */
    public void setServiceClasses(List<String> serviceClasses) {
        this.serviceClasses = serviceClasses;
    }
}
