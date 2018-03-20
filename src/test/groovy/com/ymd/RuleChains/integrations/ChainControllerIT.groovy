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
package com.ymd.RuleChains.integrations

import com.ymd.RuleChains.Application
import com.ymd.RuleChains.repositories.ChainRepository
import java.net.URL
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner

import static org.hamcrest.Matchers.*
import static org.junit.Assert.*

/**
 *
 * @author James Jones <jamjon3@gmail.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  classes = Application.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
//@TestPropertySource(
//  locations = "classpath:application-integrationtest.properties")
class ChainControllerIT {

  @Autowired
  private MockMvc mvc

  @Autowired
  private ChainRepository repository;

  @Before
  public void setUp() throws Exception {
//    this.base = new URL("http://localhost:" + port + "/api/chain");    
  }
  @After
  public void resetDb() {
    repository.deleteAll()
  }
  @Test
  public void getChain() throws Exception {
    ResponseEntity<String> response = template.getForEntity(base.toString(),
      String.class);
    assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
  }
  @Test
  public void listChains() throws Exception {
    ResponseEntity<String> response = template.getForEntity(base.toString(),
      String.class);
    assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
  }
  private void createTestChain(String name) {
    Chain chain = new Chain(name)
    repository.saveAndFlush(chain)
  }

}

