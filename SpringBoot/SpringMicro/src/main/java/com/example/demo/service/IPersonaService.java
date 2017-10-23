package com.example.demo.service;

import com.example.demo.model.Persona;

public interface IPersonaService extends CRUD<Persona>{

	Integer getUserIdByEmail(String correo) throws Exception;
	
}
