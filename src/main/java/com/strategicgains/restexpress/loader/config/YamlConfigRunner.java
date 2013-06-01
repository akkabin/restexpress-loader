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

import org.apache.commons.io.IOUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;


/**
 * DOCUMENT ME!
 *
 * @author $author$
 * @version $Revision$
 */
public class YamlConfigRunner {
    //~ Static fields/initializers =====================================================================================

    private static final Logger LOG = LoggerFactory.getLogger(YamlConfigRunner.class);

    //~ Methods ========================================================================================================

    public AppConfiguration load(String filename) {
        AppConfiguration config = null;

        Yaml yaml = new Yaml();
        InputStream in = null;

        try {
            in = this.getClass().getClassLoader().getResourceAsStream(filename);
            config = yaml.loadAs(in, AppConfiguration.class);
            LOG.info(config.toString());
        } catch (Exception ex) {
            LOG.error("Failed to load config: ", ex);
        } finally {
            if (null != in) {
                IOUtils.closeQuietly(in);
            }
        }

        return config;
    }
}
