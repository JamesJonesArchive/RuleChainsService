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


package com.ymd.RuleChains.services

import com.ymd.RuleChains.entities.RuleSet
import java.util.stream.Collectors
import java.util.stream.Stream
import java.util.function.Predicate
import java.util.regex.Pattern
import java.text.SimpleDateFormat
import java.text.DateFormat
import java.lang.Exception
import javax.persistence.criteria.CriteriaBuilder
import org.hibernate.Query
import org.hibernate.SQLQuery
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.Criteria
import org.hibernate.criterion.CriteriaQuery
import org.hibernate.type.IntegerType
import org.hibernate.type.LongType
import org.hibernate.type.DateType
import org.hibernate.type.StringType
import org.hibernate.type.BooleanType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.TransactionStatus
import org.springframework.transaction.support.TransactionCallback
import org.springframework.transaction.support.TransactionCallbackWithoutResult
import org.springframework.transaction.support.TransactionTemplate
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.annotation.Propagation
import com.ymd.RuleChains.repositories.RuleSetRepository

/**
 *
 * @author james
 */
@Service
class RuleSetServiceImpl implements RuleSetService {
  @Autowired
  private RuleSetRepository ruleSetRepository
  /**
   * Returns a list of RuleSet objects with an optional matching filter
   * 
   * @param  pattern  An optional parameter. When provided the full list (default) will be filtered down with the regex pattern string when provided
   * @return          The resulting list of Chain objects
   * @see    RuleSet
   */   
  @Override
  List<RuleSet> listRuleSets(String pattern = null) {
    if(!!pattern) {
      // Filter with custom predicate
      Pattern p = Pattern.compile(pattern.trim())
      Predicate<RuleSet> ruleSetNamePredicate = { rs -> p.matcher(rs.name).find() }
      return ruleSetRepository.findAll().stream().filter(ruleSetNamePredicate).collect(Collectors.toList())
    } else {
      return ruleSetRepository.findAll()
    }
  }
  /**
   * Returns a RuleSet object that matches the provided name
   * 
   * @param name  The name of the chain to be returned
   * @return      The RuleSet object matching the specified chain name
   */ 
  @Override
  RuleSet getRuleSetByName(String name) {
    return ruleSetRepository.findByName(name)
  }
  /**
   * Updates a RuleSet's name and returns the updated Chain object
   *
   * @param   oldname  A string representing the original RuleSet name
   * @param   newname  A string representing the updated RuleSet name
   * @return  The updated RuleSet object
   * @see     RuleSet
   */
  @Override
  RuleSet updateRuleSetName(String oldname,String newname) {
    ruleSetRepository.updateName(oldname,newname)
    return ruleSetRepository.findByName(newname)
  }
  
}

