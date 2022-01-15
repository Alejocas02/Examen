package com.examen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.entidad.RespuestasEstudiante;

@Repository
public interface RespuestaEstudianteRepositorio extends JpaRepository<RespuestasEstudiante, Long>{

}
