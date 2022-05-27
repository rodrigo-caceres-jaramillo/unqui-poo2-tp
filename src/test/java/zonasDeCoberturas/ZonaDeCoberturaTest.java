package zonasDeCoberturas;

import muestras.Muestra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import organizaciones.OrganizacioneNoGubernamental;
import ubicacciones.Ubicacion;
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

    // -------  getZonasSolapadas
    @Test
    void getZonasSolapadas(){
        assertEquals(organizacionesIntQuilmes,zonaQuilmes.getOrganizacionesInteresadas());  // Vacio
    }

    // ----- getNombre
    @Test
    void getNombreQuilmes(){
        assertEquals("Quilmes",zonaQuilmes.getNombre());
    }

    @Test
    void getNombreBerasategui(){
        assertEquals("Berasategui",zonaBerasategui.getNombre());
    }

    // -------------  estaSolapadaCon
    @Test
    void estaSolapadaQuilmesConBerasategui(){

        //Quilmes U(0,0) Radio = 10

        //Berasategui  U(-2,0) Radio = 3

        when(ubicacionBerasategui.distanciaEntre(ubicacionQuilmes)).thenReturn(2);


        assertTrue(zonaBerasategui.zonaEstaAdentroDe(zonaQuilmes));
        assertTrue(zonaQuilmes.estaSolapadaCon(zonaBerasategui));
    }

    @Test
    void EstaSolapadaPlataConQuilmes(){
        //Quilmes U(0,0) Radio = 10

        //La plata U(12,0) Radio = 5

        when(ubicacionPlata.distanciaEntre(ubicacionQuilmes)).thenReturn(12);

        assertTrue(zonaQuilmes.estaSolapadaCon(zonaPlata));
    }

    @Test
    void noEstaSolapadaBerasateguiConLaPlata(){

        //Berasategui  U(-2,0) Radio = 3

        //La plata U(12,0) Radio = 5

        when(ubicacionBerasategui.distanciaEntre(ubicacionPlata)).thenReturn(14);

        assertFalse(zonaBerasategui.estaSolapadaCon(zonaPlata));
    }

    @Test
    void esLoMismoBerasateguiConBerasategui(){

        //Berasategui  U(-2,0) Radio = 3
        assertTrue(zonaBerasategui.esLaMismaZona(zonaBerasategui));
    }

    ////////

    @Test
    void zonaQuilmes(){

        //Berasategui  U(-2,0) Radio = 3
        assertTrue(zonaBerasategui.esLaMismaZona(zonaBerasategui));
    }


}