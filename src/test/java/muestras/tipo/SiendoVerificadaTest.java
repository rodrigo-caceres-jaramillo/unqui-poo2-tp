package test.java.muestras.tipo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.SiendoVerificada;
import main.java.muestras.tipos.Verificada;
import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.ExpertoValidado;

class SiendoVerificadaTest {
	SiendoVerificada tipoSiendoVerificado;
	Opinion opinionInicial;
	Muestra muestra;
	Opinion opinionBasica;
	Opinion opinionExperto;
	Opinion opinionExperto2;
	Opinion opinionExpertoValidado;
	Opinion opinionExpertoValidado2;
	ArrayList<Opinion> opiniones;
	
	@BeforeEach
    void setUp() {
		tipoSiendoVerificado = new SiendoVerificada();
		opinionInicial = new Opinion(0, TipoDeOpinion.VinchucaInfestans, new Experto());
		muestra = mock(Muestra.class);
		opiniones = new ArrayList<Opinion>();
		opiniones.add(opinionInicial);
		when(muestra.getOpiniones()).thenReturn(opiniones);
		when(muestra.getTipo()).thenReturn(tipoSiendoVerificado);
		opinionBasica = new Opinion(1, TipoDeOpinion.ChincheFoliada, new Basico());
		opinionExperto = new Opinion(2, TipoDeOpinion.ChincheFoliada, new Experto());
		opinionExperto2 = new Opinion(3, TipoDeOpinion.VinchucaGuasayana, new Experto());
		opinionExpertoValidado = new Opinion(4, TipoDeOpinion.ChincheFoliada, new ExpertoValidado());
		opinionExpertoValidado2 = new Opinion(5, TipoDeOpinion.VinchucaGuasayana, new ExpertoValidado());
		opiniones = new ArrayList<Opinion>();
		when(muestra.getOpiniones()).thenReturn(opiniones);
		when(muestra.getTipo()).thenReturn(tipoSiendoVerificado);
	}
	
	@Test
	void unaOpinionDeUnUsuarioBasicoNoSeAgregaTest() {
		ArrayList<Opinion> opinionesIniciales = muestra.getOpiniones();
		tipoSiendoVerificado.agregarOpinionA(opinionBasica, muestra);
		assertEquals(opinionesIniciales, muestra.getOpiniones());
	}
	
	@Test
	void unaOpinionDeUnUsuarioExpertoSeAgregaTest() {
		tipoSiendoVerificado.agregarOpinionA(opinionExpertoValidado2, muestra);
		assertTrue(opiniones.size() == 1);
	}
	
	@Test
	void cuandoSeAgregaUnaOpinionDeUnExpertoConElMismoTipoDeOpinionSeVerificaLaMuestraTest() {
		tipoSiendoVerificado.agregarOpinionA(opinionExperto, muestra);
		tipoSiendoVerificado.agregarOpinionA(opinionExpertoValidado, muestra);
		verify(muestra).setTipo(any(Verificada.class));;
	}
	
	@Test
	void cuandoSeAgregaUnaOpinionDeUnExpertoConUnTipoDeOpinionDistintaNoSeVerificaLaMuestraTest() {
		tipoSiendoVerificado.agregarOpinionA(opinionExpertoValidado, muestra);
		verify(muestra, never()).setTipo(any(Verificada.class));;
	}
	
	@Test
	void cuandoSeAgregaUnaOpinionDeUnExpertoConUnTipoDeOpinionDistintaElResultadoActualEsNoDefinidoTest() {
		tipoSiendoVerificado.agregarOpinionA(opinionExpertoValidado, muestra);
		verify(muestra, atMost(3)).setResultadoActual(TipoDeOpinion.NoDefinida);
	}
}
