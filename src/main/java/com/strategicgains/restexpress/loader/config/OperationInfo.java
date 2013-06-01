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

import org.jboss.netty.handler.codec.http.HttpMethod;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class OperationInfo {
    //~ Instance fields ================================================================================================

    HttpMethod httpMethod;
    String action;
    String name;
    String path;
    String produces;
    String svcClass;

    //~ Constructors ===================================================================================================

    public OperationInfo() {
        super();
    }

    public OperationInfo(String action, HttpMethod httpMethod, String path, String svcClass, String name,
        String produces) {
        super();
        this.action = action;
        this.httpMethod = httpMethod;
        this.path = path;
        this.svcClass = svcClass;
        this.name = name;
        this.produces = produces;
    }

    //~ Methods ========================================================================================================

    /**
     * DOCUMENT ME!
     *
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the httpMethod
     */
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the produces
     */
    public String getProduces() {
        return produces;
    }

    /**
     * DOCUMENT ME!
     *
     * @return the svcClass
     */
    public String getSvcClass() {
        return svcClass;
    }

    /**
     * DOCUMENT ME!
     *
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * DOCUMENT ME!
     *
     * @param httpMethod the httpMethod to set
     */
    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    /**
     * DOCUMENT ME!
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * DOCUMENT ME!
     *
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * DOCUMENT ME!
     *
     * @param produces the produces to set
     */
    public void setProduces(String produces) {
        this.produces = produces;
    }

    /**
     * DOCUMENT ME!
     *
     * @param svcClass the svcClass to set
     */
    public void setSvcClass(String svcClass) {
        this.svcClass = svcClass;
    }
}
