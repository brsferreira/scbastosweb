package com.scbastos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scbastos.controller.page.PageWrapper;
import com.scbastos.exceptions.CpfExcepetion;
import com.scbastos.exceptions.EmailExcepetion;
import com.scbastos.exceptions.TelefoneException;
import com.scbastos.model.Proprietario;
import com.scbastos.repository.Proprietarios;
import com.scbastos.repository.filter.ProprietarioFilter;
import com.scbastos.service.CadastroProprietarioService;

@Controller
@RequestMapping("/proprietario")
public class ProprietarioController {
	
	
	@Autowired
	private CadastroProprietarioService cadastroProprietarioService;
	
	
	@Autowired
	private Proprietarios proprietarios; 
	
			
	@RequestMapping("/novo")
	public ModelAndView novo(Proprietario proprietario) {
		ModelAndView mv = new ModelAndView("proprietario/CadastroProprietario");
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Proprietario proprietario, BindingResult result, RedirectAttributes atributes){
		
		if(result.hasErrors()){
			return novo(proprietario);
		}
		
		// Salvar no banco de dados
		
			try {
				cadastroProprietarioService.salvarProprietario(proprietario);
			} catch (CpfExcepetion e) {
					result.rejectValue("cpf",e.getMessage(), e.getMessage());
					return novo(proprietario);
				
			} catch (EmailExcepetion e) {
					result.rejectValue("email",e.getMessage(), e.getMessage());
					return novo(proprietario);
					
			} catch (TelefoneException e) {
					result.rejectValue("telefone",e.getMessage(), e.getMessage());
					return novo(proprietario);
			}
			
		atributes.addFlashAttribute("mensagem", "Proprietário cadastrado com sucesso");
		return new ModelAndView("redirect:/proprietario/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(ProprietarioFilter proprietarioFilter, BindingResult result
			,@PageableDefault(size = 2)Pageable pageable,HttpServletRequest httpServletRequest){
		ModelAndView mv = new ModelAndView("proprietario/pesquisarProprietario");
		mv.addObject("proprietarios", proprietarios.findAll());
		
		
		PageWrapper<Proprietario> paginaWrapper = new PageWrapper<>(proprietarios.filtrarProprietario(proprietarioFilter, pageable)
				,httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
		
		return mv;
	}
	
// IMPLEMENTACAO DA PESQUISA RAPIDA (DIALOGO NA PAGINA DE CADASTRO DO IMOVEL) ------------------------------	
	
	
}//END CLASS
