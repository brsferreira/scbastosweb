package com.scbastos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import com.scbastos.validation.AtributoSenha;
import com.scbastos.validation.Nome;

@AtributoSenha(atributo="senha", atributoConfirmacao="confirmaSenha")
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@Nome
	@NotBlank(message = "Por favor, informe o nome do usuário.")
	private String nome;
	
	@NotBlank(message = "Por favor, informe o telefone do usuário.")
	private String telefone;
	
	@Email(message="E-mail inválido. Evite espaços e acentos")
	@NotBlank(message = "Por favor, informe o email do usuário.")
	private String email;
	
	@CPF(message = "CPF inválido.")
	@NotBlank(message = "Por favor, informe o CPF do usuário.")
	private String cpf;
	
	private String senha;
	
	@Transient
	private String confirmaSenha;
	
	@NotNull(message = "Por favor, especifique o Status do usuário") // <----- ATENCAO !!!!
	private Boolean ativo = true;
	
	@Size(min = 1, message = "Selecione ao menos 1(um) grupo.")
	@ManyToMany
	@JoinTable(name = "usuario_grupo",joinColumns=@JoinColumn(name="id_usuario"), inverseJoinColumns = @JoinColumn(name="id_grupo"))
	private List<Grupo> grupos;
	
	private LocalDateTime data_cadastro = LocalDateTime.now();
	
	private LocalDate data_nascimento;
	
	
	// USUARIO NOVO -------
	
	public boolean isNovo(){
		return id_usuario == null;
		
	}
	
	
	//REMOVER FORMATO CPF PARA SALVA NO BANCO DE DADOS ----------
	
	/* A formatacao do cpf está causando a exceção  de UNIQUE Key na base de dados
	 * javax.persistence.PersistenceException: 
	 * org.hibernate.exception.ConstraintViolationException: 
	 * could not execute statement
	 */
	
/*	@PrePersist @PreUpdate
	private void prePersistPreUpdate() {
		this.cpf = this.cpf.replaceAll("\\.|-", "");
	}*/
	
	
	
	// GETTERS AND SETTERS ---------------------------------------
	
	public Long getIdUsuario() {
		return id_usuario;
	}

	public void setIdUsuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.trim();
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
		this.cpf = cpf;                     /*cpf.replaceAll("\\.|-", "");*/
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(LocalDateTime data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	//HASHCODE AND EQUALS -----------------------------------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id_usuario == null) {
			if (other.id_usuario != null)
				return false;
		} else if (!id_usuario.equals(other.id_usuario))
			return false;
		return true;
	}


	
	
}//END CLASS
