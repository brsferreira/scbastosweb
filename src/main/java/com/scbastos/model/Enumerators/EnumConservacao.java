package com.scbastos.model.Enumerators;

public enum EnumConservacao {
	
	ImovelNovo("Imóvel novo"),
	Otimo("Ótimo estado"),
	Reforma("Requer reforma"),
	Precario("Precário"),
	Pessimo("Péssimo"),
	Destruido("Destruído");
	
	private String enum_conservacao;
	
	private EnumConservacao(String conservacao) {
		this.enum_conservacao = conservacao;
	}

	public String getEnum_conservacao() {
		return enum_conservacao;
	}
	
	
}
