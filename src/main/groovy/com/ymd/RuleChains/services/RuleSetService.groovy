/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ymd.RuleChains.services

import com.ymd.RuleChains.entities.RuleSet

/**
 *
 * @author jam
 */
interface RuleSetService {
  List<RuleSet> listRuleSets(String pattern)
  RuleSet getRuleSetByName(String name)
  RuleSet updateRuleSetName(String oldname,String newname)	
}

