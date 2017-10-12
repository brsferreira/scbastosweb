package com.scbastos.model.Enumerators;

public enum EnumDependencias {
	
	AreaServiço("Area de Serviço"),
	BanheiroSocial("Banheiro Social"),
	BanheiroEmpregada("Banheiro de empregada"),
	Closet("Closet"),
	Copa("Copa"),
	Corredor("Corredor"),
	Cozinha("Cozinha"),
	Despensa("Despensa"),
	Escritório("Escritório"),
	Hall("Hall"),
	Lavabo("Lavabo"),
	Quarto("Quarto"),
	QuartoEmpregada("Quarto de empregada"),
	Quintal("Quintal"),
	Sala("Sala"),
	Suite("Suite"),
	Terraço("Terraço"),
	Varanda("Varanda");
	
	private String descricao;
	
	private EnumDependencias(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
