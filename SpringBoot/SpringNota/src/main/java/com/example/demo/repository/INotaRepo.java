package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Nota;



@Repository
public interface INotaRepo extends JpaRepository<Nota, Integer>{

}