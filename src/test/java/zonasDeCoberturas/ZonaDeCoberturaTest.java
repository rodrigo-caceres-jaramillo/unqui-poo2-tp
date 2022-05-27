package zonasDeCoberturas;

import muestras.Muestra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ubicacciones.Ubicacion;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ZonaDeCoberturaTest {

    ZonaDeCobertura zonaQuilmes;
    Ubicacion ubicacionQuilmes;
    ArrayList<Muestra> muestras;
    ArrayList<ZonaDeCobertura> solapasdasConQuilmes;

    ZonaDeCobertura zonaBerasategui;
    Ubicacion ubicacionBerasategui;
    ArrayList<ZonaDeCobertura> solapasdasBerasategui;

    ZonaDeCobertura zonaPlata;
    Ubicacion ubicacionPlata;
    ArrayList<ZonaDeCobertura> solapasdasPlata;


    @BeforeEach
    void setUp() {
        // zQ choca con zP
        // zP no se toca con zB
        // zB es adentro de zQ

        solapasdasConQuilmes = new ArrayList<ZonaDeCobertura>();
        muestras = new ArrayList<Muestra>();
        ubicacionQuilmes = mock(Ubicacion.class);  // U(0,0)
        zonaQuilmes = new ZonaDeCobertura("Quilmes",ubicacionQuilmes,10,muestras,solapasdasConQuilmes);

        ubicacionBerasategui = mock(Ubicacion.class);  // U(-2,0)
        solapasdasBerasategui = new ArrayList<ZonaDeCobertura>();
        zonaBerasategui = new ZonaDeCobertura("Berasategui",ubicacionBerasategui,3,muestras,solapasdasBerasategui);

        ubicacionPlata = mock(Ubicacion.class);  //  U(12,0)
        solapasdasPlata = new ArrayList<ZonaDeCobertura>();
        zonaPlata = new ZonaDeCobertura("La Plata",ubicacionPlata,5,muestras,solapasdasPlata);
    }

    // -------  getZonasSolapadas
    @Test
    void getZonasSolapadas(){
        ArrayList<ZonaDeCobertura> zonasAVer = new ArrayList<ZonaDeCobertura>();
        assertEquals(solapasdasConQuilmes,zonaQuilmes.getZonasSolapadas());  // Vacio
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


    // -------------  agregarSiEsZonaSolapada

    @Test
    void agregarQuilmesABerasategui() {
        //Quilmes     U(0,0)    Radio = 10

        //Berasategui U(-2,0)  Radio = 3

        when(ubicacionQuilmes.distanciaEntre(ubicacionBerasategui)).thenReturn(2);

        assertTrue(zonaQuilmes.estaSolapadaCon(zonaBerasategui)); // ya testiado mas arriba

        ArrayList<ZonaDeCobertura> zonas = new ArrayList<ZonaDeCobertura>();  // creo la Array
        zonas.add(zonaBerasategui);

        zonaQuilmes.agregarSiEsZonaSolapada(zonaBerasategui);   // agregar a la lista
        assertEquals(zonas,zonaQuilmes.getZonasSolapadas());

    }

    @Test
    void noAgregarQuilmesAQuilmes() {
        //Quilmes U(0,0)    Radio = 10

        assertTrue(zonaQuilmes.esLaMismaZona(zonaQuilmes));

        ArrayList<ZonaDeCobertura> zonas = new ArrayList<ZonaDeCobertura>();  // creo la Array

        zonaQuilmes.agregarSiEsZonaSolapada(zonaQuilmes);   // agregar a la lista
        assertEquals(zonas,zonaQuilmes.getZonasSolapadas());
    }

    @Test
    void noAgregarBerasateguiConLaPlata() {
        //Berasategui U(-2,0)  Radio = 3

        //La plata    U(12,0)  Radio = 5

        when(ubicacionBerasategui.distanciaEntre(ubicacionPlata)).thenReturn(14);

        assertFalse(zonaBerasategui.estaSolapadaCon(zonaPlata));

        ArrayList<ZonaDeCobertura> zonas = new ArrayList<ZonaDeCobertura>();  // creo la Array

        zonaBerasategui.agregarSiEsZonaSolapada(zonaPlata);   // agregar a la lista
        assertEquals(zonas,zonaBerasategui.getZonasSolapadas());
    }


}