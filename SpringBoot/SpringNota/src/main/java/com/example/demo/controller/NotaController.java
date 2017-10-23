package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotaController {
	
	@RequestMapping("/nota")
	public String irNota(@RequestParam(value = "nombre", required = false, defaultValue = "HAMP") String nombre,
			Model model) {
		model.addAttribute("nombre", nombre);
		return "nota";
	}
	

}