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

import com.ymd.RuleChains.repositories.LinkRepository
import com.ymd.RuleChains.entities.Link
import java.util.function.Function
import java.util.stream.Collectors
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
import groovy.lang.GroovyShell
import groovy.lang.Script
import groovy.lang.Binding
import org.codehaus.groovy.control.CompilationFailedException

/**
 *
 * @author james
 */
@Service
class LinkServiceImpl implements LinkService {
  @Autowired
  private LinkRepository linkRepository;

  private List execute(Function<List, Link> function, Link link) {
    Script inputReorder = buildGroovyScript(link.inputReorder)
    Script outputReorder = buildGroovyScript(link.outputReorder)
    return function.apply(link);
  }
  
//  public static Closure<?> buildClosure(String closureString) {
//    String scriptText = "{ script -> " + closureString + " }";
//    return (Closure<?>) new GroovyShell().evaluate(scriptText);
//  }

  public static Script buildGroovyScript(String raw,Map variables) throws CompilationFailedException {
    try {
      Script gscript =  new GroovyShell().parse(raw)
      Binding binding = new Binding(variables)
      gscript.setBinding(binding)
      return gscript
    } catch (CompilationFailedException ex) {
      ex.printStackTrace();
    }
  }

  
//  inputReorder = ''
//  private String outputReorder = ''
}

