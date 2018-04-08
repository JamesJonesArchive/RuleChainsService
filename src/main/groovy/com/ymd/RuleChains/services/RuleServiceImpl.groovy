/*
 * Copyright 2018 .
 *
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

import com.ymd.RuleChains.entities.DefinedService
import com.ymd.RuleChains.entities.Groovy
import com.ymd.RuleChains.entities.Rule
import com.ymd.RuleChains.entities.SQLQuery
import com.ymd.RuleChains.entities.Snippet
import com.ymd.RuleChains.entities.StoredProcedureQuery
import com.ymd.RuleChains.repositories.DefinedServiceRepository
import com.ymd.RuleChains.repositories.GroovyRepository
import com.ymd.RuleChains.repositories.RuleRepository
import com.ymd.RuleChains.repositories.SQLQueryRepository
import com.ymd.RuleChains.repositories.SnippetRepository
import com.ymd.RuleChains.repositories.StoredProcedureQueryRepository
import java.util.function.Function
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 * @author jam
 */
@Service
class RuleServiceImpl implements RuleService {
	@Autowired
  private StoredProcedureQueryRepository storedProcedureQueryRepository;
	@Autowired
  private SnippetRepository snippetRepository;
	@Autowired
  private SQLQueryRepository sQLQueryRepository;
	@Autowired
  private GroovyRepository groovyRepository;
	@Autowired
  private DefinedServiceRepository definedServiceRepository;
  /**
   * Retrieves the appropriate respository for the type of rule provided
   * 
   * @param  Rule    A type of supported rule
   * @return Object  A repository for the entity the rule is part of
   */
  private Object getRuleRepository(Rule rule) throws ClassNotFoundException {
    if(rule instanceof StoredProcedureQuery) {
      return storedProcedureQueryRepository
    } else if(rule instanceof Snippet) {
      return snippetRepository
    } else if(rule instanceof SQLQuery) {
      return sQLQueryRepository
    } else if(rule instanceof Groovy) {
      return groovyRepository
    } else if(rule instanceof DefinedService) {
      return definedServiceRepository
    } else {
      throw new ClassNotFoundException()
    }
  }
}

