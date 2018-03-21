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
import com.ymd.RuleChains.entities.Chain
import com.ymd.RuleChains.repositories.ChainRepository
import java.net.URL
import org.junit.Before
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import static org.hamcrest.CoreMatchers.*
import static org.hamcrest.Matchers.*
import static org.junit.Assert.*
import static org.mockito.Mockito.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
/**
 *
 * @author James Jones <jamjon3@gmail.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = WebEnvironment.RANDOM_PORT,
  classes = Application.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class ChainRestControllerIntTest {

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
  public void whenChain_thenGetChain() throws IOException, Exception {
    createTestChain("testGetChain")
    mvc.perform(get("/api/chain/testGetChain")
      .contentType(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("\$.name", is("testGetChain")))
  }
  @Test
  public void whenChains_thenListChains() throws IOException, Exception {
    createTestChain("testListChains")
    mvc.perform(get("/api/chain/testGetChain")
      .contentType(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath('$', hasSize(greaterThanOrEqualTo(2))))
      .andExpect(jsonPath('$[@name == "testGetChain"]').exists())
  }
  private void createTestChain(String name) {
    Chain chain = new Chain(name)
    repository.saveAndFlush(chain)
  }

}

