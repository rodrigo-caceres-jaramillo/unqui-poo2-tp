package zonasDeCoberturas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ubicacciones.CalculadorDeDistancias;
import ubicacciones.Ubicacion;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CollectorDeZonasDeCoberturasTest {

    ZonaDeCobertura zonaSur;
    ZonaDeCobertura zonaSurEste;
    ZonaDeCobertura zonaEste;
    ZonaDeCobertura zonaNorEste;
    ZonaDeCobertura zonaNorte;
    ZonaDeCobertura zonaNorOeste;
    ArrayList<ZonaDeCobertura> zonas;
    CollectorDeZonasDeCoberturas collector;

    @BeforeEach
    void setUp() {

        // Zonas De Coberturas
        zonaSur      = mock(ZonaDeCobertura.class);
        zonaSurEste  = mock(ZonaDeCobertura.class);
        zonaEste     = mock(ZonaDeCobertura.class);
        zonaNorEste  = mock(ZonaDeCobertura.class);
        zonaNorte    = mock(ZonaDeCobertura.class);
        zonaNorOeste = mock(ZonaDeCobertura.class);

        //Agregar zonas
        zonas = new ArrayList<ZonaDeCobertura>();
        zonas.add(zonaSur);
        zonas.add(zonaSurEste);
        zonas.add(zonaEste);
        zonas.add(zonaNorEste);
        zonas.add(zonaNorte);
        zonas.add(zonaNorOeste);

        //Collector De Zonas De Coberturas
        collector = new CollectorDeZonasDeCoberturas(zonas);
        collector.setTodasLasZonas(zonas);
    }


    @Test
    void getTodasLasZonas(){
        assertEquals(zonas,collector.getTodasLasZonas());
    }

    @Test
    void agregarNuevaZona() {
        int tamaño = collector.getTodasLasZonas().size();
        ZonaDeCobertura zonaNueva = mock(ZonaDeCobertura.class);

        collector.agregarNuevaZona(zonaNueva);  // agrego elemento

        assertEquals(tamaño+1,collector.getTodasLasZonas().size());
    }

    ///////////  registrar Nueva Zona

    @Test
    void registrarNuevaZona() {

        ZonaDeCobertura zonaNueva = mock(ZonaDeCobertura.class);

        collector.registrarNuevaZona(zonaNueva);

        verify(zonaSur).agregarSiEsZonaSolapada(zonaNueva);
        verify(zonaSurEste).agregarSiEsZonaSolapada(zonaNueva);
        verify(zonaEste).agregarSiEsZonaSolapada(zonaNueva);
        verify(zonaNorEste).agregarSiEsZonaSolapada(zonaNueva);
        verify(zonaNorte).agregarSiEsZonaSolapada(zonaNueva);
        verify(zonaNorOeste).agregarSiEsZonaSolapada(zonaNueva);


    }

}

