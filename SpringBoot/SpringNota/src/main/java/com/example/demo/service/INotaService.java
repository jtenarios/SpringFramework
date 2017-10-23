package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Nota;



public interface INotaService {
	
	List<Nota> findAll();

	Nota create(Nota Nota);

	Nota find(Integer id);

	Nota update(Nota Nota);

	void delete(Integer id);
}
