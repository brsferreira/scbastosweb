package com.scbastos.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scbastos.model.Usuario;
import com.scbastos.repository.helper.usuario.UsuariosQueries;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries {
	
	
	// Metodos para validacao de Unique Key
	
	public Optional<Usuario> findByCpf(String cpf);
	public Optional<Usuario> findByEmail(String email);
	public List<Usuario> findAllByAtivoTrue();
	public List<Usuario> CorretorAtivo();
	public Optional<Usuario> findByTelefone(String telefone);
	
	
	//public List<Usuario> findById_usuarioIn(Long[] codigos);
	
	
}
