package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "nota")
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNota;
	
	@JsonIgnore //sin esto sale guardado ciclico
	@ManyToOne
	@JoinColumn(name = "id_libreta", nullable = false) // necesario para que					
	// reconozca en el OneToMany
	private Libreta libreta;
	@Column(name = "texto", length = 100, nullable = false)
	private String texto;
	@Column(name = "estado", length = 1, nullable = false)
	private String estado;

	public int getIdNota() {
		return idNota;
	}

	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Libreta getLibreta() {
		return libreta;
	}

	public void setLibreta(Libreta libreta) {
		this.libreta = libreta;
	}
	
	

}
