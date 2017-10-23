package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Libreta;
import com.example.demo.repository.ILibretaRepo;



@Service
public class LibretaServiceImpl implements ILibretaService{

	@Autowired
	private ILibretaRepo repository;
	
	@Override
	public List<Libreta> findAll() {
		return repository.findAll();
	}

	@Transactional
	@Override	
	public Libreta create(Libreta libreta) {
		return repository.save(libreta);
	}

	@Override
	public Libreta find(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public Libreta update(Libreta libreta) {
		return repository.save(libreta);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
