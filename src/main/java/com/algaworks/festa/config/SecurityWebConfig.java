package com.algaworks.festa.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.algaworks.festa.security.FestaUserDetailsService;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private FestaUserDetailsService ssUserDetailsService;
		 
	
  @Override
  protected void configure(AuthenticationManagerBuilder builder) throws Exception {
    builder
        .userDetailsService(ssUserDetailsService)
        .passwordEncoder(new BCryptPasswordEncoder());
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  http
	    .authorizeRequests()
	    	.antMatchers("/resources/**","/css/**","/fonts/**","/images/**","/js/**","/index","/").permitAll()
	        .anyRequest().authenticated()
	    .and()
	    .formLogin()
	        // Aqui dizemos que temos uma página customizada.
	        .loginPage("/login") 
	        // Mesmo sendo a página de login, precisamos avisar
	        // ao Spring Security para liberar o acesso a ela.
	        .permitAll(); 
	}

  public static void main(String[] args) {
    System.out.println(new BCryptPasswordEncoder().encode("123"));
  }

}