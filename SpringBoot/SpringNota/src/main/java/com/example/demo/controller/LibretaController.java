package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Libreta;
import com.example.demo.model.Nota;
import com.example.demo.service.ILibretaService;

@Controller
public class LibretaController {

	@Autowired
	private ILibretaService service;

	@RequestMapping(value = "/libreta/registrar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registrar(@RequestBody Libreta libreta) {
		
		for(Nota n : libreta.getNotas()){
			n.setLibreta(libreta);
		}
		
		Libreta lib = service.create(libreta);
		return lib != null ? "1" : "0";
	}
}
