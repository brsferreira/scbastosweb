package com.scbastos.model.Enumerators;

public enum EnumSituacao {

	Ocupado("Ocupado"),
	Vazio("Vazio"),
	Obras("Em obras"),
	Vendido("Vendido"),
	Alugado("Alugado");
	
	private String descricao;
	
	private EnumSituacao(String descricao ) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
