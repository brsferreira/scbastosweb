package com.scbastos.repository.filter;

import java.util.List;

import com.scbastos.model.Grupo;

public class UsuarioFilter {
	
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private List<Grupo> grupos;
	
	
	// GETTERS AND SETTERS ---------------------------------------------------------------------
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}//END CLASS
