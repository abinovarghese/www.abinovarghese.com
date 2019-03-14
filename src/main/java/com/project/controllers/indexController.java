package com.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@CrossOrigin
@Controller
public class indexController {
	@RequestMapping("/")
	public ModelAndView index(){
		return new ModelAndView("index");
	}
	
	@RequestMapping("/jarvis")
	public ModelAndView jarvis(){
		return new ModelAndView("jarvis");
	}
	
	@RequestMapping("/jarviz")
	public ModelAndView jarviz(){
		return new ModelAndView("jarvis");
	}
	
	@RequestMapping("/brain2.rive")
	public ModelAndView brain(){
		return new ModelAndView("brain");
	}
	
	
}
