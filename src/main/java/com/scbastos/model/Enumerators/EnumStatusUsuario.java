package com.scbastos.model.Enumerators;

public enum EnumStatusUsuario {
	
	Ativo("Ativo"),
	Inativo("inativo");
	
	private String status_usuario;
	
	EnumStatusUsuario(String status_usuario) {
		this.status_usuario = status_usuario;
	}

	public String getStatus_usuario() {
		return status_usuario;
	}
	
}
