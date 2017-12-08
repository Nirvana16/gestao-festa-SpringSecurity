package com.algaworks.festa.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.algaworks.festa.model.Grupo;
import com.algaworks.festa.model.Permissao;
import com.algaworks.festa.model.Usuario;
import com.algaworks.festa.repository.Grupos;
import com.algaworks.festa.repository.Permissoes;
import com.algaworks.festa.repository.Usuarios;

@Component
public class FestaUserDetailsService implements UserDetailsService {
	
	@Autowired
	private Usuarios usuarios;

	@Autowired
	private Grupos grupos;
	
	@Autowired
	private Permissoes permissoes;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarios.findByLogin(username);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		
		return new UsuarioSistema(usuario.getNome(), usuario.getLogin(), usuario.getSenha(), authorities(usuario));
	}
	
	public Collection<? extends GrantedAuthority> authorities(Usuario usuario) {
		return authorities(grupos.findByUsuariosIn(usuario));
	}
	
	public Collection<? extends GrantedAuthority> authorities(List<Grupo> grupos) {
		Collection<GrantedAuthority> auths = new ArrayList<>();
		
		for (Grupo grupo: grupos) {
			List<Permissao> lista = permissoes.findByGruposIn(grupo);
			
			for (Permissao permissao: lista) {
				auths.add(new SimpleGrantedAuthority("ROLE_" + permissao.getNome()));
			}
		}
		
		return auths;
	}
}