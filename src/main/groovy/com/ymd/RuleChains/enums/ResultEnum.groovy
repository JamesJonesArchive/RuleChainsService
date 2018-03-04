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
 * ResultEnum is an Enumerator for Link Result Types.
 * 
 * @author James Jones
 */
enum ResultEnum {
  NONE, UPDATE, RECORDSET, ROW, APPENDTOROW, PREPENDTOROW;
  /**
   * Converts a base string into a corresponding enumerated type
   * 
   * @param   str    The string name of the enumerated type
   * @return         A corresponding enumerated type matched on the string parameter
   */        
  public static ResultEnum byName(String str) {
    for (resultEnum in ResultEnum.values()) {
      if(str.trim().toUpperCase().equalsIgnoreCase(resultEnum.name())) {
        return resultEnum;
      }
    }
    return ResultEnum.NONE;            
  }    	

}

