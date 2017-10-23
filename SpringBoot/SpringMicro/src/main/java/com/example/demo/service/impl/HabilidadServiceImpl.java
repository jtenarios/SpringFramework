package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Habilidad;
import com.example.demo.repository.IHabilidadRepository;
import com.example.demo.service.IHabilidadService;


@Service
public class HabilidadServiceImpl implements IHabilidadService{

	@Autowired
	private IHabilidadRepository repo;
	
	@Override
	public List<Habilidad> findAll() {		
		return repo.findAll();
	}

	@Override
	public Habilidad create(Habilidad obj) {
		return repo.save(obj);
	}

	@Override
	public Habilidad find(Integer id) {		
		return repo.findOne(id);
	}

	@Override
	public Habilidad update(Habilidad obj) {
		return repo.save(obj);
	}

	@Override
	public void delete(Integer id) {
		repo.delete(id);
	}

	@Override
	public List<Habilidad> getHabilidadByPersonaId(Integer id) {		
		return repo.getHabilidadByPersonaId(id);
	}

}
