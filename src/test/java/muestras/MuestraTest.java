package test.java.muestras;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.SiendoVerificada;
import main.java.muestras.tipos.SinVerificar;
import main.java.muestras.tipos.TipoDeMuestra;
import main.java.sitioWeb.SitioWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

class MuestraTest {
	SitioWeb sitioWeb;
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Usuario usuario1;
	Ubicacion unaUbicacion;
	TipoDeMuestra unTipoDeMuestra;
	
	@BeforeEach
    void setUp() {
		sitioWeb = mock(SitioWeb.class);
		usuario1 = mock(Usuario.class);
		unaUbicacion = mock(Ubicacion.class);
		unTipoDeMuestra = mock(TipoDeMuestra.class);
		muestra1 = new Muestra(1, TipoDeOpinion.ChincheFoliada, usuario1, "unaFoto", unaUbicacion, unTipoDeMuestra);
	}
	
//Gets/Sets -------------------------------------
	@Test
	void getIdTest() {
		assertEquals((int)muestra1.getId(), 1);
	}
	
	@Test
	void setIdTest() {
		Integer id = 10;
		muestra1.setId(id);
		assertEquals(muestra1.getId(), id);
	}
	
	@Test
	void getTipoVinchutaTest() {
		assertEquals(muestra1.getTipoVinchuca(), TipoDeOpinion.ChincheFoliada);
	}
	
	@Test
	void setTipoVinchutaTest() {
		TipoDeOpinion tipoVinchuca = TipoDeOpinion.VinchucaGuasayana;
		muestra1.setTipoVinchuca(tipoVinchuca);
		assertEquals(muestra1.getTipoVinchuca(), tipoVinchuca);
	}
	
	@Test
	void getUsuarioTest() {
		assertEquals(muestra1.getUsuario(), usuario1);
	}
	
	@Test
	void setUsuarioTest() {
		Usuario usuario = mock(Usuario.class);
		muestra1.setUsuario(usuario);
		assertEquals(muestra1.getUsuario(), usuario);
	}
	
	@Test
	void getCreacionTest() {
		assertEquals(muestra1.getCreacion(), LocalDate.now());
	}

	@Test
	void setCreacionTest() {
		LocalDate date = LocalDate.of(2000, Month.DECEMBER, 16);
		muestra1.setCreacion(date);
		assertEquals(muestra1.getCreacion(), date);
	}
	@Test
	void getUltimaVotacionTest() {
		assertEquals(muestra1.getUltimaVotacion(), null);
	}
	
	@Test
	void setUltimaVotacionTest() {
		LocalDate date = LocalDate.of(2050, Month.OCTOBER, 16);
		muestra1.setUltimaVotacion(date);
		assertEquals(muestra1.getUltimaVotacion(), date);
	}
	
	@Test
	void getFotoTest() {
		assertEquals(muestra1.getFoto(), "unaFoto");
	}
	
	@Test
	void setFotoTest() {
		muestra1.setFoto("otraFoto");
		assertEquals(muestra1.getFoto(), "otraFoto");
	}
	
	@Test
	void getOpinionesTest() {
		assertFalse(muestra1.getOpiniones().isEmpty());
	}
	
	@Test
	void setOpinionesTest() {
		ArrayList<Opinion> opiniones = new ArrayList<Opinion>();
		muestra1.setOpiniones(opiniones);
		assertEquals(muestra1.getOpiniones(), opiniones);
	}
	
	@Test
	void getUbicacionTest() {
		assertEquals(muestra1.getUbicacion(), unaUbicacion);
	}
	
	@Test
	void setUbicacionTest() {
		Ubicacion otraUbicacion = mock(Ubicacion.class);
		muestra1.setUbicacion(otraUbicacion);
		assertEquals(muestra1.getUbicacion(), otraUbicacion);
	}
	
	@Test
	void getTipoTest() {
		assertEquals(muestra1.getTipo(), unTipoDeMuestra);
	}
		
	@Test
	void setTipoTest() {
		TipoDeMuestra otroTipo = new SiendoVerificada();
		muestra1.setTipo(otroTipo);
		assertEquals(muestra1.getTipo(), otroTipo);
	}
	
// Metodos --------------------------------------
	@Test
	void agregarOpinionTest() {
		Opinion opinion = mock(Opinion.class);
		muestra1.agregarOpinion(opinion);
		verify(muestra1.getTipo()).agregarOpinionA(opinion, muestra1);
	}
	
	@Test
	void resultadoActual() {
		muestra1.resultadoActual();
		ArrayList<Opinion> opiniones = muestra1.getOpiniones();
		verify(muestra1.getTipo()).resultadoActual(opiniones);
	}
}
