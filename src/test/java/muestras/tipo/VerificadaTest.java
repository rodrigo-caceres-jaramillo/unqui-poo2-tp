package test.java.muestras.tipo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.Verificada;
import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.ExpertoValidado;

class VerificadaTest {
	Verificada tipoVerificada;
	Opinion opinionInicial;
	Muestra muestra;
	Opinion opinionBasica;
	Opinion opinionExperto;
	ArrayList<Opinion> opiniones;
	
	@BeforeEach
    void setUp() {
		tipoVerificada = new Verificada();
		opinionInicial = new Opinion(0, TipoDeOpinion.VinchucaInfestans, new Basico());
		muestra = mock(Muestra.class);
		opiniones = new ArrayList<Opinion>();
		opiniones.add(opinionInicial);
		when(muestra.getOpiniones()).thenReturn(opiniones);
		when(muestra.getTipo()).thenReturn(tipoVerificada);
		when(muestra.getResultadoActual()).thenReturn(TipoDeOpinion.VinchucaInfestans);
		opinionBasica = new Opinion(1, TipoDeOpinion.ChincheFoliada, new Basico());
		opinionExperto = new Opinion(2, TipoDeOpinion.ChincheFoliada, new Experto());
	}
	
	@Test
	void unaOpinionDeUnUsuarioBasicoNoSeAgregaTest() {
		ArrayList<Opinion> opinionesIniciales = muestra.getOpiniones();
		tipoVerificada.agregarOpinionA(opinionBasica, muestra);
		assertEquals(opinionesIniciales, muestra.getOpiniones());
	}
	
	@Test
	void unaOpinionDeUnUsuarioExpertoNoSeAgregaTest() {
		ArrayList<Opinion> opinionesIniciales = muestra.getOpiniones();
		tipoVerificada.agregarOpinionA(opinionExperto, muestra);
		assertEquals(opinionesIniciales, muestra.getOpiniones());
	}
}
