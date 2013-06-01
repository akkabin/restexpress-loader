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
package com.strategicgains.restexpress.loader.serialization;

import com.strategicgains.hyperexpress.domain.Link;
import com.strategicgains.hyperexpress.domain.LinkableCollection;

import com.strategicgains.restexpress.serialization.xml.DefaultXmlProcessor;


/**
 * Specifies the XML-element-name-to-object type mapping.  The element name is what exists in the XML input/output,
 * mapping that to a domain object or DTO within the project.  This facilitates the XML to domain and domain to XML
 * serialization.  Otherwise, the XML serializer will use the full object name (e.g. java.util.ArrayList).
 */
public class XmlSerializationProcessor extends DefaultXmlProcessor {
    //~ Constructors ===================================================================================================

    public XmlSerializationProcessor() {
        super();
        alias("link", Link.class);
        alias("collection", LinkableCollection.class);

        //		alias("element_name", Element.class);
        //		alias("element_name", Element.class);
        //		alias("element_name", Element.class);
        //		alias("element_name", Element.class);
    }
}
