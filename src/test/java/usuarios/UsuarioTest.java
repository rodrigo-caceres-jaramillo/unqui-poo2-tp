package test.java.usuarios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.muestras.AdministradorDeMuestras;
import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.organizaciones.OrganizacioneNoGubernamental;
import main.java.sitioWeb.SitioWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;
import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.TipoDeUsuario;
import main.java.zonasDeCoberturas.AdministradorDeZonasDeCoberturas;
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
	AdministradorDeMuestras adminMuestras;
    AdministradorDeZonasDeCoberturas adminzonasZonas;
    List<OrganizacioneNoGubernamental> organizaciones;
    SitioWeb web;
	
	@BeforeEach
    void setUp() {
		ubicacion1 = mock(Ubicacion.class);
		tipo = mock(TipoDeUsuario.class);
		sitioWeb = mock(SitioWeb.class);
		adminMuestras = mock(AdministradorDeMuestras.class);
        adminzonasZonas = mock(AdministradorDeZonasDeCoberturas.class);
        
        organizaciones = new ArrayList<OrganizacioneNoGubernamental>();
        web = new SitioWeb(adminMuestras, adminzonasZonas, organizaciones);

		user1 = new Usuario(123, "jose Marquez", web);
		user1.setTipo(tipo);

		user2 = new Usuario(124, "manuel Garquez", web);
		user2.setTipo(tipo);

		user3 = new Usuario(125, "martin Benitez", web);
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
		assertEquals(user1.getSitio(), web);
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
/*
	@Test
	void usuarioPublicaUnaVezTest() {  <----------------mover a sitio web
		
		//sitioWeb = mock(SitioWeb.class);
		ubicacion1 = mock(Ubicacion.class);

		user2.publicarMuestraEnSitioWeb(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);  // manda el mensaje
		//sitioWeb.registrarMuestra( TipoDeOpinion.ChincheFoliada , "estoEsUnaFoto", ubicacion1, user2);
		verify(tipo).registrarMuestra(TipoDeOpinion.ChincheFoliada,"estoEsUnaFoto",ubicacion1,user2);  // se fija si le llega al tipo

		assertEquals( user2.getRegistroPublicaciones().size(), 1); // se suma una publi
	}
	
	@Test
	void usuarioOpinaUnaVezTest() { // <-----------------------------------------
		user1.publicarOpinion(001, TipoDeOpinion.ChincheFoliada);        // manda el mensaje                                                              // se fija si le llega al sitio
		int cantOp = user1.getRegistroOpiniones().size();                 // se suma una opi
		assertEquals(cantOp, 1);
	}
	*/
	
	@Test
	void registrarOpinionesTest() {

		user1.agregarFechaDeOpinion(LocalDateTime.now()) ;
		assertEquals(user1.getRegistroOpiniones().size(), 1);
		
		verify(user1.getTipo()).actualizarUsuario(user1);
	}

	@Test
	void registrarPublicacionTest() {
		user1.agregarFechaDePublicacion(LocalDateTime.now()); 
		assertEquals(user1.getRegistroPublicaciones().size(), 1);
		
		verify(user1.getTipo()).actualizarUsuario(user1);
	}
	/*
	@Test
	void unUsuarioNoOpinaUnaMuestraQueNoExiste() {  // <------- mover a sitio web
		user2.publicarOpinion(050, TipoDeOpinion.ChincheFoliada);
		int cantOp = user1.getRegistroOpiniones().size();                 // se suma una opi
		assertEquals(cantOp, 0);
	}
	
	@Test
	void opinarDeMuestraNTest() { // <----------------mover a sitio web
		
		user1.publicarMuestraEnSitioWeb(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubicacion1);
		user2.publicarOpinion(001, TipoDeOpinion.ChincheFoliada);
		int cantOp = user2.getRegistroOpiniones().size(); 
		
		assertEquals(cantOp, 1);
		 
	}
	
	@Test 
	void usuarioNoPuesdeOpinarDosVecesLaMismaMuestra() { <----------------mover a sitio web
		
		user2.publicarOpinion(001, TipoDeOpinion.ChincheFoliada);

		when(sitioWeb.esSuMuestra(001, user2.getId())).thenReturn(false);
		when(sitioWeb.muestraNTieneOpinionDeUsuarioN(001, user2.getId())).thenReturn(false);
		
		assertEquals(user2.getRegistroOpiniones().size(), 1);
		
		when(sitioWeb.muestraNTieneOpinionDeUsuarioN(001, user2.getId())).thenReturn(true);
		
		user2.publicarOpinion(001, TipoDeOpinion.ImagenPocoClara);
		
		assertEquals(user2.getRegistroOpiniones().size(), 1);
	}
	*/

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