package main.java.muestras.tipos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;

public abstract class TipoDeMuestra {
	public abstract void agregarOpinionA(Opinion opinion, Muestra muestra);

	public int ocurrenciasDeTipoEn(ArrayList<Opinion> opiniones, TipoDeOpinion tipo) {
		/*
		int c = 0;
		for (Opinion op : opiniones) {
			if (op.getTipo() == tipo) {
				c += 1;
			}
		}
		return c;
		*/
		return  opiniones.stream().filter(op -> op.getTipo().equals(tipo)).collect(Collectors.toList()).size();
	}

	public boolean esVerificado(){
		return false;
	}
}
