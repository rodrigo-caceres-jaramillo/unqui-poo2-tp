package main.java.muestras.tipos;

import java.util.ArrayList;

import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.ExpertoValidado;

public class SinVerificar extends TipoDeMuestra{

	@Override
	public void agregarOpinionA(Opinion opinion, Muestra muestra) {
		muestra.getOpiniones().add(opinion);
		if(opinion.getTipoUsuario() instanceof Experto ||
		   opinion.getTipoUsuario() instanceof ExpertoValidado) {
			muestra.setTipo(new SiendoVerificada());
		}
	}

	@Override
	public TipoDeOpinion resultadoActual(ArrayList<Opinion> opiniones) {
		//Map<Opinion, Long> frecuentes = opiniones.stream()
	     //       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		/*
		TipoDeOpinion maxEntry = null;
       for (TipoDeOpinion entry : frecuentes.entrySet()) {
           if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
               maxEntry = entry;
           }
       }*/
		
		return null;
	}

}
