package com.scbastos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scbastos.model.Valor;
import com.scbastos.model.Enumerators.EnumImovelQuitado;
import com.scbastos.service.CadastroValoresService;

@Controller
public class ValorImovelController {
	
	
	@Autowired
	private CadastroValoresService cadastroValoresService;
	
	@RequestMapping("/valores/novo")
	public ModelAndView novo(Valor valor) {
		ModelAndView mv = new ModelAndView("valores/cadastroValoresImovel");
		mv.addObject("EnumImovelQuitado", EnumImovelQuitado.values());
		return mv;
		
	}
	
	
	@RequestMapping(value = "/valores/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Valor valor, BindingResult result, Model model, RedirectAttributes atributes){
		
		if(result.hasErrors()){
			System.out.println("TEM ERRO !!!! ");
			return novo(valor);
		}
		
		// Salvar no banco de dados
		cadastroValoresService.salvarValores(valor);
		atributes.addFlashAttribute(valor);
		atributes.addFlashAttribute("mensagem", "Valores cadastrados com sucesso");
		return new ModelAndView("redirect:/imovel/novo");
		
	}


}//END CLASS
