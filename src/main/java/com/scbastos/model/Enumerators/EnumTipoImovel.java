package com.scbastos.model.Enumerators;

public enum EnumTipoImovel {
	
	Apartamento("Apartamento"),
	Casa("Casa"),
	Terreno("Terreno"),
	Comercio("Comércio"),
	Galpao("Galpão"),
	Deposito("Depósito");
	
	private String descricao;
	
	EnumTipoImovel(String descricao){
		this.descricao = descricao;
		
	}

	public String getDescricao() {
		return descricao;
	}

}//END ENUM
