package com.scbastos.repository.filter;

import com.scbastos.model.Enumerators.EnumSituacao;
import com.scbastos.model.Enumerators.EnumStatusImovel;
import com.scbastos.model.Enumerators.EnumTipoImovel;

public class ImovelFilter {
	
	private Long codigosc;
	private EnumTipoImovel tipoImovel;
	private EnumStatusImovel status;
	private EnumSituacao situacao;
	
	// GETTERS AND SETTERS ------------------------------------------------------------------------------
	
	public EnumTipoImovel getTipoImovel() {
		return tipoImovel;
	}
	public void setTipoImovel(EnumTipoImovel tipoImovel) {
		this.tipoImovel = tipoImovel;
	}
	public Long getCodigosc() {
		return codigosc;
	}
	public void setCodigosc(Long codigosc) {
		this.codigosc = codigosc;
	}
	public EnumStatusImovel getStatus() {
		return status;
	}
	public void setStatus(EnumStatusImovel status) {
		this.status = status;
	}
	public EnumSituacao getSituacao() {
		return situacao;
	}
	public void setSituacao(EnumSituacao situacao) {
		this.situacao = situacao;
	}

}//END CLASS
