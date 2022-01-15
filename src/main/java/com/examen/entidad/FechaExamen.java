package com.examen.entidad;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="fecha")
public class FechaExamen  {

	@Id
	private Long id;
	private LocalDateTime fecha;
}
