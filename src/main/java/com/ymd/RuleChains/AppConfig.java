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

package com.ymd.RuleChains;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManagerFactory;
/**
 *
 * @author James Jones
 */
@Configuration
public class AppConfig {
  @Autowired
  private EntityManagerFactory entityManagerFactory;
  
  @Bean
  public SessionFactory getSessionFactory() {
    if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
      throw new NullPointerException("factory is not a hibernate factory");
    }
    return entityManagerFactory.unwrap(SessionFactory.class);
  }
//  @Bean
//  public HibernateJpaSessionFactoryBean sessionFactory() {
//    HibernateJpaSessionFactoryBean fact = new HibernateJpaSessionFactoryBean();
//    fact.setEntityManagerFactory(entityManagerFactory);
//    return fact;
//  }

}
