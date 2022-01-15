package com.examen.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="respuestasEstudiante")
@Data
public class RespuestasEstudiante {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Long id;
	private Long idExamen;
	private int[] respuestas;
}
