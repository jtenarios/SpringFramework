package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Persona;

public interface IPersonaService {

	List<Persona> findAll();

	Persona create(Persona Persona);

	Persona find(Integer id);

	Persona update(Persona Persona);

	void delete(Integer id);
}
