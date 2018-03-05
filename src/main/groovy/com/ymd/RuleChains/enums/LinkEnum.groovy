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
 * LinkEnum is an Enumerator for Link "Link" Types.
 *
 * @author James Jones
 */
enum LinkEnum {
  NONE, LOOP, ENDLOOP, NEXT;
  /**
   * Converts a base string into a corresponding enumerated type
   * 
   * @param   str    The string name of the enumerated type
   * @return         A corresponding enumerated type matched on the string parameter
   */    
  public static LinkEnum byName(String str) {
    for(linkEnum in LinkEnum.values()) {
      if(str.trim().toUpperCase().equalsIgnoreCase(linkEnum.name())) {
        return linkEnum;
      }
    }
    return LinkEnum.NONE;            
  }             	
	
}

