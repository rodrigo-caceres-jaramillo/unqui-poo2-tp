package test.java.sitioWeb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.muestras.AdministradorDeMuestras;
import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.TipoDeMuestra;
import main.java.organizaciones.OrganizacioneNoGubernamental;
import main.java.sitioWeb.SitioWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;
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


    @BeforeEach
    void setUp() {
        adminMuestras = mock(AdministradorDeMuestras.class);
        adminzonasZonas = mock(AdministradorDeZonasDeCoberturas.class);
        organizaciones = new ArrayList<OrganizacioneNoGubernamental>();
        web = new SitioWeb(adminMuestras, adminzonasZonas, organizaciones);
        user =new Usuario( 15, "jose", web);
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
    void zonasQueSolapadasConTest() {
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
        web.zonasQueSolapadasCon(zona);
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
        OrganizacioneNoGubernamental org = mock(OrganizacioneNoGubernamental.class);
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
        web.organizacionSeInterezaEnLaZona(org, zona);
        verify(zona).getOrganizacionesInteresadas();
    }

    @Test
    void organizacionSeDejaDeInterezaEnLaZonaTest() {
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
        Muestra muestra = mock(Muestra.class);
        Integer idMuestra = 58;

        when(adminMuestras.muestraNSeVerifico(idMuestra, any(TipoDeMuestra.class))).thenReturn(true);

        web.opinarSobreLaMuestraN(idMuestra,opinion);

        verify(adminMuestras).agregarOpinionAMuestraN(idMuestra, opinion);
        verify(adminMuestras).muestraNSeVerifico(idMuestra, any(TipoDeMuestra.class));  // if
        verify(adminzonasZonas).avisarALasOrganizacionesQueSeValidoLaMuestraNumero(idMuestra);
    } 

    @Test
    void resultadoActualDeMuestraNTest() {
        Integer idMuestra = 58;

        web.resultadoActualDeMuestraN(idMuestra);
        verify(adminMuestras).muestraN(idMuestra);
    }

    @Test
    void esSuMuestraTest() {
    	Muestra muestra = mock(Muestra.class);
    	Integer idMuestra = 23;
        Integer idUsuarioEnMuestra = muestra.getUsuario().getId();
        Integer idUsuario = 58;
        when(muestra.getUsuario().getId()).thenReturn(58);

        web.esSuMuestra(idUsuarioEnMuestra,idUsuario);
        verify(adminMuestras).muestraN(idMuestra);
    }

    @Test
    void muestraNTieneOpinionDeUsuarioNTest() {
        //Integer idMuestra = 58;
        //Integer idUsuario = 58;
        user.opinarDeMuestraN(01, TipoDeOpinion.ChincheFoliada);
        web.muestraNTieneOpinionDeUsuarioN(01,user.getId());
        verify(adminMuestras).muestraN(01);
    }

    @Test
    void realizarBusquedaTest() {
       Criterio criterio = mock(Criterio.class);
       TipoDeOpinion tipoO = mock(TipoDeOpinion.class);
       TipoDeMuestra tipoM = mock(TipoDeMuestra.class);
        web.realizarBusqueda(LocalDate.now(),tipoO,tipoM,criterio);
        verify(adminMuestras).realizarBusqueda(LocalDate.now(),tipoO,tipoM,criterio);
    }



}
