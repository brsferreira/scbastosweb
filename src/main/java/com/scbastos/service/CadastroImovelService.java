package com.scbastos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scbastos.exceptions.ImovelCodigoSCExpetion;
import com.scbastos.exceptions.InscricaoException;
import com.scbastos.exceptions.MatriculaException;
import com.scbastos.model.Imovel;
import com.scbastos.repository.Imoveis;

@Service
public class CadastroImovelService {
	
	@Autowired
	private Imoveis imoveis;
	
	
	@Transactional
	public void salvarImovel(Imovel imovel){
		
		Optional<Imovel> imovelSC = imoveis.findByCodigosc(imovel.getCodigosc());
		if(imovelSC.isPresent()){
			 throw new ImovelCodigoSCExpetion("O CódigoSC informado já existe na base de dados.");
		 }
		
		Optional<Imovel> matricula = imoveis.findByMatricula(imovel.getMatricula());
		if(matricula.isPresent()){
			throw new MatriculaException("A matrícula do imóvel já exixte na base de dados.");
		}
		
		Optional<Imovel> inscricao = imoveis.findByInscricaoImobiliaria(imovel.getInscricaoImobiliaria());
		if(inscricao.isPresent()){
			throw new InscricaoException("Detectamos um imóvel com a mesma Inscrição imobiliária.");
		}
		
/*		List<Imovel> PropCpf = imoveis.cpfs(imovel);
		if(!PropCpf.isEmpty()){
			throw new CpfExcepetion("O cpf informado já existe na base de dados.");
		}*/
		
		imoveis.save(imovel);

	}

}