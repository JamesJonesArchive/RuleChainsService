/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ymd.RuleChains.controllers

import com.ymd.RuleChains.entities.Chain
import com.ymd.RuleChains.services.ChainService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

import static org.hamcrest.Matchers.equalTo
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 *
 * @author jam
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ChainControllerTest {
  @Autowired
  private MockMvc mvc;

  @MockBean
  private ChainService chainService
  
  @Before
  public void setUp() {
    Chain alex = new Chain("alex");

    Mockito.when(chainService.getChainByName(alex.getName()))
      .thenReturn(alex);
    Mockito.when(chainService.listChains())
      .thenReturn([ alex ]);
  }

  @Test
  public void getChain() throws Exception {
    
    mvc.perform(MockMvcRequestBuilders.get("/api/chain/alex")
      .accept(MediaType.APPLICATION_JSON)
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content()
        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
      .andExpect(jsonPath("\$.name", is("alex")));

  }
  @Test
  public void listChains() throws Exception {
    
    mvc.perform(MockMvcRequestBuilders.get("/api/chain")
      .accept(MediaType.APPLICATION_JSON)
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content()
        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
      .andExpect(jsonPath("\$", hasSize(1)))
      .andExpect(jsonPath("\$[0].name", is("alex")));

  }

}

