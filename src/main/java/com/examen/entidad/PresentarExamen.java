package com.examen.entidad;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Id;

import lombok.Data;

@Data
public class PresentarExamen {
	private Long id;
	private Long idEstudiante;
	private LocalDateTime fecha;
	
}
