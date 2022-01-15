package com.examen.entidad;

import java.util.List;

import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class ExamenDto {
	private Long id;
    private List<Preguntas> preguntas;
}
