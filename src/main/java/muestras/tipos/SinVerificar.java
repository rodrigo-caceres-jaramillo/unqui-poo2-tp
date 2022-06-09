package main.java.muestras.tipos;

import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
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

}
