package test.java.usuarios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.sitioWeb.SitioWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;
import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.TipoDeUsuario;
import main.java.usuarios.tipos.ExpertoValidado;

class UsuarioTest {
	Usuario user1;
	Usuario user2;
	Usuario user3;
	Usuario user4;
	SitioWeb sitioWeb;
	Ubicacion ubicacion1;
	Muestra unaMuestra;
	TipoDeUsuario tipo;
	
	@BeforeEach
    void setUp() {
		ubicacion1 = mock(Ubicacion.class);
		tipo = mock(TipoDeUsuario.class);
		sitioWeb = mock(SitioWeb.class);

		user1 = new Usuario(123, "jose Marquez", sitioWeb);
		user1.setTipo(tipo);

		user2 = new Usuario(124, "manuel Garquez", sitioWeb);
		user2.setTipo(tipo);

		user3 = new Usuario(125, "martin Benitez", sitioWeb);
		user3.setTipo(tipo);

	}

	//Getters

	@Test
	void getNombreTest() {
		assertEquals(user1.getNombre(), "jose Marquez");
	}

	@Test
	void getIdTest() {
		Integer id = 123;
		assertEquals(user1.getId(), id);
	}

	@Test
	void getSitioTest() {
		assertEquals(user1.getSitio(), sitioWeb);
	}

	@Test
	void getTipoTest() {
		assertEquals(user1.getTipo(), tipo);
	}

	@Test
	void getRegistroOpinionesTest() {
		assertEquals(user1.getRegistroOpiniones().size(), 0);
	}

	@Test
	void getRegistroPublicacionesTest() {
		assertEquals(user1.getRegistroPublicaciones().size(), 0);
	}

	//Setters

	@Test
	void setNombreTest() {
		user1.setNombre("Pablo");
		assertEquals(user1.getNombre(), "Pablo");
	}

	@Test
	void setIdTest() {
		Integer id = 852;
		user1.setId(id);
		assertEquals(user1.getId(), id);
	}

	@Test
	void setSitioTest() {
		SitioWeb DailyBugle = mock(SitioWeb.class);
		user1.setSitio(DailyBugle);
		assertEquals(user1.getSitio(), DailyBugle);
	}

	@Test
	void setTipoTest() {
		TipoDeUsuario usuarioBeta = mock(TipoDeUsuario.class);
		user1.setTipo(usuarioBeta);
		assertEquals(user1.getTipo(), usuarioBeta);
	}

	@Test
	void setRegistroOpinionesTest() {
		ArrayList<LocalDateTime> registro = new ArrayList<LocalDateTime>();
		registro.add(LocalDateTime.now());

		user1.setRegistroOpiniones(registro);
		assertEquals(user1.getRegistroOpiniones().size(), 1);
	}

	@Test
	void setRegistroPublicacionesTest() {
		ArrayList<LocalDateTime> registro = new ArrayList<LocalDateTime>();
		registro.add(LocalDateTime.now());

		user1.setRegistroPublicaciones(registro);
		assertEquals(user1.getRegistroPublicaciones().size(), 1);
	}

//Metodos

	@Test
	void usuarioPublicaUnaVezTest() {
		
		sitioWeb = mock(SitioWeb.class);
		ubicacion1 = mock(Ubicacion.class);

		user2.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);  // manda el mensaje

		verify(tipo).registrarMuestra(TipoDeOpinion.ChincheFoliada,"estoEsUnaFoto",ubicacion1,user2);  // se fija si le llega al tipo

		assertEquals( user2.getRegistroPublicaciones().size(), 1); // se suma una publi
	}
	
	@Test
	void usuarioOpinaUnaVezTest() {
		user1.opinarDeMuestraN(001, TipoDeOpinion.ChincheFoliada);        // manda el mensaje                                                              // se fija si le llega al sitio
		int cantOp = user1.getRegistroOpiniones().size();                 // se suma una opi
		assertEquals(cantOp, 1);
	}
	
	@Test
	void registrarOpinionesTest() {

		user1.registrarOpiniones(LocalDateTime.now()) ;
		assertEquals(user1.getRegistroOpiniones().size(), 1);
	}

	@Test
	void registrarPublicacionTest() {
		user1.registrarPublicacion(LocalDateTime.now()); 
		assertEquals(user1.getRegistroPublicaciones().size(), 1);
	}
/*
	private void registrar11Muestras() {
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
	}

	private void crear21Opiniones() {
		user2.opinarDeMuestraN(001, TipoDeOpinion.ChincheFoliada);
		user2.opinarDeMuestraN(050, TipoDeOpinion.ChincheFoliada);
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
	}
*/
	@Test
	void unUsuarioNoOpinaUnaMuestraQueNoExiste() {
		user2.opinarDeMuestraN(050, TipoDeOpinion.ChincheFoliada);
		int cantOp = user1.getRegistroOpiniones().size();                 // se suma una opi
		assertEquals(cantOp, 0);
	}
	@Test
	void opinarDeMuestraNTest() {

		user1.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);
		user2.opinarDeMuestraN(001, TipoDeOpinion.ChincheFoliada);
		int cantOp = user2.getRegistroOpiniones().size(); 
		assertEquals(cantOp, 1);
		
	}
	@Test 
	void usuarioNoPuesdeOpinarDosVecesLaMismaMuestra() {
		
		user2.opinarDeMuestraN(001, TipoDeOpinion.ChincheFoliada);

		when(sitioWeb.esSuMuestra(001, user2.getId())).thenReturn(false);
		when(sitioWeb.muestraNTieneOpinionDeUsuarioN(001, user2.getId())).thenReturn(false);
		
		assertEquals(user2.getRegistroOpiniones().size(), 1);
		
		when(sitioWeb.muestraNTieneOpinionDeUsuarioN(001, user2.getId())).thenReturn(true);
		
		user2.opinarDeMuestraN(001, TipoDeOpinion.ImagenPocoClara);
		
		assertEquals(user2.getRegistroOpiniones().size(), 1);
	}

	@Test
	void crearOpinionTest() {
		Opinion opinionAVer =  mock(Opinion.class);

		when(opinionAVer.getIdUsuario()).thenReturn(user1.getId());

		assertEquals(user1.crearOpinion(TipoDeOpinion.ChincheFoliada).getIdUsuario(), opinionAVer.getIdUsuario());
	}

	@Test
    void validarExternamenteTest() {
        user1.validarseExternamenta();
        assertTrue(user1.getTipo() instanceof ExpertoValidado);
    }
	
	
	
	
	
}