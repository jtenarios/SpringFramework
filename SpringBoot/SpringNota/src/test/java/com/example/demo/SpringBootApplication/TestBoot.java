package com.example.demo.SpringBootApplication;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Usuario;
import com.example.demo.service.IUsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBoot {

	@Autowired
	private IUsuarioService service;

	@Autowired
	private BCryptPasswordEncoder bCryptEnconder;

	@Test
	public void crearUsuario() {
		Usuario us = new Usuario();
		us.setId(2);		
		us.setNombre("HAMP");
		us.setClave(bCryptEnconder.encode("123456789"));
		us.setTipo("ROLE_ADMIN");
		us.setEstado("1");		
		
		Usuario retorno = service.create(us);
		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}
}
