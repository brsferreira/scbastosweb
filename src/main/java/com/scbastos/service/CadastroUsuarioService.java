package com.scbastos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.scbastos.exceptions.CpfExcepetion;
import com.scbastos.exceptions.EmailExcepetion;
import com.scbastos.exceptions.SenhaObrigatoriaUsuarioException;
import com.scbastos.exceptions.TelefoneException;
import com.scbastos.model.Usuario;
import com.scbastos.repository.Usuarios;

@Service
public class CadastroUsuarioService {
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Transactional
	public void salvarUsuario(Usuario usuario){
		
			
		Optional<Usuario> usuarioCpf = usuarios.findByCpf(usuario.getCpf());
		if(usuarioCpf.isPresent()){
			 throw new CpfExcepetion("O CPF informado já existe na base de dados.");
		 }
		
		Optional<Usuario> usuarioEmail = usuarios.findByEmail(usuario.getEmail());
		if(usuarioEmail.isPresent()){
			 throw new EmailExcepetion("O E-mail informado já existe na base de dados.");
		 }
		
		Optional<Usuario> usuarioTelefone = usuarios.findByTelefone(usuario.getTelefone());
		if(usuarioTelefone.isPresent()){
			 throw new TelefoneException("O Telefone celular informado já existe na base de dados.");
		 }
		
		
		
		if (usuario.isNovo() && StringUtils.isEmpty(usuario.getSenha())) {
			throw new SenhaObrigatoriaUsuarioException("Senha é obrigatória para novo usuário");
		}
		
		if(usuario.isNovo()){
			usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
			usuario.setConfirmaSenha(usuario.getSenha());
			
		}
		
		
		usuarios.save(usuario);
	}

}//END CLASS
