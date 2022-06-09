package test.java.muestras;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.sitioWeb.SitioWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;
import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.TipoDeUsuario;


class UsuarioTest {
	Usuario user1;
	Usuario user2;
	Usuario user3;
	SitioWeb sitioWeb;
	Ubicacion ubicacion1;
	Muestra unaMuestra;
	TipoDeUsuario usuarioBasico;
	
	@BeforeEach
    void setUp() {
		ubicacion1 = mock(Ubicacion.class);
		sitioWeb = mock(SitioWeb.class);
		user1 = new Usuario(123, "jose Marquez", sitioWeb);
		user2 = new Usuario(124, "manuel Garquez", sitioWeb);
		user3 = new Usuario(125, "martin Benitez", sitioWeb);
		user3.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);
		user3.registrarMuestra(TipoDeOpinion.ImagenPocoClara, "estoEsUnaFoto", ubicacion1);
		user3.registrarMuestra(TipoDeOpinion.VinchucaGuasayana, "estoEsUnaFoto", ubicacion1);
		user3.registrarMuestra(TipoDeOpinion.VinchucaInfestans, "estoEsUnaFoto", ubicacion1);
		user3.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);
		user3.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);
		user3.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);
		user3.registrarMuestra(TipoDeOpinion.VinchucaSordida, "estoEsUnaFoto", ubicacion1);
		user3.registrarMuestra(TipoDeOpinion.ImagenPocoClara, "estoEsUnaFoto", ubicacion1);
		user3.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);
		user3.registrarMuestra(TipoDeOpinion.ImagenPocoClara, "estoEsUnaFoto", ubicacion1);
		
		//unaMuestra = mock(Muestra.class);
	}
	
	@Test
	void usuarioBienCreadoTest() {
		String nombre= user1.getNombre();
		Integer id = user1.getId();
		//TipoDeUsuario tipo = user1.getTipo();
		assertEquals(nombre, "jose Marquez");
		assertEquals(id, 123);
		//assertEquals(tipo);

	}
	
	@Test
	void usuarioPublicaUnaVezTest() {
		// EL TEST ANDA PERO SIN SER MOCKEADO, REVISAR
		sitioWeb = mock(SitioWeb.class);
		ubicacion1 = mock(Ubicacion.class);
		user2 = new Usuario(124, "maria Rodriguez", sitioWeb);
		user2.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);
		Integer cantPublis = user2.getRegistroPublicaciones().size();
		assertEquals(cantPublis, 1);
	}
	
	@Test
	void usuarioOpinaUnaVezTest() {
		// EL TEST ANDA PERO SIN SER MOCKEADO, REVISAR
		sitioWeb = mock(SitioWeb.class);
		user2 = new Usuario(124, "maria Rodriguez", sitioWeb);
		user2.opinarDeMuestraN(001, TipoDeOpinion.ChincheFoliada);
		Integer cantOp = user2.getRegistroOpiniones().size();
		assertEquals(cantOp, 1);
	}
	
	/*
	@Test
	void elUsuarioCambiaDeTipoTest() {
		// REVISAR!!
		// EL TEST ANDA PERO SIN SER MOCKEADO, REVISAR
		sitioWeb = mock(SitioWeb.class);
		user2.opinarDeMuestraN(001, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(002, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(003, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(004, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(005, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(006, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(007, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(123, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(132, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(010, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(011, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(012, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(013, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(014, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(015, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(016, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(017, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(412, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(234, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(020, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(021, TipoDeOpinion.ChincheFoliada);
		user2.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);
		user2.registrarMuestra(TipoDeOpinion.ImagenPocoClara, "estoEsUnaFoto", ubicacion1);
		user2.registrarMuestra(TipoDeOpinion.VinchucaGuasayana, "estoEsUnaFoto", ubicacion1);
		user2.registrarMuestra(TipoDeOpinion.VinchucaInfestans, "estoEsUnaFoto", ubicacion1);
		user2.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);
		user2.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);
		user2.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);
		user2.registrarMuestra(TipoDeOpinion.VinchucaSordida, "estoEsUnaFoto", ubicacion1);
		user2.registrarMuestra(TipoDeOpinion.ImagenPocoClara, "estoEsUnaFoto", ubicacion1);
		user2.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);
		user2.registrarMuestra(TipoDeOpinion.ImagenPocoClara, "estoEsUnaFoto", ubicacion1);
		assertTrue(user2.getTipo() instanceof Experto);
	}
	
	@Test
	void pruebaTest() {
		
	}
	*/
}