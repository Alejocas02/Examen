package com.examen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.entidad.RespuestasCorrectas;

@Repository
public interface RespuestasRepositorio extends JpaRepository<RespuestasCorrectas, Long>{
		public RespuestasCorrectas findByIdExamen(Long id_examen);
}
