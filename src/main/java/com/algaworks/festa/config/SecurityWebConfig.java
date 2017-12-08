package com.algaworks.festa.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {
	
	private static final String USUARIO_POR_LOGIN = "SELECT login, senha, ativo, nome FROM usuario"
            + " WHERE login = ?";
	
	private static final String PERMISSOES_POR_USUARIO = "SELECT u.login, p.nome FROM usuario_permissoes up"
            + " JOIN usuario u ON u.id = up.usuarios_id"
            + " JOIN permissao p ON p.id = up.permissoes_id"
            + " WHERE u.login = ?";
	
	private static final String PERMISSOES_POR_GRUPO = "SELECT g.id, g.nome, p.nome FROM grupo_permissoes gp"
            + " JOIN grupo g ON g.id = gp.grupos_id"
            + " JOIN permissao p ON p.id = gp.permissoes_id"
            + " JOIN usuario_grupos ug ON ug.grupos_id = g.id"
            + " JOIN usuario u ON u.id = ug.usuarios_id"
            + " WHERE u.login = ?";
  
  @Autowired
  private DataSource dataSource;
	
  @Override
  protected void configure(AuthenticationManagerBuilder builder) throws Exception {
    builder
        .jdbcAuthentication()
        .dataSource(dataSource)
        .passwordEncoder(new BCryptPasswordEncoder())
        .usersByUsernameQuery(USUARIO_POR_LOGIN)
        .authoritiesByUsernameQuery(PERMISSOES_POR_USUARIO)
        .groupAuthoritiesByUsername(PERMISSOES_POR_GRUPO)
        .rolePrefix("ROLE_");
  }


  public static void main(String[] args) {
    System.out.println(new BCryptPasswordEncoder().encode("123"));
  }

}