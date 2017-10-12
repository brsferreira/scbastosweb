package com.scbastos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="permissao")
public class Permissao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id_permissao;
	private String nome;
	
	// GETTERS AND SETTERS -----------------------------------------------------------------
	
	public Long getId_permissao() {
		return id_permissao;
	}
	public void setId_permissao(Long id_permissao) {
		this.id_permissao = id_permissao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//HASHCODE AND EQUALS --------------------------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_permissao == null) ? 0 : id_permissao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permissao other = (Permissao) obj;
		if (id_permissao == null) {
			if (other.id_permissao != null)
				return false;
		} else if (!id_permissao.equals(other.id_permissao))
			return false;
		return true;
	}
	
}//END CLASS
