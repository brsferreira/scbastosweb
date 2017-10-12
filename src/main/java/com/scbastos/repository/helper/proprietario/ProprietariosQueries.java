package com.scbastos.repository.helper.proprietario;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.scbastos.model.Proprietario;
import com.scbastos.repository.filter.ProprietarioFilter;

public interface ProprietariosQueries {
	
	public Page<Proprietario> filtrarProprietario(ProprietarioFilter filtro, Pageable pageable);
	

}
