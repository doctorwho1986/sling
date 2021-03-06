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
package org.apache.sling.discovery.impl.topology.announcement;

import java.util.Map;

import org.apache.sling.discovery.impl.common.DefaultClusterViewImpl;
import org.apache.sling.discovery.impl.common.DefaultInstanceDescriptionImpl;
import org.apache.sling.discovery.impl.common.InstanceDescriptionTest;
import org.apache.sling.discovery.impl.topology.announcement.IncomingInstanceDescription;
import org.junit.Test;

public class IncomingInstanceDescriptionTest extends InstanceDescriptionTest {

    @Override
    public DefaultInstanceDescriptionImpl constructInstanceDescription(
            DefaultClusterViewImpl clusterView, boolean isLeader,
            boolean isOwn, String theSlingId, Map<String, String> properties)
            throws Exception {

        return new IncomingInstanceDescription(clusterView, isLeader,
                theSlingId, properties);
    }

    @Override
    @Test
    public void testNotOwnInstance() throws Exception {
        // exclude that one - since incoming instancedescription is always !own!
    }

}
