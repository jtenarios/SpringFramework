package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Libreta;



public interface ILibretaService {

	List<Libreta> findAll();

	Libreta create(Libreta Libreta);

	Libreta find(Integer id);

	Libreta update(Libreta Libreta);

	void delete(Integer id);

}
