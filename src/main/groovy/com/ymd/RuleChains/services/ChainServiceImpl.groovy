/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ymd.RuleChains.services

import com.ymd.RuleChains.entities.Chain
import com.ymd.RuleChains.repositories.ChainRepository
import java.util.function.Predicate
import java.util.regex.Pattern
import java.util.stream.Stream
import javax.persistence.EntityManagerFactory
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
/**
 *
 * @author jam
 */
@Service
class ChainServiceImpl implements ChainService {
  @Autowired
  private ChainRepository chainRepository
  
  /**
   * Returns a Chain object that matches the provided name
   * 
   * @param name  The name of the chain to be returned
   * @return      The Chain object matching the specified chain name
   */ 
  @Override
  Chain getChainByName(String name) {
    return chainRepository.findByName(name)
  }
  /**
   * Returns a list of Chain objects with an optional matching filter
   * 
   * @param  pattern  An optional parameter. When provided the full list (default) will be filtered down with the regex pattern string when provided
   * @return          The resulting list of Chain objects
   * @see    Chain
   */   
  @Override
  List<Chain> listChains(String pattern = null) { 
    if(!!pattern) {
      // Groovy
//      return chainRepository.findAll().findAll {
//        Pattern.compile(pattern.trim()).matcher(it.name).matches()
//      }
      // Java 8 filter
      Pattern p = Pattern.compile(pattern.trim())
      Predicate<Chain> chainNamePredicate = { c -> p.matcher(c.name).find() }
      return chainRepository.findAll().stream().filter(chainNamePredicate).collect(Collectors.toList())
    } else {
      return chainRepository.findAll()
    }
  }
  @Override
  Chain updateChainName(String oldname,String newname) {
    chainRepository.updateName(oldname,newname)
    return chainRepository.findByName(newname)
  }
}

