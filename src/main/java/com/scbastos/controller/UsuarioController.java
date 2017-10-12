package com.scbastos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scbastos.exceptions.CpfExcepetion;
import com.scbastos.exceptions.EmailExcepetion;
import com.scbastos.exceptions.SenhaObrigatoriaUsuarioException;
import com.scbastos.exceptions.TelefoneException;
import com.scbastos.model.Usuario;
import com.scbastos.repository.Grupos;
import com.scbastos.repository.Usuarios;
import com.scbastos.repository.filter.UsuarioFilter;
import com.scbastos.service.CadastroUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	
	@Autowired
	CadastroUsuarioService cadastroUsuarioService;
	
	@Autowired
	private Grupos grupos;
	
	@Autowired
	private Usuarios usuarios;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Usuario usuario) {
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		mv.addObject("grupos", grupos.findAll());
		
		return mv;
		
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Usuario usuario, BindingResult result, RedirectAttributes atributes){
		
		if(result.hasErrors()){
			System.out.println("TEM ERRO !!!! ");
			return novo(usuario);
		}
		
		// Salvar no banco de dados
		
		
		try {
				cadastroUsuarioService.salvarUsuario(usuario);
				
		} catch (CpfExcepetion e) {
				result.rejectValue("cpf", e.getMessage(), e.getMessage());
				return novo(usuario);
		} catch(EmailExcepetion e){
				result.rejectValue("email", e.getMessage(), e.getMessage());
				return novo(usuario);
				
		}catch (SenhaObrigatoriaUsuarioException e) {
			result.rejectValue("senha", e.getMessage(), e.getMessage());
			return novo(usuario);
			
		} catch (TelefoneException e) {
			result.rejectValue("telefone", e.getMessage(), e.getMessage());
			return novo(usuario);
		}
		
		atributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso");
		return new ModelAndView("redirect:/usuario/novo");
		
	}
	
	@GetMapping
	public ModelAndView pesquisarUsuario(UsuarioFilter usuarioFilter){
		ModelAndView mv = new ModelAndView("/usuario/pesquisaUsuario");
		mv.addObject("usuarios", usuarios.filtrarUsuario(usuarioFilter));
		mv.addObject("grupos", grupos.findAll());
		return mv;
	}
	
	

}//END CLASS
