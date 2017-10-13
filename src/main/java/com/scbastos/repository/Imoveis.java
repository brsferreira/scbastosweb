package com.scbastos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scbastos.model.Imovel;
import com.scbastos.repository.helper.imovel.ImoveisQueries;

@Repository
public interface Imoveis extends JpaRepository<Imovel, Long>, ImoveisQueries {
	
	public Optional<Imovel> findByCodigosc(Long codigosc);
	public Optional<Imovel> findByMatricula(String matricula);
	public Optional<Imovel> findByInscricaoImobiliaria(String inscricaoImobiliaria);	
		
}
