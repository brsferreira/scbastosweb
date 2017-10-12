package com.scbastos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="grupo" )
public class Grupo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id_grupo;
	
	private String nome;
	
	
	@ManyToMany
	@JoinTable(name = "grupo_permissao",joinColumns=@JoinColumn(name="id_grupo")
	 								 , inverseJoinColumns = @JoinColumn(name="id_permissao"))
	private List<Permissao> permissoes;
	
	// GETTERS AND SETTERS -----------------------------------------------------------------
	
	
	public Long getId_grupo() {
		return id_grupo;
	}
	public void setId_grupo(Long id_grupo) {
		this.id_grupo = id_grupo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Permissao> getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	//HASHCODE AND EQUALS --------------------------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_grupo == null) ? 0 : id_grupo.hashCode());
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
		Grupo other = (Grupo) obj;
		if (id_grupo == null) {
			if (other.id_grupo != null)
				return false;
		} else if (!id_grupo.equals(other.id_grupo))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	

}
