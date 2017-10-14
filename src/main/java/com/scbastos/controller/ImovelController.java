package com.scbastos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scbastos.exceptions.ImovelCodigoSCExpetion;
import com.scbastos.exceptions.InscricaoException;
import com.scbastos.exceptions.MatriculaException;
import com.scbastos.model.Dependencia;
import com.scbastos.model.Imovel;
import com.scbastos.model.Enumerators.EnumClassificacao;
import com.scbastos.model.Enumerators.EnumConservacao;
import com.scbastos.model.Enumerators.EnumDependencias;
import com.scbastos.model.Enumerators.EnumDestinacao;
import com.scbastos.model.Enumerators.EnumExclusividadeImovel;
import com.scbastos.model.Enumerators.EnumOrganizacaoFinanceira;
import com.scbastos.model.Enumerators.EnumSituacao;
import com.scbastos.model.Enumerators.EnumStatusImovel;
import com.scbastos.model.Enumerators.EnumTipoImovel;
import com.scbastos.repository.Bairros;
import com.scbastos.repository.Imoveis;
import com.scbastos.repository.Municipios;
import com.scbastos.repository.Proprietarios;
import com.scbastos.repository.Usuarios;
import com.scbastos.repository.filter.ImovelFilter;
import com.scbastos.security.UsuarioSistema;
import com.scbastos.service.CadastroImovelService;

@SessionScope
@Controller
@RequestMapping("/imovel")
public class ImovelController {
	
	@Autowired
	private CadastroImovelService cadastroImovelService;
	
	
	// REPOSITORIOS -------------
	
	
	@Autowired
	private Imoveis imoveis;
	
	@Autowired
	private Usuarios usuariosRepository;
	
	@Autowired
	private Bairros bairrosRepository;
	
	@Autowired
	private Municipios municipiosRepository;
	
	
	@RequestMapping("/novo")
	public ModelAndView novo(Imovel imovel){
		ModelAndView mv = new ModelAndView("imovel/CadastroImovel");
		
		mv.addObject("tipoImoveis", EnumTipoImovel.values());
		mv.addObject("destinacoes", EnumDestinacao.values());
		mv.addObject("conservacao", EnumConservacao.values());
		mv.addObject("classificacoes", EnumClassificacao.values());
		mv.addObject("situacoes", EnumSituacao.values());
		mv.addObject("statusImovel",EnumStatusImovel.values());
		mv.addObject("exclusividadeImovel",EnumExclusividadeImovel.values());
		mv.addObject("usuario",usuariosRepository.CorretorAtivo());
		mv.addObject("bairros",bairrosRepository.findAll());
		mv.addObject("municipios",municipiosRepository.findAll());
		mv.addObject("dependencias",EnumDependencias.values());
		mv.addObject("dependencia",Dependencia.class);
		mv.addObject("OrgFinanceira", EnumOrganizacaoFinanceira.values());
		
		return mv;
	}
	
	@RequestMapping(value = "/novo" ,method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Imovel imovel
			,BindingResult result
			,RedirectAttributes atributes
			,@AuthenticationPrincipal UsuarioSistema usuarioSistema){
		
		imovel.setUsuario(usuarioSistema.getUsuario());
		
		if(result.hasErrors()){
			return novo(imovel);
		}
		
		// Salvar no banco de dados
		
	try {

	 		cadastroImovelService.salvarImovel(imovel);
			
	} catch (ImovelCodigoSCExpetion sc){
			result.rejectValue("codigosc",sc.getMessage(), sc.getMessage());
			return novo(imovel);
			
	} catch (MatriculaException mat){
			result.rejectValue("matricula",mat.getMessage(), mat.getMessage());
			return novo(imovel);
			
	} catch (InscricaoException i){
			result.rejectValue("inscricaoImobiliaria",i.getMessage(), i.getMessage());
			return novo(imovel);
	} 
		
		atributes.addFlashAttribute("mensagem", "Imovel cadastrado com sucesso");
		return new ModelAndView("redirect:/imovel/novo");
	}
	
	// PESQUISA DE IMOVEIS----------------------------------------------------------
	@GetMapping
	public ModelAndView pesquisar(ImovelFilter imovelFilter, BindingResult result) {
		
		ModelAndView mv = new ModelAndView("imovel/PesquisaImoveis");
		
		mv.addObject("tipoImoveis", EnumTipoImovel.values());
		mv.addObject("status",EnumStatusImovel.values());
		mv.addObject("situacao",EnumSituacao.values());
		mv.addObject("imoveis",imoveis.filtrar(imovelFilter));
		
		return mv;
	}
	
}//END CLASS
