package com.examen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.entidad.Examen;

@Repository
public interface ExamenRepositorio extends JpaRepository<Examen, Long> {

}
