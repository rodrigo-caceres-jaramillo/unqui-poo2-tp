package sitoWeb;

import muestras.AdministradorDeMuestras;
import muestras.Muestra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import organizaciones.OrganizacioneNoGubernamental;
import zonasDeCoberturas.AdministradorDeZonasDeCoberturas;
import zonasDeCoberturas.ZonaDeCobertura;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SitoWebTest {

    AdministradorDeMuestras adminMuestras;
    AdministradorDeZonasDeCoberturas adminzonasZonas;
    List<OrganizacioneNoGubernamental> organizaciones;
    SitoWeb web;


    @BeforeEach
    void setUp() {
        adminMuestras = mock(AdministradorDeMuestras.class);
        adminzonasZonas = mock(AdministradorDeZonasDeCoberturas.class);
        organizaciones = new ArrayList<OrganizacioneNoGubernamental>();
        web = new SitoWeb(adminMuestras, adminzonasZonas, organizaciones);
    }

//Falta testear (organizacionSeDejaDeInterezaEnLaZona,muestraN,opinarSobreLaMuestraNumero)

// Tests de Gets

    @Test
    void getAdministradorDeMuestrasTest() {
        assertEquals(adminMuestras, web.getAdministradorDeMuestras());
    }

    @Test
    void getAdministradorDeZonasTest() {
        assertEquals(adminzonasZonas, web.getAdministradorDeZonas());
    }

    @Test
    void getOrganizacionesTest() {
        assertEquals(organizaciones, web.getOrganizaciones());
    }

// Tests sets

    @Test
    void setMuestrasTest() {
        AdministradorDeMuestras nuevoAdminMuestra = mock(AdministradorDeMuestras.class);
        web.setMuestras(nuevoAdminMuestra);
        assertEquals(nuevoAdminMuestra, web.getAdministradorDeMuestras());
    }

    @Test
    void setZonasDeCoberturasTest() {
        AdministradorDeZonasDeCoberturas nuevoAdminZonas = mock(AdministradorDeZonasDeCoberturas.class);
        web.setZonasDeCoberturas(nuevoAdminZonas);
        assertEquals(nuevoAdminZonas, web.getAdministradorDeZonas());
    }

    @Test
    void setOrganizacionesTest() {
        ArrayList<OrganizacioneNoGubernamental> nuevasOrg = new ArrayList<OrganizacioneNoGubernamental>();
        web.setOrganizaciones(nuevasOrg);
        assertEquals(nuevasOrg, web.getOrganizaciones());
    }

// Methods

    @Test
    void agregarNuevaMuestraTest() {
        Muestra muestra = mock(Muestra.class);
        web.agregarNuevaMuestra(muestra);

        verify(adminMuestras).agregarNuevaMuestra(muestra);
        verify(adminzonasZonas).actualizarZonasConNuevaMuestra(muestra);
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

        verify(adminzonasZonas).zonasQueSolapadasCon(zona);
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





}
