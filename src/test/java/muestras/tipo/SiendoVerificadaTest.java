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

class SiendoVerificadaTest {
	SiendoVerificada tipoSiendoVerificado;
	Opinion opinionExpertaInicial;
	Opinion opinionBasica;
	Opinion opinionExperto1;
	Opinion opinionExperto2;
	ArrayList<Opinion> opiniones;
	Muestra muestra;
	
	@BeforeEach
    void setUp() {
		opinionExpertaInicial = mock(Opinion.class);
		when(opinionExpertaInicial.getTipoUsuario()).thenReturn(mock(Experto.class));
		when(opinionExpertaInicial.getTipo()).thenReturn(TipoDeOpinion.ChincheFoliada);
		when(opinionExpertaInicial.esOpinionDeAlgunExperto()).thenReturn(true);
		
		opinionBasica = mock(Opinion.class);
		when(opinionBasica.getTipoUsuario()).thenReturn(mock(Basico.class));
		when(opinionBasica.getTipo()).thenReturn(TipoDeOpinion.VinchucaGuasayana);
		when(opinionBasica.esOpinionDeAlgunExperto()).thenReturn(false);
		
		opinionExperto1 = mock(Opinion.class);
		when(opinionExperto1.getTipoUsuario()).thenReturn(mock(Experto.class));
		when(opinionExperto1.getTipo()).thenReturn(TipoDeOpinion.PhtiaChinche);
		when(opinionExperto1.esOpinionDeAlgunExperto()).thenReturn(true);
		
		opinionExperto2 = mock(Opinion.class);
		when(opinionExperto2.getTipoUsuario()).thenReturn(mock(Experto.class));
		when(opinionExperto2.getTipo()).thenReturn(TipoDeOpinion.ChincheFoliada);
		when(opinionExperto2.esOpinionDeAlgunExperto()).thenReturn(true);
		
		opiniones = new ArrayList<Opinion>();
		opiniones.add(opinionExpertaInicial);
		muestra = mock(Muestra.class);
		when(muestra.getOpiniones()).thenReturn(opiniones);
		
		tipoSiendoVerificado = new SiendoVerificada();
	}
	
	@Test
	void unaOpinionDeUnUsuarioBasicoNoSeAgregaTest() {
		ArrayList<Opinion> opinionesIniciales = muestra.getOpiniones();
		tipoSiendoVerificado.agregarOpinionA(opinionBasica, muestra);
		assertEquals(opinionesIniciales, muestra.getOpiniones());
	}
	
	@Test
	void unaOpinionDeUnUsuarioExpertoSeAgregaTest() {
		tipoSiendoVerificado.agregarOpinionA(opinionExperto1, muestra);
		assertTrue(opiniones.size() == 2);
	}
	
	@Test
	void cuandoSeAgregaUnaOpinionDeUnExpertoConElMismoTipoDeOpinionSeVerificaLaMuestraTest() {
		tipoSiendoVerificado.agregarOpinionA(opinionExperto2, muestra);
		verify(muestra).setTipo(any(Verificada.class));;
	}
	
	@Test
	void cuandoSeAgregaUnaOpinionDeUnExpertoConUnTipoDeOpinionDistintaElResultadoActualEsNoDefinidoTest() {
		tipoSiendoVerificado.agregarOpinionA(opinionExperto1, muestra);
		verify(muestra, atMost(3)).setResultadoActual(TipoDeOpinion.NoDefinida);
	}
	
	@Test
	void cuandoSeAgregaUnaOpinionLaUltimaFechaDeVotacionCambia() {
		tipoSiendoVerificado.agregarOpinionA(opinionExperto1, muestra);
		verify(muestra).setUltimaVotacion(LocalDate.now());
	}
}
