package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Persona;



@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{
	
	@Query("select p.id from persona p where p.correo = :correo")
	Integer getUserIdByEmail(@Param("correo") String correo) throws Exception;

}
	