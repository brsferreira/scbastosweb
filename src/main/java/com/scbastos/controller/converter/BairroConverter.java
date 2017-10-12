package com.scbastos.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.scbastos.model.Bairro;

public class BairroConverter implements Converter<String, Bairro> {

	@Override
	public Bairro convert(String id_bairro) {
		if(!StringUtils.isEmpty(id_bairro)){
			Bairro bairro = new Bairro();
			bairro.setId_bairro(Long.valueOf(id_bairro));
			return bairro;
		}
		
		return null;
	}
	
}
