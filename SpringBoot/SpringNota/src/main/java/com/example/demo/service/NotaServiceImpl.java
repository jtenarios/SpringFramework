package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Nota;
import com.example.demo.repository.INotaRepo;



@Service
public class NotaServiceImpl implements INotaService {

	@Autowired
	private INotaRepo repository;
	
	@Override
	public List<Nota> findAll() {
		return repository.findAll();
	}

	@Override
	public Nota create(Nota nota) {
		return repository.save(nota);
	}

	@Override
	public Nota find(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public Nota update(Nota nota) {
		return repository.save(nota);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
