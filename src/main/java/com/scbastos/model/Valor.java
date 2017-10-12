package com.scbastos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.web.context.annotation.SessionScope;

import com.scbastos.model.Enumerators.EnumImovelQuitado;
import com.scbastos.validation.Nome;

@SessionScope
@Entity
@Table(name="valor")
public class Valor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_valor;
	
	@NotNull(message = "Por favor, especifique o valor do imóvel")
	@DecimalMin(value="0.00", message = "O valor do imóvel deve ser positivo")
	@Column(name ="valor_atual")
	private BigDecimal valorAtual;
	
	@DecimalMin(value="0.00", message = "O valor do sinal deve ser positivo")
	private BigDecimal sinal;
	
	@Min(value = 0, message="O prazo de financiamento deve ser um valor positivo")
	@Column(name = "prazo_financiamento")
	private int prazoFinanciamento;
	
	@DecimalMin(value="0.00", message = "O saldo devedor deve ser positivo")
	@Column(name = "saldo_devedor")
	private BigDecimal saldoDevedor;
	
	@Nome
	@Column(name ="org_financeira")
	private String OrgFinanceira;
	
	@NotNull(message = "Por favor, especifique a se o imóvel está quitado ou não")
	@Enumerated(EnumType.STRING)
	private EnumImovelQuitado quitado;// = EnumImovelQuitado.NAO;
	
	@OneToOne(mappedBy = "valor")
	@JoinColumn(name= "id_valor")
	private Imovel imovel;
	
	@OneToMany(mappedBy ="valor", fetch= FetchType.LAZY)
	private List<ValorHistorico> valorHistorico;
	
	@Column(name= "data_inclusao_valor", updatable = false)
	private LocalDateTime dataInclusaoValor = LocalDateTime.now();

	// GETTERS AND SETTERS
	
	public Long getIdValor() {
		return id_valor;
	}
	public void setIdValor(Long id_valor) {
		this.id_valor = id_valor;
	}

	public BigDecimal getValorImovel() {
		return valorAtual;
	}
	public void setValorImovel(BigDecimal valorAtual) {
		this.valorAtual = valorAtual;
	}

	public BigDecimal getSinal() {
		return sinal;
	}
	public void setSinal(BigDecimal sinal) {
		this.sinal = sinal;
	}

	public int getPrazoFinanciamento() {
		return prazoFinanciamento;
	}
	public void setPrazoFinanciamento(int prazoFinanciamento) {
		this.prazoFinanciamento = prazoFinanciamento;
	}

	public BigDecimal getSaldoDevedor() {
		return saldoDevedor;
	}
	public void setSaldoDevedor(BigDecimal saldoDevedor) {
		this.saldoDevedor = saldoDevedor; 
				//(valorImovel.subtract(sinal));
	}
	public String getOrgFinanceira() {
		return OrgFinanceira;
	}

	public void setOrgFinanceira(String orgFinanceira) {
		OrgFinanceira = orgFinanceira;
	}
	
	public EnumImovelQuitado getQuitado() {
		return quitado;
	}
	public void setQuitado(EnumImovelQuitado quitado) {
		this.quitado = quitado;
	}

	
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	public List<ValorHistorico> getValorHistorico() {
		return valorHistorico;
	}
	public void setValorHistorico(List<ValorHistorico> valorHistorico) {
		this.valorHistorico = valorHistorico;
	}
	
	public LocalDateTime getDataInclusaoValor() {
		return dataInclusaoValor;
	}
	public void setDataInclusaoValor(LocalDateTime dataInclusaoValor) {
		this.dataInclusaoValor = dataInclusaoValor;
	}
	
	
	//HASHCODE AND EQUALS
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_valor == null) ? 0 : id_valor.hashCode());
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
		Valor other = (Valor) obj;
		if (id_valor == null) {
			if (other.id_valor != null)
				return false;
		} else if (!id_valor.equals(other.id_valor))
			return false;
		return true;
	}

	
	
	
	
	
	
	
	
	
	

}
