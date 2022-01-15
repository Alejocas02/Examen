package com.examen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.entidad.Preguntas;

@Repository
public interface PreguntasRepositorio extends JpaRepository<Preguntas, Long> {

}
