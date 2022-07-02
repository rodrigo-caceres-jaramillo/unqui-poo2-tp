package main.java.muestras.tipos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;
import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.ExpertoValidado;

public class SiendoVerificada extends TipoDeMuestra {

	@Override
	public void agregarOpinionA(Opinion opinion, Muestra muestra) {
		// Hacer subtarea esAlgunTipoDeExperto
		if(opinion.esOpinionDeAlgunExperto()){
				muestra.getOpiniones().add(opinion);//Rompe encapsulamiento pero ya existe un agreagar opinion
				muestra.setUltimaVotacion(LocalDate.now());
				ArrayList<Opinion> opinionesExpertas = (ArrayList<Opinion>) muestra.getOpiniones().stream().filter(op -> !op.getTipoUsuario().getClass().equals(Basico.class)).collect(Collectors.toList());
				if (!opinionesExpertas.isEmpty()) {
					muestra.setResultadoActual(TipoDeOpinion.NoDefinida);
				}	
		}
		if (this.ocurrenciasDeTipoEn(muestra.getOpiniones(), opinion.getTipo()) == 2) {
			muestra.setTipo(new Verificada());
		}
	}
}
