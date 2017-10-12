package com.scbastos.model.Enumerators;

public enum EnumExclusividadeImovel {
	
	SIM("Exclusividade"),
	NAO("Não");
	
	private String imovel_exclusividade;
	
	private EnumExclusividadeImovel(String exclusividade) {
		this.imovel_exclusividade = exclusividade;
	}

	public String getImovel_exclusividade() {
		return imovel_exclusividade;
	}
	

}//END ENUM
