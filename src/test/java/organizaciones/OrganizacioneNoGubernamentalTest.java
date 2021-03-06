package test.java.organizaciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static main.java.organizaciones.TipoDeOrganizacion.Salud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.muestras.Muestra;
import main.java.organizaciones.FuncionExterna;
import main.java.organizaciones.OrganizacioneNoGubernamental;
import main.java.ubicacciones.Ubicacion;
import main.java.zonasDeCoberturas.ZonaDeCobertura;

class OrganizacioneNoGubernamentalTest {

    OrganizacioneNoGubernamental organizacion;
    Ubicacion ubi;
    FuncionExterna funNuevaMuestra;
    FuncionExterna funValidacion;

    @BeforeEach
    void setUp() {
        //Mocks
        ubi = mock(Ubicacion.class);
        funNuevaMuestra = mock(FuncionExterna.class);
        funValidacion = mock(FuncionExterna.class);

        //Org
        organizacion = new OrganizacioneNoGubernamental(ubi,Salud,10,funNuevaMuestra,funValidacion);
    }

    @Test
    void getFuncionNuevaMuestraTest() {
        assertEquals(funNuevaMuestra, organizacion.getFuncionNuevaMuestra());
    }

    @Test
    void getFuncionValidacionTest() {
        assertEquals(funValidacion, organizacion.getFuncionValidacion());
    }

    @Test
    void get() {
        assertEquals(funValidacion, organizacion.getFuncionValidacion());
    }

    @Test
    void seRegistroNuevaMuestraTest() {
        //Mock
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
        Muestra muestra = mock(Muestra.class);

        //Mando mensaje
        organizacion.seRegistroNuevaMuestra(zona,muestra);

        //Espero que llegue el mensaje
        verify(funNuevaMuestra).nuevoEvento(organizacion,zona,muestra);
    }

    @Test
    void seValidoUnaMuestraTest() {
        //Mock
        ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
        Muestra muestra = mock(Muestra.class);

        //Mando mensaje
        organizacion.seValidoUnaMuestra(zona,muestra);

        //Espero que llegue el mensaje
        verify(funValidacion).nuevoEvento(organizacion,zona,muestra);
    }

}