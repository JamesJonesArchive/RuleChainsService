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

/**
 *
 * @author james
 */
@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true)
class ConfigService {
	
}

