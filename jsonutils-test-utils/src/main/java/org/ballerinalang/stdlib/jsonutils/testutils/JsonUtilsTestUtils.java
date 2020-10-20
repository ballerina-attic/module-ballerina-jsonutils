/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.ballerinalang.stdlib.jsonutils.testutils;

import io.ballerina.runtime.XMLFactory;
import io.ballerina.runtime.api.StringUtils;
import io.ballerina.runtime.api.values.BString;
import io.ballerina.runtime.values.XMLValue;
import org.ballerinalang.stdlib.jsonutils.XmlToJsonConverter;

/**
 * Class to test functionality of jsonutils.
 *
 * @since 1.0
 */
public class JsonUtilsTestUtils {

    public static BString convertToJson(BString xmlStr) {
        XMLValue parse = (XMLValue) XMLFactory.parse(xmlStr.toString());
        Object json = XmlToJsonConverter.convertToJSON(parse, "@", true);
        String jsonString = StringUtils.getJsonString(json);
        return io.ballerina.runtime.api.StringUtils.fromString(jsonString);
    }

    public static BString convertChildrenToJson(BString xmlStr) {
        XMLValue parse = (XMLValue) XMLFactory.parse(xmlStr.toString()).children();
        Object json = XmlToJsonConverter.convertToJSON(parse, "@", true);
        String jsonString = StringUtils.getJsonString(json);
        return io.ballerina.runtime.api.StringUtils.fromString(jsonString);
    }
}
