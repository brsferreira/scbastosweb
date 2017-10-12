package com.scbastos.model.Enumerators;

public enum EnumStatusImovel {
	
	Ativo("Ativo"),
	Inativo("Inativo");
	
	private String descricao;
	
	private EnumStatusImovel(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	
	
	
	

}//END ENUM
