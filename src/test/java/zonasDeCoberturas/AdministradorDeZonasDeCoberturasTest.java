package zonasDeCoberturas;


import muestras.Muestra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import organizaciones.OrganizacioneNoGubernamental;
import sitoWeb.SitoWeb;
import zonasDeCoberturas.AdministradorDeZonasDeCoberturas;
import zonasDeCoberturas.ZonaDeCobertura;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AdministradorDeZonasDeCoberturasTest {

    ZonaDeCobertura zonaSur;
    ZonaDeCobertura zonaSurEste;
    ZonaDeCobertura zonaEste;
    ZonaDeCobertura zonaNorEste;
    ZonaDeCobertura zonaNorte;
    ZonaDeCobertura zonaNorOeste;

    OrganizacioneNoGubernamental org1;

    ArrayList<ZonaDeCobertura> zonas;
    SitoWeb web;
    AdministradorDeZonasDeCoberturas adminZonas;

    @BeforeEach
    void setUp() {

        // Zonas De Coberturas
        zonaSur      = mock(ZonaDeCobertura.class);
        zonaSurEste  = mock(ZonaDeCobertura.class);
        zonaEste     = mock(ZonaDeCobertura.class);
        zonaNorEste  = mock(ZonaDeCobertura.class);
        zonaNorte    = mock(ZonaDeCobertura.class);
        zonaNorOeste = mock(ZonaDeCobertura.class);

        //Organizaciones
        OrganizacioneNoGubernamental org1 = mock(OrganizacioneNoGubernamental.class);

        //Agregar zonas
        zonas = new ArrayList<ZonaDeCobertura>();
        zonas.add(zonaSur);
        zonas.add(zonaSurEste);
        zonas.add(zonaEste);
        zonas.add(zonaNorEste);
        zonas.add(zonaNorte);
        zonas.add(zonaNorOeste);

        //SitioWeb
        web = mock(SitoWeb.class);

        //Administrador De Zonas De Coberturas
        adminZonas = new AdministradorDeZonasDeCoberturas(zonas);
    }


    @Test
    void getTodasLasZonas(){
        assertEquals(zonas,adminZonas.getTodasLasZonas());
    }

    @Test
    void setTodasLasZonas(){
        ArrayList<ZonaDeCobertura> zonasNuevas = new ArrayList<ZonaDeCobertura>();
        adminZonas.setTodasLasZonas(zonasNuevas);
        assertEquals(zonas,adminZonas.getTodasLasZonas());
    }

    @Test
    void agregarNuevaZona() {
        int tamaño = adminZonas.getTodasLasZonas().size();
        ZonaDeCobertura zonaNueva = mock(ZonaDeCobertura.class);

        adminZonas.agregarNuevaZona(zonaNueva);  // agrego elemento

        assertEquals(tamaño+1,adminZonas.getTodasLasZonas().size());
    }

    ///////////  actualizarZonasConNuevaMuestra(Muestra)
    @Test
    void actualizarZonasConNuevaMuestra() {
        Muestra muestra = mock(Muestra.class);
        adminZonas.actualizarZonasConNuevaMuestra(muestra);

        //Verificar si llegan los mensajes
        verify(zonaSur).agregarMuestraSiPerteneceALaZona(muestra);
        verify(zonaSurEste).agregarMuestraSiPerteneceALaZona(muestra);
        verify(zonaEste).agregarMuestraSiPerteneceALaZona(muestra);
        verify(zonaNorEste).agregarMuestraSiPerteneceALaZona(muestra);
        verify(zonaNorte).agregarMuestraSiPerteneceALaZona(muestra);
        verify(zonaNorOeste).agregarMuestraSiPerteneceALaZona(muestra);
    }


    //////////  zonasDeInteresDeLaOrg(OrganizacioneNoGubernamental)
    @Test
    void zonasDeInteresDeLaOrg() {


        //Verificar si llegan los mensajes
        when(zonaSur.laOrganizacioEstaInteresadaEnEstaZona(org1)).thenReturn(true);
        when(zonaSurEste.laOrganizacioEstaInteresadaEnEstaZona(org1)).thenReturn(false);
        when(zonaEste.laOrganizacioEstaInteresadaEnEstaZona(org1)).thenReturn(true);
        when(zonaNorEste.laOrganizacioEstaInteresadaEnEstaZona(org1)).thenReturn(false);
        when(zonaNorte.laOrganizacioEstaInteresadaEnEstaZona(org1)).thenReturn(true);
        when(zonaNorOeste.laOrganizacioEstaInteresadaEnEstaZona(org1)).thenReturn(false);

        ArrayList<ZonaDeCobertura> zonasDeInteres = new ArrayList<ZonaDeCobertura>();
        zonasDeInteres.add(zonaSur);
        zonasDeInteres.add(zonaEste);
        zonasDeInteres.add(zonaNorte);

        assertEquals(zonasDeInteres,adminZonas.zonasDeInteresDeLaOrg(org1));
    }

    @Test
    void zonasDeInteresDeLaOrgPeroConFallos() {

        //Verificar si llegan los mensajes
        when(zonaSur.laOrganizacioEstaInteresadaEnEstaZona(org1)).thenReturn(false);
        when(zonaSurEste.laOrganizacioEstaInteresadaEnEstaZona(org1)).thenReturn(false);
        when(zonaEste.laOrganizacioEstaInteresadaEnEstaZona(org1)).thenReturn(true);
        when(zonaNorEste.laOrganizacioEstaInteresadaEnEstaZona(org1)).thenReturn(false);
        when(zonaNorte.laOrganizacioEstaInteresadaEnEstaZona(org1)).thenReturn(true);
        when(zonaNorOeste.laOrganizacioEstaInteresadaEnEstaZona(org1)).thenReturn(false);

        ArrayList<ZonaDeCobertura> zonasDeInteres = new ArrayList<ZonaDeCobertura>();
        zonasDeInteres.add(zonaSur);
        zonasDeInteres.add(zonaEste);
        zonasDeInteres.add(zonaNorte);

        assertNotEquals(zonasDeInteres,adminZonas.zonasDeInteresDeLaOrg(org1));
    }

    @Test
    void avisarALasOrganizacionesQueSeValidoLaMuestraNumeroTest() {
        Integer id = 0;
        adminZonas.avisarALasOrganizacionesQueSeValidoLaMuestraNumero(id);
                //Verificar si llegan los mensajes
        verify(zonaSur).avisarQueSeValidoLaMuestraMuestraNumero(id);
        verify(zonaSurEste).avisarQueSeValidoLaMuestraMuestraNumero(id);
        verify(zonaEste).avisarQueSeValidoLaMuestraMuestraNumero(id);
        verify(zonaNorEste).avisarQueSeValidoLaMuestraMuestraNumero(id);
        verify(zonaNorte).avisarQueSeValidoLaMuestraMuestraNumero(id);
        verify(zonaNorOeste).avisarQueSeValidoLaMuestraMuestraNumero(id);
    }

    @Test
    void zonasQueSolapadasConTest() {
        ZonaDeCobertura zonaNueva = mock(ZonaDeCobertura.class);

        adminZonas.zonasQueSolapadasCon(zonaNueva);

        verify(zonaSur).estaSolapadaCon(zonaNueva);
        verify(zonaSurEste).estaSolapadaCon(zonaNueva);
        verify(zonaEste).estaSolapadaCon(zonaNueva);
        verify(zonaNorEste).estaSolapadaCon(zonaNueva);
        verify(zonaNorte).estaSolapadaCon(zonaNueva);
        verify(zonaNorOeste).estaSolapadaCon(zonaNueva);
    }



}

