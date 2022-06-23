package main.java.muestras.tipos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.ExpertoValidado;
import main.java.usuarios.tipos.TipoDeUsuario;

public class SiendoVerificada extends TipoDeMuestra {

	@Override
	public void agregarOpinionA(Opinion opinion, Muestra muestra) {
		// Hacer subtarea esAlgunTipoDeExperto
		if(opinion.getTipoUsuario() instanceof Experto ||
		   opinion.getTipoUsuario() instanceof ExpertoValidado){
				muestra.getOpiniones().add(opinion);
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
