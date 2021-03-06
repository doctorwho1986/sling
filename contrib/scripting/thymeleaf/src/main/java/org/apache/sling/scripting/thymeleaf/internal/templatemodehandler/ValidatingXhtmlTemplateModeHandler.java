/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.scripting.thymeleaf.internal.templatemodehandler;

import java.util.Dictionary;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.ConfigurationPolicy;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.PropertyUnbounded;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.framework.Constants;
import org.osgi.service.component.ComponentContext;
import org.thymeleaf.templateparser.xmlsax.XhtmlAndHtml5NonValidatingSAXTemplateParser;
import org.thymeleaf.templatewriter.XhtmlHtml5TemplateWriter;

@Component(
    label = "Apache Sling Scripting Thymeleaf “Validating XHTML Template Mode Handler”",
    description = "validating XHTML template mode handler for Sling Scripting Thymeleaf",
    immediate = true,
    metatype = true,
    policy = ConfigurationPolicy.REQUIRE
)
@Service
@Properties({
    @Property(name = Constants.SERVICE_VENDOR, value = "The Apache Software Foundation"),
    @Property(name = Constants.SERVICE_DESCRIPTION, value = "validating XHTML template mode handler for Sling Scripting Thymeleaf")
})
public class ValidatingXhtmlTemplateModeHandler extends AbstractTemplateModeHandler {

    public static final String TEMPLATE_MODE_NAME = "VALIDXHTML";

    @Property(unbounded = PropertyUnbounded.ARRAY)
    public static final String PATTERNS_PARAMETER = "org.apache.sling.scripting.thymeleaf.internal.templatemodehandler.ValidatingXhtmlTemplateModeHandler.patterns";

    public ValidatingXhtmlTemplateModeHandler() {
        super(TEMPLATE_MODE_NAME, new XhtmlAndHtml5NonValidatingSAXTemplateParser(poolSize()), new XhtmlHtml5TemplateWriter());
    }

    protected void configure(final ComponentContext componentContext) {
        final Dictionary properties = componentContext.getProperties();
        final String[] strings = PropertiesUtil.toStringArray(properties.get(PATTERNS_PARAMETER), new String[]{});
        configurePatternSpec(strings);
    }

}
