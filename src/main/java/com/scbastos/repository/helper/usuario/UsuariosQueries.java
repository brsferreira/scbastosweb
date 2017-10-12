package com.scbastos.repository.helper.usuario;

import java.util.List;
import java.util.Optional;

import com.scbastos.model.Usuario;
import com.scbastos.repository.filter.UsuarioFilter;

public interface UsuariosQueries {

	public Optional<Usuario> porEmailEAtivo(String email);
	public List<Usuario> CorretorAtivo();
	public List<String> permissoes(Usuario usuario);
	
	//Pesquisa de usuarios
	public List<Usuario> filtrarUsuario(UsuarioFilter filtro);
	
}
