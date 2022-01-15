package com.examen.servicio;

import java.util.List;

import com.examen.entidad.Estudiante;
import com.examen.entidad.ExamenDto;
import com.examen.entidad.FechaExamen;
import com.examen.entidad.Preguntas;
import com.examen.entidad.PresentarExamen;
import com.examen.entidad.PuntajeDto;
import com.examen.entidad.RespuestasEstudiante;

public interface IServicio {

	public ExamenDto crearExamen();
	public Preguntas crearPreguntas(Preguntas preguntas);
	public Estudiante crearEstudiante(Estudiante estudiante);
	public List<Preguntas> obtenerPreguntas();
	public FechaExamen definirFecha(FechaExamen fecha);
	public PresentarExamen presentar(Long id);
	public PuntajeDto obtenerNota(RespuestasEstudiante respuestas );
	public List<RespuestasEstudiante> obtenerRespuestas();
}
