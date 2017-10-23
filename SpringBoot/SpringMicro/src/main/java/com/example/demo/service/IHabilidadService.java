package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Habilidad;

public interface IHabilidadService extends CRUD<Habilidad> {
	
	List<Habilidad> getHabilidadByPersonaId(Integer id);
}