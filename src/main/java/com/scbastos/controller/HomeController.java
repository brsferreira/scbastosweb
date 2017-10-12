package com.scbastos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("/Dashboard");
		return mv;
	}
}
