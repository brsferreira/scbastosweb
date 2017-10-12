package com.scbastos.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.scbastos.model.Valor;

public class ValorConverter implements Converter<String, Valor>{

	@Override
	public Valor convert(String id_valor) {
		if(!StringUtils.isEmpty(id_valor)){
			Valor valor = new Valor();
			valor.setIdValor(Long.valueOf(id_valor));
			return valor;
		}
	
		return null;
	}

}
