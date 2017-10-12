package com.scbastos.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.scbastos.model.Grupo;


public class GrupoConverter implements Converter<String, Grupo>{
	
	@Override
	public Grupo convert(String id_grupo) {
		if(!StringUtils.isEmpty(id_grupo)){
			Grupo grupo = new Grupo();
			grupo.setId_grupo(Long.valueOf(id_grupo));
			return grupo;
		}
	
		return null;
	}

}
