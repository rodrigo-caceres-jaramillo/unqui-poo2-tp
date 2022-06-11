package test.java.muestras.tipo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.SiendoVerificada;
import main.java.muestras.tipos.SinVerificar;
import main.java.muestras.tipos.Verificada;
import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.ExpertoValidado;

class SinVerificarTest {
	SinVerificar tipoSinVerificar;
	Opinion opinionInicial;
	Muestra muestra;
	Opinion opinionBasica1;
	Opinion opinionBasica2;
	Opinion opinionBasica3;
	Opinion opinionBasica4;
	Opinion opinionExperto;
	Opinion opinionExpertoValidado;
	ArrayList<Opinion> opiniones;
	
	@BeforeEach
    void setUp() {
		tipoSinVerificar = new SinVerificar();
		opinionInicial = new Opinion(0, TipoDeOpinion.VinchucaInfestans, new Basico());
		muestra = mock(Muestra.class);
		opiniones = new ArrayList<Opinion>();
		opiniones.add(opinionInicial);
		when(muestra.getOpiniones()).thenReturn(opiniones);
		when(muestra.getTipo()).thenReturn(tipoSinVerificar);
		when(muestra.getResultadoActual()).thenReturn(TipoDeOpinion.VinchucaInfestans);
		opinionBasica1 = new Opinion(1, TipoDeOpinion.ChincheFoliada, new Basico());
		opinionBasica2 = new Opinion(2, TipoDeOpinion.ChincheFoliada, new Basico());
		opinionBasica3 = new Opinion(3, TipoDeOpinion.ChincheFoliada, new Basico());
		opinionBasica4 = new Opinion(4, TipoDeOpinion.VinchucaGuasayana, new Basico());
		opinionExperto = new Opinion(5, TipoDeOpinion.ChincheFoliada, new Experto());
		opinionExpertoValidado = new Opinion(5, TipoDeOpinion.VinchucaGuasayana, new ExpertoValidado());
	}
	
	@Test
	void unaOpinionDeUnUsuarioBasicoSeAgregaTest() {
		tipoSinVerificar.agregarOpinionA(opinionBasica1, muestra);
		assertTrue(opiniones.size() == 2);
	}
	
	@Test
	void sePuedeAgregarMultiplesOpinionesDeUsuariosBasicoDelMismoTipo() {
		tipoSinVerificar.agregarOpinionA(opinionBasica1, muestra);
		tipoSinVerificar.agregarOpinionA(opinionBasica2, muestra);
		tipoSinVerificar.agregarOpinionA(opinionBasica3, muestra);
		assertTrue(opiniones.size() == 4);
	}
	
	@Test
	void cuandoSeAgregaUnaOpinionDeUnExpertoElTipoDeLaMuestraCambiaASiendoVerificada() {
		tipoSinVerificar.agregarOpinionA(opinionExperto, muestra);
		verify(muestra).setTipo(any(SiendoVerificada.class));;
	}
	
	@Test
	void cuandoSeAgregaUnaOpinionCambiaElResultadoActualTest() {
		tipoSinVerificar.agregarOpinionA(opinionBasica1, muestra);
		verify(muestra).setResultadoActual(TipoDeOpinion.ChincheFoliada);
	}
	
	@Test
	void cuandoSeAgregaMultiplesOpinionesDeUnTipoCambiaElResultadoActualTest() {
		tipoSinVerificar.agregarOpinionA(opinionBasica1, muestra);
		tipoSinVerificar.agregarOpinionA(opinionBasica2, muestra);
		tipoSinVerificar.agregarOpinionA(opinionBasica3, muestra);
		tipoSinVerificar.agregarOpinionA(opinionBasica4, muestra);
		verify(muestra, atMost(3)).setResultadoActual(TipoDeOpinion.ChincheFoliada);
	}

	@Test
	void cuandoSeAgregaUnaOpinionLaUltimaFechaDeVotacionCambia() {
		tipoSinVerificar.agregarOpinionA(opinionBasica1, muestra);
		verify(muestra).setUltimaVotacion(LocalDate.now());
	}
}
