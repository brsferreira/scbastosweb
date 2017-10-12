package com.scbastos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bairro")
public class Bairro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id_bairro;
	
	@Column(name = "nome_bairro")
	private String nomeBairro;
	
	@ManyToOne
	@JoinColumn(name = "id_municipio")
	private Municipio municipio;
	
	@OneToMany(mappedBy="bairro")
	private List<Endereco> endereco;

	//GETTERS AND SETTERS
	
	public String getNomeBairro() {
		return nomeBairro;
	}

	public Long getId_bairro() {
		return id_bairro;
	}

	public void setId_bairro(Long id_bairro) {
		this.id_bairro = id_bairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	//HASHCODE AND EQUALS
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_bairro == null) ? 0 : id_bairro.hashCode());
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
		Bairro other = (Bairro) obj;
		if (id_bairro == null) {
			if (other.id_bairro != null)
				return false;
		} else if (!id_bairro.equals(other.id_bairro))
			return false;
		return true;
	}
}//END CLASS
