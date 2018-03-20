/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ymd.RuleChains.repositories

import com.ymd.RuleChains.entities.Chain
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit4.SpringRunner

import static org.assertj.core.api.Assertions.assertThat

/**
 *
 * @author jam
 */
@RunWith(SpringRunner.class)
@DataJpaTest
class ChainRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ChainRepository chainRepository;

    @Test
    public void whenFindByName_thenReturnChain() {
        // given
        Chain alex = new Chain("alex");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Chain found = chainRepository.findByName(alex.getName());

        // then
        assertThat(found.getName())
          .isEqualTo(alex.getName());

    }
}

