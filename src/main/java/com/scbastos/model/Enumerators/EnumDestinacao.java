package com.scbastos.model.Enumerators;

public enum EnumDestinacao {
	
	Compra("Compra"),
	Venda("Venda");
	
	private String enum_destinacao;
	
	private EnumDestinacao(String destinacao) {
		this.enum_destinacao = destinacao;
	}

	public String getEnum_destinacao() {
		return enum_destinacao;
	}


	
	

}//END ENUM
