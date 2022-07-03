package test.java.sitioWeb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
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
        user = mock(Usuario.class);
        muestra = mock(Muestra.class);
        ubi = mock(Ubicacion.class);
        when(muestra.getUsuario()).thenReturn(user);
        when(user.getTipo()).thenReturn(new Basico());
        when(user.getSitio()).thenReturn(web);
        
        web = new SitioWeb(adminMuestras, adminzonasZonas, organizaciones);
    }

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
        List<OrganizacioneNoGubernamental> nuevasOrg = new ArrayList<OrganizacioneNoGubernamental>();
        web.setOrganizaciones(nuevasOrg);
        assertEquals(nuevasOrg, web.getOrganizaciones());
    }

    @Test
    void agregarNuevaMuestraTest() {
    	web.agregarNuevaMuestra(muestra);
    	verify(adminMuestras).agregarNuevaMuestra(muestra);
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
        OrganizacioneNoGubernamental org = mock(OrganizacioneNoGubernamental.class);
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
        web.organizacionSeInterezaEnLaZona(org, zona);
        verify(zona).agregarOrganizacionInterezada(org);
    }

    @Test
    void organizacionSeDejaDeInterezaEnLaZonaTest() {
        OrganizacioneNoGubernamental org = mock(OrganizacioneNoGubernamental.class);
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
        web.organizacionSeDejaDeInterezaEnLaZona(org, zona);
        verify(zona).eliminarOrganizacionQueSeDejoDeInterezar(org);
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
        when(muestra.getTipo()).thenReturn(mock(SinVerificar.class));
        when(muestra.seVerifico( any(TipoDeMuestra.class) )).thenReturn(true);
        web.opinarSobreLaMuestraN(muestra, opinion);

        verify(muestra).seVerifico(muestra.getTipo());
        verify(muestra).agregarOpinion(opinion);

        verify(adminzonasZonas).avisarALasOrganizacionesQueSeValidoLaMuestraNumero(muestra);
    }

    @Test
    void opinarSobreLaMuestraNSeVerificaTest() {
        Opinion opinion = mock(Opinion.class);
        when(muestra.getTipo()).thenReturn(mock(SinVerificar.class));
        web.opinarSobreLaMuestraN(muestra, opinion);

        verify(muestra).seVerifico(muestra.getTipo());
        verify(muestra).agregarOpinion(opinion);
    }


    @Test
    void resultadoActualDeMuestraNTest() {
        web.resultadoActualDeMuestraN(muestra);
        verify(muestra).getResultadoActual();
    }

    @Test
    void muestraNTieneOpinionDeUsuarioNTest() {
        web.muestraTieneOpinionDeUsuario(muestra, user);;
        verify(muestra).tieneUnaOpinionDeUsuario(user);
    }

    @Test
    void realizarBusquedaTest() {
       Criterio criterio = mock(Criterio.class);
       web.realizarBusqueda(criterio);
       verify(adminMuestras).realizarBusqueda(criterio);
    }
    
    @Test
    void usuarioNoPuesdeOpinarDosVecesLaMismaMuestra() {
        web.opinarDeMuestraN(muestra, TipoDeOpinion.ChincheFoliada, user);
        verify(user, never()).hiceUnaOpinion();
    }
}
