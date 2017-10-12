package com.scbastos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Entity
@Table(name = "valor_historico")
public class ValorHistorico  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_historico;
	
	@Column(name ="valor_historico")
	private BigDecimal valorHistorico;
	
	@Column(name ="data_alteracao_valor")
	private LocalDateTime dataAlteracao;
	
	@ManyToOne
	@JoinColumn(name ="id_valor")
	private Valor valor;
	
	// GETTERS AND SETTERS

	public Long getId_historico() {
		return id_historico;
	}

	public BigDecimal getValorAlterado() {
		return valorHistorico;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public Valor getValor() {
		return valor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_historico == null) ? 0 : id_historico.hashCode());
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
		ValorHistorico other = (ValorHistorico) obj;
		if (id_historico == null) {
			if (other.id_historico != null)
				return false;
		} else if (!id_historico.equals(other.id_historico))
			return false;
		return true;
	}
	
}//END CLASS
