/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ymd.RuleChains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author jam
 */
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
  @Value("${security.enable-csrf}")
  private boolean csrfEnabled;
  
  @Value("${security.basic.enabled}")
  private boolean securityEnabled;
  /**
   * Temporarily turning off Spring Security - Remove later
   * @param security
   * @throws Exception 
   */
  @Override
  protected void configure(HttpSecurity security) throws Exception {
    if (!csrfEnabled) {
      security.csrf().disable();
    }
    if (!securityEnabled) {      
      security.httpBasic().disable();
    } else {
      security.authorizeRequests()
        .anyRequest().authenticated()
        .and().httpBasic();
    }
    System.out.println("Security Status Enabled is: " + securityEnabled);
    System.out.println("Security CSRF Enabled is: " + csrfEnabled);
  }
//  @Autowired
//  public void configureGlobal(AuthenticationManagerBuilder auth) 
//    throws Exception {
//      auth.inMemoryAuthentication().withUser("user")
//        .password("password").roles("USER");
//  }
}
