package com.examen.servicio;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.entidad.Estudiante;
import com.examen.entidad.Examen;
import com.examen.entidad.ExamenDto;
import com.examen.entidad.FechaExamen;
import com.examen.entidad.Preguntas;
import com.examen.entidad.PresentarExamen;
import com.examen.entidad.PuntajeDto;
import com.examen.entidad.RespuestasCorrectas;
import com.examen.entidad.RespuestasEstudiante;
import com.examen.repositorio.EstudiantesRepositorio;
import com.examen.repositorio.ExamenRepositorio;
import com.examen.repositorio.FechaRepositorio;
import com.examen.repositorio.PreguntasRepositorio;
import com.examen.repositorio.RespuestaEstudianteRepositorio;
import com.examen.repositorio.RespuestasRepositorio;

@Service
public class ServicioExamen implements IServicio {

	@Autowired
	ExamenRepositorio examenRepositorio;

	@Autowired
	PreguntasRepositorio preguntasRepositorio;

	@Autowired
	RespuestasRepositorio respuestasRepositorio;

	@Autowired
	RespuestaEstudianteRepositorio respuestaEstudianteRepositorio;

	@Autowired
	EstudiantesRepositorio estudiantesRepositorio;

	@Autowired
	FechaRepositorio fechaRepositorio;

	@Override
	public ExamenDto crearExamen() {
		List<Preguntas> preguntas = obtenerPreguntas();
		ExamenDto examenDto = new ExamenDto();
		Examen examen = new Examen();
		
		examen.setPreguntas(preguntas);
		examenDto.setPreguntas(preguntas);
		
		examenRepositorio.saveAndFlush(examen);
		List<Examen> listExamen=examenRepositorio.findAll();
		int tamaño=listExamen.size();
		examen=listExamen.get(tamaño-1);
		RespuestasCorrectas respuestas = new RespuestasCorrectas();
		int[] res = new int[5];
		int i = 0;
		for (Preguntas preguntas2 : preguntas) {
			res[i] = preguntas2.getPosicion();
			i++;
		}
		respuestas.setRespuestas(res);
		respuestas.setIdExamen(examen.getId());
		examenDto.setId(examen.getId());
		
		respuestasRepositorio.saveAndFlush(respuestas);
		return examenDto;
	}

	@Override
	public Preguntas crearPreguntas(Preguntas preguntas) {
		return preguntasRepositorio.saveAndFlush(preguntas);
	}

	@Override
	public Estudiante crearEstudiante(Estudiante estudiante) {
		return estudiantesRepositorio.saveAndFlush(estudiante);
	}

	@Override
	public List<Preguntas> obtenerPreguntas() {
		String op1;
		String op2;
		String op3;
		String op4;
		List<Preguntas> preguntas = preguntasRepositorio.findAll();
		List<Preguntas> preguntas3 = new ArrayList<Preguntas>();
		for (Preguntas preguntas2 : preguntas) {
			op1 = preguntas2.getOpcion1();
			op2 = preguntas2.getOpcion2();
			op3 = preguntas2.getOpcion3();
			op4 = preguntas2.getOpcion4();
			String[] preguntasAleatorias = aleatorio(op1, op2, op3, op4);
			preguntas2.setOpcion1(preguntasAleatorias[0]);
			preguntas2.setOpcion2(preguntasAleatorias[1]);
			preguntas2.setOpcion3(preguntasAleatorias[2]);
			preguntas2.setOpcion4(preguntasAleatorias[3]);
			preguntas2.setPosicion(Integer.parseInt(preguntasAleatorias[4]));
			preguntas3.add(preguntas2);
		}
		return preguntas3;
	}

	public String[] aleatorio(String op1, String op2, String op3, String op4) {
		int numero = (int) (Math.random() * 4);
		String[] pos = new String[5];

		switch (numero) {
		case 0:
			pos[1] = op1;
			pos[2] = op2;
			pos[3] =op3;
			pos[numero] =op4;
			pos[4] = "0";
			break;
		case 1:
			pos[0] = op1;
			pos[2] = op2;
			pos[3] = op3;
			pos[numero] = op4;
			pos[4] = "1";
			break;
		case 2:
			pos[0] = op1;
			pos[1] = op2;
			pos[3] = op3;
			pos[numero] = op4;
			pos[4] = "2";
			break;
		case 3:
			pos[0] =  op1;
			pos[1] = op2;
			pos[2] =  op3;
			pos[numero] = op4;
			pos[4] = "3";
			break;
		}

		return pos;
	}

	@Override
	public FechaExamen definirFecha(FechaExamen fecha) {
		return fechaRepositorio.saveAndFlush(fecha);
	}

	@Override
	public PresentarExamen presentar(Long id) {
		Estudiante estudiante=estudiantesRepositorio.getById(id);
		FechaExamen fecha = fechaRepositorio.getById(1L);
		PresentarExamen presentarExamen = new PresentarExamen();
		String Zona = estudiante.getZonaHoraria();
		LocalDateTime date = fecha.getFecha();
		switch (Zona) {
		case "Tijuana":
			ZoneId zoneTijuana = ZoneId.of("America/Tijuana");
			ZonedDateTime localTijuana = date.atZone(zoneTijuana);
			presentarExamen.setFecha(localTijuana.toLocalDateTime());
			break;
		case "Guatemala":
			ZoneId zoneGuatemala = ZoneId.of("America/Guatemala");
			ZonedDateTime localGuatemala = date.atZone(zoneGuatemala);
			presentarExamen.setFecha(localGuatemala.toLocalDateTime());
			break;
		case "Bogota":
			ZoneId zoneBogota = ZoneId.of("America/Bogota");
			ZonedDateTime localBogota = date.atZone(zoneBogota);
			presentarExamen.setFecha(localBogota.toLocalDateTime());
			break;
		case "Santiago":
			ZoneId zoneSantiago = ZoneId.of("America/Santiago");
			ZonedDateTime localSantiago = date.atZone(zoneSantiago);
			presentarExamen.setFecha(localSantiago.toLocalDateTime());
			break;
		case "Buenos_Aires":
			ZoneId zoneBuenosAires = ZoneId.of("America/Buenos_Aires");
			ZonedDateTime localArgentina = date.atZone(zoneBuenosAires);
			presentarExamen.setFecha(localArgentina.toLocalDateTime());
			break;
		case "Londres":
			ZoneId zoneLondon = ZoneId.of("Europe/London");
			ZonedDateTime localLondon = date.atZone(zoneLondon);
			presentarExamen.setFecha(localLondon.toLocalDateTime());
			break;
		}
		presentarExamen.setIdEstudiante(estudiante.getId());
		return presentarExamen;
	}

	@Override
	public PuntajeDto obtenerNota(RespuestasEstudiante respuestas) {
		RespuestasCorrectas resp = respuestasRepositorio.findByIdExamen(respuestas.getIdExamen());
		PuntajeDto puntaje = new PuntajeDto();
		int nota = 0;
		int[] listRespuestas = resp.getRespuestas();
		int[] respuestasEnviada = respuestas.getRespuestas();
		for (int i = 0; i < 5; i++) {
			if (listRespuestas[i] == respuestasEnviada[i]) {
				nota += 20;
				puntaje.setPuntaje(nota);
			}

		}
		respuestaEstudianteRepositorio.saveAndFlush(respuestas);
		return puntaje;
	}

	@Override
	public List<RespuestasEstudiante> obtenerRespuestas() {
		return respuestaEstudianteRepositorio.findAll();
	}

}
