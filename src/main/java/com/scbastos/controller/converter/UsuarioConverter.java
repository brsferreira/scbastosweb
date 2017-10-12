package com.scbastos.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;
import com.scbastos.model.Usuario;

public class UsuarioConverter implements Converter<String, Usuario> {
	
	@Override
	public Usuario convert(String id_usuario) {
		if(!StringUtils.isEmpty(id_usuario)){
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(Long.valueOf(id_usuario));
			return usuario;
		}
		
		return null;
	}

}
