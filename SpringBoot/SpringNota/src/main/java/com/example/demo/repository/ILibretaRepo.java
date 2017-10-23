package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Libreta;


@Repository
public interface ILibretaRepo extends JpaRepository<Libreta, Integer>{

	
}