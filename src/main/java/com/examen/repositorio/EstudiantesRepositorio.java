package com.examen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.entidad.Estudiante;

@Repository
public interface EstudiantesRepositorio extends JpaRepository<Estudiante, Long> {

}
