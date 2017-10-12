package com.scbastos.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.scbastos.model.Municipio;

public class MunicipioConverter implements Converter<String, Municipio>{
	
	@Override
	public Municipio convert(String id_municipio) {
		if(!StringUtils.isEmpty(id_municipio)){
			Municipio municipio = new Municipio();
			municipio.setId_municipio(Long.valueOf(id_municipio));
			return municipio;
		}
		
	return null;	

	}
}//END CLASS
