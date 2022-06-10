package main.java.muestras.tipos;

import java.util.ArrayList;

import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;

public class Verificada extends TipoDeMuestra{

	@Override
	public void agregarOpinionA(Opinion opinion, Muestra muestra) {
	}

	@Override
	public TipoDeOpinion resultadoActual(ArrayList<Opinion> opiniones) {
		return opiniones.get(opiniones.size()-1).getTipo();
	}
}
