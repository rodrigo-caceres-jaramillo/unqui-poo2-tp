package zonasDeCoberturas;

import muestras.Muestra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import organizaciones.OrganizacioneNoGubernamental;
import ubicacciones.Ubicacion;
import zonasDeCoberturas.ZonaDeCobertura;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZonaDeCoberturaTest {

    //Zona Quilmes
    ZonaDeCobertura zonaQuilmes;
    Ubicacion ubicacionQuilmes;
    ArrayList<Muestra> muestras;
    List<OrganizacioneNoGubernamental> organizacionesIntQuilmes;

    //Zona Berasategui
    ZonaDeCobertura zonaBerasategui;
    Ubicacion ubicacionBerasategui;
    List<OrganizacioneNoGubernamental> organizacionesIntBerasategui;

    //Zona La Plata
    ZonaDeCobertura zonaPlata;
    Ubicacion ubicacionPlata;
    List<OrganizacioneNoGubernamental> organizacionesIntPlata;


    @BeforeEach
    void setUp() {
        // zQ choca con zP
        // zP no se toca con zB
        // zB es adentro de zQ

        organizacionesIntQuilmes = new ArrayList<OrganizacioneNoGubernamental>();
        muestras = new ArrayList<Muestra>();
        ubicacionQuilmes = mock(Ubicacion.class);  // U(0,0)
        zonaQuilmes = new ZonaDeCobertura("Quilmes",ubicacionQuilmes,10,muestras,organizacionesIntQuilmes);

        ubicacionBerasategui = mock(Ubicacion.class);  // U(-2,0)
        organizacionesIntBerasategui = new ArrayList<OrganizacioneNoGubernamental>();
        zonaBerasategui = new ZonaDeCobertura("Berasategui",ubicacionBerasategui,3,muestras,organizacionesIntBerasategui);

        ubicacionPlata = mock(Ubicacion.class);  //  U(12,0)
        organizacionesIntPlata = new ArrayList<OrganizacioneNoGubernamental>();
        zonaPlata = new ZonaDeCobertura("La Plata",ubicacionPlata,5,muestras,organizacionesIntPlata);
    }

    //--------------------TEST getters--------------------//


    //  getOrganizacionesInteresadas
    @Test
    void getOrganizacionesInteresadasTest(){
        assertEquals(organizacionesIntQuilmes,zonaQuilmes.getOrganizacionesInteresadas());
    }

    // getNombre
    @Test
    void getNombreQuilmes(){
        assertEquals("Quilmes",zonaQuilmes.getNombre());
    }

    @Test
    void getNombreBerasategui(){
        assertEquals("Berasategui",zonaBerasategui.getNombre());
    }

    // getEpicentro
    @Test
    void getEpicentroTest(){
        assertEquals(ubicacionQuilmes,zonaQuilmes.getEpicentro());
    }

    // getRadio
    @Test
    void getRadioTest(){
        assertEquals(10f,zonaQuilmes.getRadio());
    }

    // getMuestrasEnLaZona
    @Test
    void getMuestrasEnLaZonaTest(){
        assertEquals(muestras,zonaQuilmes.getMuestrasEnLaZona());
    }


    //--------------------TEST Methods--------------------//
    //  estaSolapadaCon
    @Test
    void estaSolapadaQuilmesConBerasategui(){

        //Quilmes U(0,0) Radio = 10

        //Berasategui  U(-2,0) Radio = 3

        when(ubicacionBerasategui.distanciaEntre(ubicacionQuilmes)).thenReturn(2f);

        assertTrue(zonaQuilmes.estaSolapadaCon(zonaBerasategui));
    }

    @Test
    void EstaSolapadaPlataConQuilmes(){
        //Quilmes U(0,0) Radio = 10

        //La plata U(12,0) Radio = 5

        when(ubicacionPlata.distanciaEntre(ubicacionQuilmes)).thenReturn(12f);

        assertTrue(zonaQuilmes.estaSolapadaCon(zonaPlata));
    }

    @Test
    void noEstaSolapadaBerasateguiConLaPlata(){

        //Berasategui  U(-2,0) Radio = 3

        //La plata U(12,0) Radio = 5

        when(ubicacionBerasategui.distanciaEntre(ubicacionPlata)).thenReturn(14f);

        assertFalse(zonaBerasategui.estaSolapadaCon(zonaPlata));
    }

    //zonaEstaAdentroDe
    @Test
    void zonaNoEstaAdentroDeTest(){

        //Berasategui  U(-2,0) Radio = 3   //La plata U(12,0) Radio = 5

        when(ubicacionBerasategui.distanciaEntre(ubicacionPlata)).thenReturn(14f);

        assertFalse(zonaBerasategui.zonaEstaAdentroDe(zonaPlata));
    }

    @Test
    void zonaEstaAdentroDeTest(){

        //Berasategui  U(-2,0) Radio = 3   //Quilmes U(0,0) Radio = 10

        when(ubicacionBerasategui.distanciaEntre(ubicacionQuilmes)).thenReturn(2f);

        assertTrue(zonaQuilmes.zonaEstaAdentroDe(zonaBerasategui));
    }

    // esLaMismaZona
    @Test
    void noEsLaMismaZonaTest(){

        assertFalse(zonaBerasategui.esLaMismaZona(zonaPlata));
    }

    @Test
    void esLaMismaZonaTest(){

        //Berasategui  U(-2,0) Radio = 3
        assertTrue(zonaBerasategui.esLaMismaZona(zonaBerasategui));
    }

    //zonaChocaCon
    @Test
    void zonaChocaConTest(){

        //Berasategui  U(-2,0) Radio = 3
        when(ubicacionBerasategui.distanciaEntre(ubicacionQuilmes)).thenReturn(2f);
        assertTrue(zonaBerasategui.zonaChocaCon(zonaPlata));
    }

    @Test
    void zonaNoChocaConTest(){  /// Error

        //Berasategui  U(-2,0) Radio = 3


        when(ubicacionPlata.distanciaEntre(ubicacionBerasategui)).thenReturn(14f);  // zP no se toca con zB


        assertFalse(zonaPlata.zonaChocaCon(zonaBerasategui)); // No toca
    }


    //agregarMuestra
    @Test
    void agregarMuestraTest(){

        assertTrue(zonaBerasategui.getMuestrasEnLaZona().size() == 0);
        Muestra muestra =  mock(Muestra.class);
        zonaBerasategui.agregarMuestra(muestra);
        assertTrue(zonaBerasategui.getMuestrasEnLaZona().size() == 1);
    }

    //agregarMuestraSiPerteneceALaZona
    @Test
    void agregarMuestraSiPerteneceALaZonaTest_Agrega(){
        assertTrue(zonaPlata.getMuestrasEnLaZona().size() == 0);

        Muestra muestra =  mock(Muestra.class);
        Ubicacion ubicacionMuestra = mock(Ubicacion.class);

        when(muestra.getUbicacion()).thenReturn(ubicacionMuestra);
        when(ubicacionPlata.distanciaEntre(ubicacionMuestra)).thenReturn(2f);

        zonaPlata.agregarMuestraSiPerteneceALaZona(muestra);
        assertTrue(zonaPlata.getMuestrasEnLaZona().size() == 1);
    }

    @Test
    void agregarMuestraSiPerteneceALaZonaTest_NoAgrega(){
        assertTrue(zonaPlata.getMuestrasEnLaZona().size() == 0);

        Muestra muestra =  mock(Muestra.class);
        Ubicacion ubicacionMuestra = mock(Ubicacion.class);

        when(muestra.getUbicacion()).thenReturn(ubicacionMuestra);
        when(ubicacionPlata.distanciaEntre(ubicacionMuestra)).thenReturn(200f);

        zonaPlata.agregarMuestraSiPerteneceALaZona(muestra);
        assertTrue(zonaPlata.getMuestrasEnLaZona().size() == 0);
    }



    //avisarALasOrganizacionesQueSeRegistroNuevaMuestra
    @Test
    void avisarALasOrganizacionesQueSeRegistroNuevaMuestraTest(){

        OrganizacioneNoGubernamental org =  mock(OrganizacioneNoGubernamental.class);
        Muestra muestra =  mock(Muestra.class);

        zonaPlata.getOrganizacionesInteresadas().add(org);  // agrego la org
        zonaPlata.avisarALasOrganizacionesQueSeRegistroNuevaMuestra(muestra); // mando el mensaje

        verify(org).seRegistroNuevaMuestra(zonaPlata,muestra);
    }

    //laOrganizacioEstaInteresadaEnEstaZona
    @Test
    void laOrganizacioEstaInteresadaEnEstaZonaTest(){

        OrganizacioneNoGubernamental org =  mock(OrganizacioneNoGubernamental.class);

        zonaPlata.getOrganizacionesInteresadas().add(org);  // agrego la org

        assertTrue(zonaPlata.laOrganizacioEstaInteresadaEnEstaZona(org));
    }

    @Test
    void laOrganizacioNoEstaInteresadaEnEstaZonaTest(){

        OrganizacioneNoGubernamental org =  mock(OrganizacioneNoGubernamental.class);

        assertFalse(zonaPlata.laOrganizacioEstaInteresadaEnEstaZona(org));
    }



    //avisarQueSeValidoLaMuestraMuestraNumero
    @Test
    void avisarQueSeValidoLaMuestraMuestraNumeroTest(){

        OrganizacioneNoGubernamental org =  mock(OrganizacioneNoGubernamental.class);
        Muestra muestra =  mock(Muestra.class);

        zonaPlata.getMuestrasEnLaZona().add(muestra);  // agrego la Muestra
        Integer id = 0;

        when(muestra.getId()).thenReturn(id);

        zonaPlata.getOrganizacionesInteresadas().add(org); // agrego la org
        zonaPlata.avisarALasOrganizacionesQueSeValidoLaMuestraNumero(id); // mando el mensaje

        verify(org).seValidoUnaMuestra(zonaPlata,muestra);
    }


}