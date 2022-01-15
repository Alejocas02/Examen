package com.examen.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="estudiante")
@Data
public class Estudiante {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Long id;
	private String nombre;
	private int edad;
	private String ciudad;
	private String zonaHoraria;
	
}
