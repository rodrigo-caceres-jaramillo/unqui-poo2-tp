package test.java.sitioWeb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.muestras.AdministradorDeMuestras;
import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.SinVerificar;
import main.java.muestras.tipos.TipoDeMuestra;
import main.java.organizaciones.OrganizacioneNoGubernamental;
import main.java.sitioWeb.SitioWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;
import main.java.usuarios.tipos.Basico;
import main.java.zonasDeCoberturas.AdministradorDeZonasDeCoberturas;
import main.java.zonasDeCoberturas.ZonaDeCobertura;
import main.java.muestras.criterios.Criterio;
import main.java.muestras.Opinion;

class SitoWebTest {

    AdministradorDeMuestras adminMuestras;
    AdministradorDeZonasDeCoberturas adminzonasZonas;
    List<OrganizacioneNoGubernamental> organizaciones;
    SitioWeb web;
    Usuario user;
    Usuario user2;
    Muestra muestra;
    Ubicacion ubi;

    @BeforeEach
    void setUp() {
        adminMuestras = mock(AdministradorDeMuestras.class);
        adminzonasZonas = mock(AdministradorDeZonasDeCoberturas.class);
        organizaciones = new ArrayList<OrganizacioneNoGubernamental>();
        web = new SitioWeb(adminMuestras, adminzonasZonas, organizaciones);
        user = mock(Usuario.class);
        muestra = mock(Muestra.class);
        ubi = mock(Ubicacion.class);
        when(adminMuestras.muestraN(10)).thenReturn(muestra);
        when(muestra.getUsuario()).thenReturn(user);
        when(user.getId()).thenReturn(1);
        when(user.getTipo()).thenReturn(new Basico());
        when(user.getSitio()).thenReturn(web);
    }

// Gets y Sets
    @Test
    void getAdministradorDeMuestrasTest() {
        assertEquals(adminMuestras, web.getAdministradorDeMuestras());
    }

    @Test
    void setMuestrasTest() {
        AdministradorDeMuestras nuevoAdminMuestra = mock(AdministradorDeMuestras.class);
        web.setMuestras(nuevoAdminMuestra);
        assertEquals(nuevoAdminMuestra, web.getAdministradorDeMuestras());
    }
    
    @Test
    void getAdministradorDeZonasTest() {
        assertEquals(adminzonasZonas, web.getAdministradorDeZonas());
    }

    @Test
    void setZonasDeCoberturasTest() {
        AdministradorDeZonasDeCoberturas nuevoAdminZonas = mock(AdministradorDeZonasDeCoberturas.class);
        web.setZonasDeCoberturas(nuevoAdminZonas);
        assertEquals(nuevoAdminZonas, web.getAdministradorDeZonas());
    }
    
    @Test
    void getOrganizacionesTest() {
        assertEquals(organizaciones, web.getOrganizaciones());
    }

    @Test
    void setOrganizacionesTest() {
        ArrayList<OrganizacioneNoGubernamental> nuevasOrg = new ArrayList<OrganizacioneNoGubernamental>();
        web.setOrganizaciones(nuevasOrg);
        assertEquals(nuevasOrg, web.getOrganizaciones());
    }

// Metodos
    @Test
    void agregarNuevaMuestraTest() {
        Ubicacion ubicacion = mock(Ubicacion.class);
        Usuario usuario = mock(Usuario.class);
        TipoDeMuestra tipoDeMuestra = mock(TipoDeMuestra.class);
        web.agregarNuevaMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubicacion, usuario, tipoDeMuestra);
        verify(adminMuestras).agregarNuevaMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubicacion, usuario, tipoDeMuestra);;
    }

    @Test
    void agregarNuevaZonaTest() {
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
        web.agregarNuevaZona(zona);

        verify(adminzonasZonas).agregarNuevaZona(zona);
    }

    @Test
    void agregarNuevaOrganizacionTest() {
        OrganizacioneNoGubernamental org = mock(OrganizacioneNoGubernamental.class);
        web.agregarNuevaOrganizacion(org);

        assertTrue(web.getOrganizaciones().contains(org));
    }

    @Test
    void zonasQueSolapanConTest() {
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
        web.zonasQueSolapanCon(zona);
        verify(adminzonasZonas).zonasQueSolapaCon(zona);
    }

    @Test
    void zonasDeInteresDeLaOrgTest() {
        OrganizacioneNoGubernamental org = mock(OrganizacioneNoGubernamental.class);
        web.zonasDeInteresDeLaOrg(org);
        verify(adminzonasZonas).zonasDeInteresDeLaOrg(org);
    }

    @Test
    void organizacionSeInterezaEnLaZonaTest() {
    	//REVISAR
        OrganizacioneNoGubernamental org = mock(OrganizacioneNoGubernamental.class);
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
        web.organizacionSeInterezaEnLaZona(org, zona);
        verify(zona).getOrganizacionesInteresadas();
    }

    @Test
    void organizacionSeDejaDeInterezaEnLaZonaTest() {
    	//REVISAR
        OrganizacioneNoGubernamental org = mock(OrganizacioneNoGubernamental.class);
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
        web.organizacionSeDejaDeInterezaEnLaZona(org, zona);
        verify(zona).getOrganizacionesInteresadas();
    }

    @Test
    void muestraNTest() {
        Integer id = 0;
        web.muestraN(id);
        verify(adminMuestras).muestraN(id);
    }

    @Test
    void muestrasAMenosDeDesdeTest() {
        Muestra muestra = mock(Muestra.class);
        web.muestrasAMenosDeDesde(15f,muestra);

        verify(adminMuestras).muestrasAMenosDeDesde(15f,muestra);
    }

    @Test
    void opinarSobreLaMuestraNTest() {
        Opinion opinion = mock(Opinion.class);
        Integer idMuestra = 10;
        when(muestra.getTipo()).thenReturn(mock(SinVerificar.class));
        web.opinarSobreLaMuestraN(idMuestra, opinion);
        verify(adminMuestras).agregarOpinionAMuestraN(idMuestra, opinion);
    } 

    @Test
    void resultadoActualDeMuestraNTest() {
        web.resultadoActualDeMuestraN(10);
        verify(adminMuestras.muestraN(10)).getResultadoActual();
    }

    @Test
    void esSuMuestraTest() {
        web.esSuMuestra(10,1);
        verify(adminMuestras).muestraNEsDeUsuarioN(10, 1);
    }

    @Test
    void muestraNTieneOpinionDeUsuarioNTest() {
        web.muestraNTieneOpinionDeUsuarioN(10, 1);
        verify(adminMuestras).muestraNTieneOpinionDeUsuarioN(10, 1);
    }

    @Test
    void realizarBusquedaTest() {
       Criterio criterio = mock(Criterio.class);
       web.realizarBusqueda(criterio);
       verify(adminMuestras).realizarBusqueda(criterio);
    }
    @Test
	void opinarDeMuestraNTest() {  
    	//ARREGLAR
    	Usuario user1 = new Usuario(12, "jose marquez", web);
    	web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user1);
    	web.opinarDeMuestraN(001, TipoDeOpinion.ChincheFoliada, user);
		int cantOp = user.getRegistroOpiniones().size(); 
		//verify(adminMuestras).agregarOpinionAMuestraN(001, user.crearOpinion(TipoDeOpinion.ChincheFoliada));;
		assertEquals(cantOp, 1);
	}
    @Test
    void registrarMuestraNTest() {
    	//ARREGLAR
    	web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user);
    	when(user.getRegistroPublicaciones().size()).thenReturn(1);
    	int cantPubli = user.getRegistroPublicaciones().size();
    	assertEquals(cantPubli, 1);
    }
    @Test
    void usuarioNoPuesdeOpinarDosVecesLaMismaMuestra() {
    	//ARREGLAR
    	web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user);
    	web.opinarDeMuestraN(001, TipoDeOpinion.ChincheFoliada, user);
    	web.opinarDeMuestraN(001, TipoDeOpinion.ImagenPocoClara, user);
		int cantOp = user.getRegistroOpiniones().size(); 
		assertEquals(cantOp, 1);
    }
}
