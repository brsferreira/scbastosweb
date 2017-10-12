package com.scbastos.model;

import java.io.Serializable;
import java.time.LocalDateTime;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_endereco;
	
	@NotBlank(message = "O logradouro é obrigatório")
	private String logradouro;
	
	private String complemento;
	
	@NotBlank(message = "Por favor, informe o CEP do endereço")
	private String cep;
	
	@Min(value=1, message="O número do imóvel não pode ser 0 ou inferior")
	@Max(value= 99999, message="O número do imóvel dever menor que 99999")
	@NotBlank(message = "Por favor, informe o número do imóvel")
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "id_bairro")
	private Bairro bairro;
	
	private LocalDateTime data_cadastro = LocalDateTime.now();;
	
	@OneToOne(mappedBy ="endereco")
	private Imovel imovel;
	
	// GETTERS AND SETTERS
	
	public Long getIdEndereco() {
		return id_endereco;
	}
	public void setIdEndereco(Long id_endereco) {
		this.id_endereco = id_endereco;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public LocalDateTime getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(LocalDateTime data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	
	// HASHCODE AND EQUALS ------------------------------------------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_endereco == null) ? 0 : id_endereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (id_endereco == null) {
			if (other.id_endereco != null)
				return false;
		} else if (!id_endereco.equals(other.id_endereco))
			return false;
		return true;
	}
	

}// END CLASS
