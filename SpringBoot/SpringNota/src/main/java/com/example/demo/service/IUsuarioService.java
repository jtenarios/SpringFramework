package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Usuario;


public interface IUsuarioService {

	List<Usuario> findAll();

	Usuario create(Usuario usuario);

	Usuario find(Integer id);

	Usuario update(Usuario usuario);

	void delete(Integer id);
	
}
