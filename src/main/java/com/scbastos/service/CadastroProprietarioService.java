package com.scbastos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scbastos.exceptions.CpfExcepetion;
import com.scbastos.exceptions.EmailExcepetion;
import com.scbastos.exceptions.TelefoneException;
import com.scbastos.model.Proprietario;
import com.scbastos.repository.Proprietarios;

@Service
public class CadastroProprietarioService {
	
	@Autowired
	private Proprietarios proprietarios;
	
	@Transactional
	public void salvarProprietario(Proprietario proprietario){
		
		Optional<Proprietario> proprietarioCpf = proprietarios.findByCpf(proprietario.getCpf());
		if(proprietarioCpf.isPresent()){
			 throw new CpfExcepetion("O cpf informado já existe na base de dados.");
		 }
		
		Optional<Proprietario> proprietarioEmail = proprietarios.findByEmail(proprietario.getEmail());
		if(proprietarioEmail.isPresent()){
			 throw new EmailExcepetion("O Email informado já existe na base de dados.");
		 }
		
		Optional<Proprietario> proprietarioTelefone = proprietarios.findByTelefone(proprietario.getTelefone());
		if(proprietarioTelefone.isPresent()){
			 throw new TelefoneException("O Telefone informado já existe na base de dados.");
		 }
		
		proprietarios.save(proprietario);

	}
}
