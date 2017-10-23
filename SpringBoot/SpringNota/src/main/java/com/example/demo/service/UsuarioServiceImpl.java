package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.IUsuarioRepo;


@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioRepo repository;

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	public Usuario create(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public Usuario find(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public Usuario update(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}
}
