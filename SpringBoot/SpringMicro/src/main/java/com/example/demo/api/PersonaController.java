package com.example.demo.api;

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

import com.example.demo.model.Persona;
import com.example.demo.service.IPersonaService;


@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IPersonaService service;

	@RequestMapping(value = "/leer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> getId(@PathVariable("id") Integer id){
		logger.info("> getId [Persona]");
		
		Persona per = null;
		try {
			per = service.find(id);
 
			if (per == null) {
				per = new Persona();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Persona>(per, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< get [Persona]");
		return new ResponseEntity<Persona>(per, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/leerCorreo/{correo:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> getPersonaId(@PathVariable("correo") String correo) {
		logger.info("> get [leerCorreo]");

		Integer id = 0;
		try {			
			logger.info("Enviando el correo " + correo);
			id = service.getUserIdByEmail(correo);		
			id = id == null ? 0 : id;
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Integer>(id, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< get [leerCorreo] id: " + id);
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}
}

