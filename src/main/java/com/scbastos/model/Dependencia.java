package com.scbastos.model;

import java.math.BigDecimal;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.scbastos.model.Enumerators.EnumDependencias;

@Embeddable
public class Dependencia {

	@Enumerated(EnumType.STRING)	
	private EnumDependencias nomeDependencia;
	
	private BigDecimal area;
	private int qtdDependencia;
	private String tipoPiso;
	private BigDecimal comprimento;
	private BigDecimal largura;
	private BigDecimal altura;
	
	// GETTERS AND SETTERS ------------------------------------------------------------------------------------
	
	public EnumDependencias getNomeDependencia() {
		return nomeDependencia;
	}
	public void setNomeDependencia(EnumDependencias nomeDependencia) {
		this.nomeDependencia = nomeDependencia;
	}
	public BigDecimal getArea() {
		return area;
	}
	public void setArea(BigDecimal area) {
		this.area = area;
	}
	public int getQtdDependencia() {
		return qtdDependencia;
	}
	public void setQtdDependencia(int qtdDependencia) {
		this.qtdDependencia = qtdDependencia;
	}
	public String getTipoPiso() {
		return tipoPiso;
	}
	public void setTipoPiso(String tipoPiso) {
		this.tipoPiso = tipoPiso;
	}
	public BigDecimal getComprimento() {
		return comprimento;
	}
	public void setComprimento(BigDecimal comprimento) {
		this.comprimento = comprimento;
	}
	public BigDecimal getLargura() {
		return largura;
	}
	public void setLargura(BigDecimal largura) {
		this.largura = largura;
	}
	public BigDecimal getAltura() {
		return altura;
	}
	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}
	
}
