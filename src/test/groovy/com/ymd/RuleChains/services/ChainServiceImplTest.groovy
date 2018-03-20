/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ymd.RuleChains.services

import com.ymd.RuleChains.entities.Chain
import com.ymd.RuleChains.repositories.ChainRepository
import com.ymd.RuleChains.services.ChainService
import com.ymd.RuleChains.services.ChainServiceImpl
import javax.persistence.EntityManagerFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Bean
import org.springframework.test.context.junit4.SpringRunner

import static org.assertj.core.api.Assertions.assertThat

/**
 *
 * @author jam
 */
@RunWith(SpringRunner.class)
class ChainServiceImplTest {
  @TestConfiguration
  static class ChainServiceImplTestContextConfiguration {

      @Bean
      public ChainService chainService() {
          return new ChainServiceImpl();
      }
  }
  @Autowired
  private ChainService chainService;

  @MockBean
  private ChainRepository chainRepository;

  @Before
  public void setUp() {
    Chain alex = new Chain("alex");

    Mockito.when(chainRepository.findByName(alex.getName()))
      .thenReturn(alex);
    Mockito.when(chainRepository.findAll())
      .thenReturn([ alex ]);
  }
  @Test
  public void whenValidName_thenChainShouldBeFound() {
    String name = "alex";
    Chain found = chainService.getChainByName(name);

    assertThat(found.getName())
      .isEqualTo(name);
  }
  @Test
  public void allChainsShouldBeReturned() {
    String name = "alex";
    List<Chain> found = chainService.listChains()

    assertThat(found[0].getName())
      .isEqualTo(name);
  }

}

