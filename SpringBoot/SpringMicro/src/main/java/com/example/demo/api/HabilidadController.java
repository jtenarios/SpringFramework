package com.example.demo.api;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Habilidad;
import com.example.demo.service.IHabilidadService;


@RestController
@RequestMapping("/habilidad")
public class HabilidadController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IHabilidadService service;

	@RequestMapping(value = "/listar/{idPersona}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Habilidad>> getAll(@PathVariable("idPersona") Integer id) {
		logger.info("> getAll [Habilidad]");

		List<Habilidad> list = null;
		try {
			list = service.getHabilidadByPersonaId(id);
 
			if (list == null) {
				list = new ArrayList<Habilidad>();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Habilidad>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAll [Habilidad Persona]");
		return new ResponseEntity<List<Habilidad>>(list, HttpStatus.OK);
	}
}
