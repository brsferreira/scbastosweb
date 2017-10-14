package com.scbastos.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.scbastos.model.Proprietario;

public class ProprietarioConverter implements Converter<String, Proprietario> {

	@Override
	public Proprietario convert(String id_proprietario) {
		if(!StringUtils.isEmpty(id_proprietario)){
			Proprietario proprietario = new Proprietario();
			proprietario.setId_proprietario(Long.valueOf(id_proprietario));
			return proprietario;
		}
		
		return null;
	}

}
