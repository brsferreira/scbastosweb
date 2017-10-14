package com.scbastos.model.Enumerators;

public enum EnumOrganizacaoFinanceira {
	
	CaixaEconomicaFederal("Caixa Ecônomica Federal");
	
	private String descricao;
	
	private EnumOrganizacaoFinanceira(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
