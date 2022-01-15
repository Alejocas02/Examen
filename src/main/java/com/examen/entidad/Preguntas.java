package com.examen.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="preguntas")
@Data
public class Preguntas implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Long id;
	private String pregunta;
	private String opcion1;
	private String opcion2;
	private String opcion3;
	private String opcion4;
	private int posicion;
}
