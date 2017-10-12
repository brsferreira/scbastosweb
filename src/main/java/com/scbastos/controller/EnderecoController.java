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

import com.scbastos.model.Endereco;
import com.scbastos.repository.Bairros;
import com.scbastos.repository.Municipios;
import com.scbastos.service.CadastroEnderecoService;

@Controller
//@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private Bairros bairros;
	
	@Autowired
	private Municipios municipios;
	
	@Autowired
	private CadastroEnderecoService cadastroEnderecoService;
	
	@RequestMapping("/endereco/novo")
	public ModelAndView novo(Endereco endereco){
		ModelAndView mv = new ModelAndView("endereco/CadastroEndereco");
		mv.addObject("municipios",municipios.findAll());
		mv.addObject("bairros",bairros.findAll());
		
		return mv;
	}
	
	
	@RequestMapping(value="/endereco/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Endereco endereco, BindingResult result, Model model, RedirectAttributes atributes){
		
		if(result.hasErrors()){
			System.out.println("TEM ERRO !!!! ");
			return novo(endereco);
		}
		
		// Salvar no banco de dados
		
		cadastroEnderecoService.salvarImovel(endereco);
		//atributes.addFlashAttribute(endereco);
		atributes.addFlashAttribute("mensagem", "Endereco cadastrado com sucesso");
		return new ModelAndView("redirect:/endereco/novo");
		
	}

}// END CLASS
