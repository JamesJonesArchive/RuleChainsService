/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
