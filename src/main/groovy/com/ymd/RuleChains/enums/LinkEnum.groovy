/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

