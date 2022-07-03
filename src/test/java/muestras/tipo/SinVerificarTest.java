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
import main.java.usuarios.Usuario;
import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.ExpertoValidado;

class SinVerificarTest {
	SinVerificar tipoSinVerificar;
	Opinion opinionBasicaInicial;
	Opinion opinionBasica;
	Opinion opinionExperto;
	ArrayList<Opinion> opiniones;
	Muestra muestra;
	
	@BeforeEach
    void setUp() {
		opinionBasicaInicial = mock(Opinion.class);
		when(opinionBasicaInicial.getTipoUsuario()).thenReturn(mock(Basico.class));
		when(opinionBasicaInicial.getTipo()).thenReturn(TipoDeOpinion.ChincheFoliada);
		when(opinionBasicaInicial.esOpinionDeAlgunExperto()).thenReturn(false);
		opinionBasica = mock(Opinion.class);
		when(opinionBasica.getTipoUsuario()).thenReturn(mock(Basico.class));
		when(opinionBasica.getTipo()).thenReturn(TipoDeOpinion.VinchucaGuasayana);
		when(opinionBasica.esOpinionDeAlgunExperto()).thenReturn(false);
		opinionExperto = mock(Opinion.class);
		when(opinionExperto.getTipoUsuario()).thenReturn(mock(Experto.class));
		when(opinionExperto.getTipo()).thenReturn(TipoDeOpinion.PhtiaChinche);
		when(opinionExperto.esOpinionDeAlgunExperto()).thenReturn(true);
		opiniones = new ArrayList<Opinion>();
		opiniones.add(opinionBasicaInicial);
		muestra = mock(Muestra.class);
		when(muestra.getOpiniones()).thenReturn(opiniones);
		
		tipoSinVerificar = new SinVerificar();
	}
	
	@Test
	void unaOpinionDeUnUsuarioBasicoSeAgregaTest() {
		tipoSinVerificar.agregarOpinionA(opinionBasica, muestra);
		assertTrue(opiniones.size() == 2);
	}
	
	@Test
	void cuandoSeAgregaUnaOpinionDeUnExpertoElTipoDeLaMuestraCambiaASiendoVerificada() {
		tipoSinVerificar.agregarOpinionA(opinionExperto, muestra);
		verify(muestra).setTipo(any(SiendoVerificada.class));;
	}
	
	@Test
	void cuandoSeAgregaUnaOpinionCambiaElResultadoActualTest() {
		tipoSinVerificar.agregarOpinionA(opinionBasica, muestra);
		verify(muestra).setResultadoActual(TipoDeOpinion.VinchucaGuasayana);
	}

	@Test
	void cuandoSeAgregaUnaOpinionLaUltimaFechaDeVotacionCambia() {
		tipoSinVerificar.agregarOpinionA(opinionBasica, muestra);
		verify(muestra).setUltimaVotacion(LocalDate.now());
	}
}
