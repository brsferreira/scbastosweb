package com.scbastos.repository.helper.imovel;

import java.util.List;

import com.scbastos.model.Imovel;
import com.scbastos.repository.filter.ImovelFilter;

public interface ImoveisQueries {
	
	public List<Imovel> filtrar(ImovelFilter filtro);

}
