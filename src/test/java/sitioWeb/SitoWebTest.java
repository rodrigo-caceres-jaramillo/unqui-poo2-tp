package test.java.sitioWeb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
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
        verify(zona).agregarOrganizacionInterezada(org);
    }

    @Test
    void organizacionSeDejaDeInterezaEnLaZonaTest() {
    	//REVISAR
        OrganizacioneNoGubernamental org = mock(OrganizacioneNoGubernamental.class);
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
        web.organizacionSeDejaDeInterezaEnLaZona(org, zona);
        verify(zona).eliminarOrganizacionQueSeDejoDeInterezar(org);
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
    	Usuario user1 = new Usuario(12, "jose marquez", web);
    	when(web.getAdministradorDeMuestras().muestraN(001)).
			thenReturn(new Muestra(001,TipoDeOpinion.PhtiaChinche, user1, "foto", ubi, new SinVerificar()));
    	web.opinarDeMuestraN(001, TipoDeOpinion.ChincheFoliada, user);
    	
		verify(adminMuestras).agregarOpinionAMuestraN(001, );
	}
    
    @Test
    void registrarMuestraNTest() {
       	web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user);
    	//verify(web.getAdministradorDeMuestras()).agregarNuevaMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user, new SinVerificar());
    	verify(user).registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi);
    }
    
    @Test
    void usuarioNoPuesdeOpinarDosVecesLaMismaMuestra() {
        Usuario user1 = mock (Usuario.class);
        Muestra muestra = mock (Muestra.class);
        //web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user);
        when(web.getAdministradorDeMuestras().muestraN(001)).
            thenReturn(muestra);

        when(web.getAdministradorDeMuestras().muestraNEsDeUsuarioN(001, 11)).thenReturn(false);
        when(web.getAdministradorDeMuestras().muestraNTieneOpinionDeUsuarioN(001, 11)).thenReturn(false);

        web.opinarDeMuestraN(001, TipoDeOpinion.ChincheFoliada, user1);
        verify(user1).agregarFechaDeOpinion( any (LocalDateTime.class));

        when(web.getAdministradorDeMuestras().muestraNEsDeUsuarioN(001, 11)).thenReturn(true);
        when(web.getAdministradorDeMuestras().muestraNTieneOpinionDeUsuarioN(001, 11)).thenReturn(true);
        web.opinarDeMuestraN(001, TipoDeOpinion.ImagenPocoClara, user1);
        verify(user1, times(2));
    }
    
}
