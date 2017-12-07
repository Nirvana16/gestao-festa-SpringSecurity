package com.algaworks.festa.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {
	
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            // Para qualquer requisição (anyRequest) é preciso estar 
            // autenticado (authenticated).
            .anyRequest().authenticated()
        .and()
        .httpBasic();
  }
  
  // usuario padrao: user
  // senha padrao será exibida no console
}