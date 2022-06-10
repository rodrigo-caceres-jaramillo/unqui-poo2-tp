package test.java.muestras.tipo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.SiendoVerificada;
import main.java.muestras.tipos.Verificada;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;
import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.ExpertoValidado;

class SiendoVerificadaTest {
	SiendoVerificada tipoSiendoVerificado;
	Muestra muestra;
	Opinion opinionBasica;
	Opinion opinionExperto;
	Opinion opinionExperto2;
	Opinion opinionExpertoValidado;
	Opinion opinionExpertoValidado2;
	
	@BeforeEach
    void setUp() {
		tipoSiendoVerificado = new SiendoVerificada();
		Ubicacion ubicacion = mock(Ubicacion.class);
		Usuario usuarioExperto= mock(Usuario.class);
		usuarioExperto.setTipo(new Experto());
		muestra = new Muestra(1, TipoDeOpinion.ChincheFoliada, usuarioExperto, "unaFoto", ubicacion, tipoSiendoVerificado);
		opinionBasica = new Opinion(1, TipoDeOpinion.ChincheFoliada, new Basico());
		opinionExperto = new Opinion(2, TipoDeOpinion.ChincheFoliada, new Experto());
		opinionExperto2 = new Opinion(3, TipoDeOpinion.VinchucaGuasayana, new Experto());
		opinionExpertoValidado = new Opinion(4, TipoDeOpinion.ChincheFoliada, new ExpertoValidado());
		opinionExpertoValidado2 = new Opinion(5, TipoDeOpinion.VinchucaGuasayana, new ExpertoValidado());
	}
	
	@Test
	void unaOpinionDeUnUsuarioBasicoNoSeAgregaTest() {
		ArrayList<Opinion> opinionesIniciales = muestra.getOpiniones();
		muestra.agregarOpinion(opinionBasica);
		assertEquals(opinionesIniciales, muestra.getOpiniones());
	}
	
	@Test
	void unaOpinionDeUnUsuarioExpertoNoSeAgregaTest() {
		muestra.agregarOpinion(opinionExpertoValidado2);
		assertTrue(muestra.getOpiniones().contains(opinionExpertoValidado2));
	}
	
	@Test
	void cuandoSeAgregaUnaOpinionDeUnExpertoConElMismoTipoDeOpinionSeVerificaLaMuestraTest() {
		muestra.agregarOpinion(opinionExperto);
		assertTrue(muestra.getTipo() instanceof Verificada);
	}
	
	@Test
	void cuandoSeAgregaUnaOpinionDeUnExpertoValidadoConElMismoTipoDeOpinionSeVerificaLaMuestraTest() {
		muestra.agregarOpinion(opinionExpertoValidado);
		assertTrue(muestra.getTipo() instanceof Verificada);
	}
	
	@Test
	void cuandoSeAgregaUnaOpinionDeUnExpertoConUnTipoDeOpinionDistintaNoSeVerificaLaMuestraTest() {
		muestra.agregarOpinion(opinionExperto2);
		assertFalse(muestra.getTipo() instanceof Verificada);
	}
	
	@Test
	void cuandoSeAgregaUnaOpinionDeUnExpertoValidadoConUnTipoDeOpinionDistintaNoSeVerificaLaMuestraTest() {
		muestra.agregarOpinion(opinionExpertoValidado2);
		assertFalse(muestra.getTipo() instanceof Verificada);
	}
	
	@Test
	void resultadoActualTest() {
		muestra.agregarOpinion(opinionExperto);
		assertEquals(muestra.resultadoActual(), opinionExperto.getTipo());
	}
	
	@Test
	void cuandoUnUsuarioExpertoOpinaElResultadoActualCambia() {
		muestra.agregarOpinion(opinionExpertoValidado);
		muestra.agregarOpinion(opinionExperto);
		muestra.agregarOpinion(opinionExperto2);
		assertEquals(muestra.resultadoActual(), opinionExperto2.getTipo());
	}
}
