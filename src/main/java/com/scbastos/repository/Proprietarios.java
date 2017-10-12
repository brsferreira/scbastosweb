package com.scbastos.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scbastos.model.Proprietario;
import com.scbastos.repository.helper.proprietario.ProprietariosQueries;


@Repository
public interface Proprietarios extends JpaRepository<Proprietario, Long>, ProprietariosQueries{
	
	public Optional<Proprietario> findByCpf(String cpf);
	public Optional<Proprietario> findByEmail(String email);
	public Optional<Proprietario> findByTelefone(String telefone);
	public List<Proprietario> findByNomeStartingWithIgnoreCase(String nome);

}//END INTERFACE
