package com.scbastos.model.Enumerators;

public enum EnumClassificacao {
	
	Duplex("Duplex"),
	Linear("Linear"),
	Sobrado("Sobrado"),
	Terrea("Térrea"),
	Triplex("Triplex");
	
	private String enum_classificacao;
	
	private EnumClassificacao(String classificacao) {
		this.enum_classificacao = classificacao;
	}

	public String getEnum_classificacao() {
		return enum_classificacao;
	}
	


	
}

