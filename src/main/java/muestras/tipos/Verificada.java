package main.java.muestras.tipos;

import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.usuarios.tipos.Basico;

public class Verificada extends TipoDeMuestra{

	@Override
	public void agregarOpinionA(Opinion opinion, Muestra muestra) {
	}

	@Override
	public TipoDeOpinion resultadoActual(ArrayList<Opinion> opiniones) {
		ArrayList<Opinion> opinionesExpertas = (ArrayList<Opinion>) opiniones.stream().filter(op -> !op.getTipoUsuario().getClass().equals(Basico.class)).collect(Collectors.toList());
		return opinionesExpertas.get(opinionesExpertas.size()-1).getTipo();
	}
}
