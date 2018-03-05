/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ymd.RuleChains.enums

/**
 * ParseEnum is an Enumerator for output Parsing Types.
 * 
 * @author James Jones
 */ 
enum ParseEnum {
    TEXT, XML, JSON;
    /**
     * Converts a base string into a corresponding enumerated type
     * 
     * @param   str    The string name of the enumerated type
     * @return         A corresponding enumerated type matched on the string parameter
     */            
    public static ParseEnum byName(String str) {
        for (parseEnum in ParseEnum.values()) {
            if(str.trim().toUpperCase().equalsIgnoreCase(parseEnum.name())) {
                return parseEnum;
            }
        }
        return ParseEnum.TEXT;            
    }   	    	
}
