/*
 * Copyright 2011 VZ Netzwerke Ltd
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
package net.vz.mongodb.jackson;

import net.vz.mongodb.jackson.mock.MockObject;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@MongoTestParams(serializerType = MongoTestParams.SerializationType.OBJECT)
public class TestWriteResult extends MongoDBTestBase {
    private JacksonDBCollection<MockObject, String> coll;

    @Before
    public void setup() throws Exception {
        coll = getCollection(MockObject.class, String.class);
    }

    @Test
    public void testGetSavedId() {
        assertThat(coll.insert(new MockObject("blah", "ten", 10)).getSavedId(), equalTo("blah"));
    }

    @Test
    public void testGetSavedObject() {
        MockObject o = new MockObject("blah", "ten", 10);
        assertThat(coll.insert(o).getSavedObject(), equalTo(o));
    }
}
