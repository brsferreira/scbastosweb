package com.scbastos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.context.annotation.SessionScope;

import com.scbastos.model.Enumerators.EnumClassificacao;
import com.scbastos.model.Enumerators.EnumConservacao;
import com.scbastos.model.Enumerators.EnumDestinacao;
import com.scbastos.model.Enumerators.EnumExclusividadeImovel;
import com.scbastos.model.Enumerators.EnumSituacao;
import com.scbastos.model.Enumerators.EnumStatusImovel;
import com.scbastos.model.Enumerators.EnumTipoImovel;

@SessionScope
@Entity
@Table(name="imovel")
public class Imovel implements Serializable{
	

	private static final long serialVersionUID = 1L;

	// ATRIBUTOS ----------------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_imovel;
	
	@Digits(integer=5, fraction=0, message="O código SC deve conter no máximo 5 digitos.")
	@NotNull(message = "O código SC é obrigatório.")
	private Long codigosc;
	
	@Max(value = 100, message = "O número máximo de garagens não deve exceder 100")
	private int garagem;
	
	@Max(value = 1000, message ="A idade do imóvel não deve exceder 1000 anos")
	@Column(name="idade_imovel")
	private int idadeImovel;
	
	@Pattern(regexp="\\d+", message ="Apenas números são permitidos para matrícula do imóvel")
	@Size(max=15, message ="A matrícula do imóvel não deve exceder 15 digitos")
	@NotBlank(message="Por favor, informe a matricula do imóvel.")
	private String matricula;
	
	@Pattern(regexp="\\d+", message ="Apenas números são permitidos para inscrição imobiliária")
	@Size(max=15, message ="A inscrição do imóvel não deve exceder 15 digitos")
	@NotBlank(message="Por favor, informe a inscrição imobiliária do imóvel.")
	@Column(name="insc_imob")
	private String inscricaoImobiliaria;
	
	private String foto;
	
	@Column(name="content_type")
	private String contentType;
	
	@NotNull(message = "A data de captação é obrigatória.")
	@Column(name="data_captacao")
	private LocalDate dataCaptacao;
	
	@Column(name="data_cadastro")
	private LocalDateTime dataCadastro;
	
	@Digits(integer=7, fraction=2, message ="O valor máximo é 1.000.000,00m²")
	@Column(name="area_total")
	private BigDecimal areaTotal;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@NotBlank(message="Por favor, informe o corretor responsável.")
	private String corretor;
	
	@Size(max=150, message ="A descrição do imóvel não deve exceder 150 caracteres")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name ="id_proprietario")
	private Proprietario proprietario;
	
	@OneToOne(cascade= {CascadeType.PERSIST,  CascadeType.MERGE})
	@JoinColumn (name ="id_endereco")
	private Endereco endereco;
	
	@OneToOne(cascade= {CascadeType.PERSIST,  CascadeType.MERGE})
	@JoinColumn(name="id_valor")
	private Valor valor;
	
	@ElementCollection
	@CollectionTable(name="imovel_dependencia", joinColumns=@JoinColumn(name="id_imovel"))
	private Set<Dependencia> dependencia;
	
	//ENUMERATORS ------------------------------------------------------------------------------------------
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_imovel")
	private EnumTipoImovel tipoImovel;
	
	@Enumerated(EnumType.STRING)
	private EnumDestinacao destinacao;
	
	@Enumerated(EnumType.STRING)
	private EnumConservacao conservacao;
	
	@Enumerated(EnumType.STRING)
	private EnumClassificacao classificacao;
	
	@Enumerated(EnumType.STRING)
	private EnumSituacao situacao;
	
	@NotNull(message="Por favor, informe o Status do imóvel")
	@Enumerated(EnumType.STRING)
	private EnumStatusImovel status = EnumStatusImovel.Ativo;
	
	@NotNull(message="Por favor, informe a exlusividade do imóvel")
	@Enumerated(EnumType.STRING)
	private EnumExclusividadeImovel exclusividade_imovel = EnumExclusividadeImovel.NAO;
	
	//VERIFICAR SE O IMOVEL É UM NOVO CADASTRO
	
	public boolean isNovo(){
		return id_imovel == null;
	}
	
	
	//GETTERS AND SETTERS ---------------------------------------------------------------------------
	
	public Long getId_imovel() {
		return id_imovel;
	}
	public void setId_imovel(Long id_imovel) {
		this.id_imovel = id_imovel;
	}
	public Long getCodigosc() {
		return codigosc;
	}
	public void setCodigosc(Long codigosc) {
		this.codigosc = codigosc;
	}
	public int getGaragem() {
		return garagem;
	}
	public void setGaragem(int garagem) {
		this.garagem = garagem;
	}
	public int getIdadeImovel() {
		return idadeImovel;
	}
	public void setIdadeImovel(int idadeImovel) {
		this.idadeImovel = idadeImovel;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getInscricaoImobiliaria() {
		return inscricaoImobiliaria;
	}
	public void setInscricaoImobiliaria(String inscricaoImobiliaria) {
		this.inscricaoImobiliaria = inscricaoImobiliaria;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public LocalDate getDataCaptacao() {
		return dataCaptacao;
	}
	public void setDataCaptacao(LocalDate dataCaptacao) {
		this.dataCaptacao = dataCaptacao;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public BigDecimal getAreaTotal() {
		return areaTotal;
	}
	public void setAreaTotal(BigDecimal areaTotal) {
		this.areaTotal = areaTotal;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getCorretor() {
		return corretor;
	}
	public void setCorretor(String corretor) {
		this.corretor = corretor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Valor getValor() {
		return valor;
	}
	public void setValor(Valor valor) {
		this.valor = valor;
	}

	public EnumTipoImovel getTipoImovel() {
		return tipoImovel;
	}
	public void setTipoImovel(EnumTipoImovel tipoImovel) {
		this.tipoImovel = tipoImovel;
	}
	public EnumDestinacao getDestinacao() {
		return destinacao;
	}
	public void setDestinacao(EnumDestinacao destinacao) {
		this.destinacao = destinacao;
	}
	public EnumConservacao getConservacao() {
		return conservacao;
	}
	public void setConservacao(EnumConservacao conservacao) {
		this.conservacao = conservacao;
	}
	public EnumClassificacao getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(EnumClassificacao classificacao) {
		this.classificacao = classificacao;
	}
	public EnumSituacao getSituacao() {
		return situacao;
	}
	public void setSituacao(EnumSituacao situacao) {
		this.situacao = situacao;
	}
	public EnumStatusImovel getStatus() {
		return status;
	}
	public void setStatus(EnumStatusImovel status) {
		this.status = status;
	}
	public EnumExclusividadeImovel getExclusividade_imovel() {
		return exclusividade_imovel;
	}
	public void setExclusividade_imovel(EnumExclusividadeImovel exclusividade_imovel) {
		this.exclusividade_imovel = exclusividade_imovel;
	}
	
	//HASHCODE AND EQUALS -------------------------------------------------------------------------------------------
	
	public Set<Dependencia> getDependencia() {
		return dependencia;
	}
	public void setDependencia(Set<Dependencia> dependencia) {
		this.dependencia = dependencia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_imovel == null) ? 0 : id_imovel.hashCode());
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
		Imovel other = (Imovel) obj;
		if (id_imovel == null) {
			if (other.id_imovel != null)
				return false;
		} else if (!id_imovel.equals(other.id_imovel))
			return false;
		return true;
	}
	
	// OBSERVACOES IMPORTANTES
	
	
	
	/* ESSE CODIGO FOI DESABILITADO APOS A IMPORTACAO DO thymeleaf-extras-java8time
	 * 
	 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
	 * String formatDateTime = dataCadastro.format(formatter);
	 * return formatDateTime;
	 * 
	 */
	

}//END CLASS
