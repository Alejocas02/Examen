package com.examen.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.entidad.Estudiante;
import com.examen.entidad.ExamenDto;
import com.examen.entidad.FechaExamen;
import com.examen.entidad.Preguntas;
import com.examen.entidad.PresentarExamen;
import com.examen.entidad.PuntajeDto;
import com.examen.entidad.RespuestasEstudiante;
import com.examen.servicio.IServicio;

@RestController
@RequestMapping("/")
public class ControladorExamen {
	
	@Autowired
	IServicio iServicio;
	
	
	
	
	@PostMapping("estudiante")
	public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {		
		return iServicio.crearEstudiante(estudiante);
	}

	@PostMapping("preguntas")
	public Preguntas crearPreguntas(@RequestBody Preguntas preguntas) {		
		return iServicio.crearPreguntas(preguntas);
	}
		
	@PostMapping("fecha")
	public FechaExamen definirFecha(@RequestBody FechaExamen fecha) {		
		return iServicio.definirFecha(fecha);
	}
	
	@PostMapping("respuestas")
	public PuntajeDto obtenerNota(@RequestBody RespuestasEstudiante respuestas ) {
		return iServicio.obtenerNota(respuestas);
	}
	
	@GetMapping("respuestas")
	public List<RespuestasEstudiante> obtenerRespuestas() {		
		return iServicio.obtenerRespuestas();
	}
	
	@GetMapping("examen")
	public ExamenDto crearExamen() {
		return iServicio.crearExamen();
	}

	@GetMapping("preguntas")
	public List<Preguntas> obtenerPreguntas() {		
		return iServicio.obtenerPreguntas();
	}
	
	@GetMapping("presentar/{id}")
	public PresentarExamen presentar(@PathVariable Long id) {		
		return iServicio.presentar(id);
	}
}
