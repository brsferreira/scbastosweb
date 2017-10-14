package com.scbastos.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.web.context.annotation.SessionScope;

import com.scbastos.validation.Nome;

@SessionScope
@Entity
@Table(name = "proprietario")
public class Proprietario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_proprietario;
	
	@Nome
	@NotBlank(message = "Por favor, informe o nome do proprietário é obrigatório.")
	private String nome;
	
	@NotBlank(message ="Por favor, informe o telefone do proprietário.")
	private String telefone;
	
	@Email(message="E-mail inválido.")
	private String email;
	
	@CPF(message = "CPF inválido.")
	@NotBlank(message = "Por favor, informe o CPF do proprietario.")
	private String cpf;
	
	private LocalDateTime data_cadastro = LocalDateTime.now();
	
	@OneToMany(mappedBy = "proprietario")
	private List<Imovel> imoveis;
	
	
	//GETTERS AND SETTERS -------------------------------------------------

	public Long getId_proprietario() {
		return id_proprietario;
	}

	public void setId_proprietario(Long id_proprietario) {
		this.id_proprietario = id_proprietario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.trim().toLowerCase();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;                    /*cpf.replaceAll("\\.|-", "");*/
	}

	public String getData_cadastro() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
		String formatDateTime = data_cadastro.format(formatter);
		return formatDateTime;
	}

	public void setData_cadastro(LocalDateTime data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	
	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}
	
	//HASHCODE AND EQUALS -------------------------------------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_proprietario == null) ? 0 : id_proprietario.hashCode());
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
		Proprietario other = (Proprietario) obj;
		if (id_proprietario == null) {
			if (other.id_proprietario != null)
				return false;
		} else if (!id_proprietario.equals(other.id_proprietario))
			return false;
		return true;
	}
	
	
	//REMOVER FORMATO CPF PARA SALVA NO BANCO DE DADOS ----------
	 
	/*	@PrePersist @PreUpdate
	 *	private void prePersistPreUpdate() {
	 *	this.cpf = this.cpf.replaceAll("\\.|-", "");
	 *	this.email =this.email.toLowerCase();
	}*/
	
	
	/* VERIFICAR !!!!
	  
	  	private String getCpfFormater() {
		Pattern pattern = Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})");
		Matcher matcher = pattern.matcher(cpf);
		if (matcher.matches()) 
		cpf = matcher.replaceAll("$1.$2.$3-$4");
		return cpf;
	}*/
	



}//END CLASS
