package test.java.ubicacciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.ubicacciones.CalculadorDeDistancias;
import main.java.ubicacciones.Ubicacion;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculadorDeDistanciasTest {

    CalculadorDeDistancias calculador;
    Ubicacion ubicacion1;
    Ubicacion ubicacion2;


    @BeforeEach
    void setUp() {
        calculador = new CalculadorDeDistancias();
        ubicacion1 = mock(Ubicacion.class);
        ubicacion2 = mock(Ubicacion.class);
    }

    //  -------------------- distanciaEntreLasUbicaciones
    @Test
    void distanciaEntreLasUbicacionesPositivas() {
        when(ubicacion1.getLatitud()).thenReturn(50);
        when(ubicacion1.getLongitud()).thenReturn(25);

        when(ubicacion2.getLatitud()).thenReturn(125);
        when(ubicacion2.getLongitud()).thenReturn(100);

        assertEquals(150,calculador.distanciaEntreLasUbicaciones(ubicacion1,ubicacion2));
    }

    @Test
    void distanciaEntreLasUbicacionesNegativas() {
        when(ubicacion1.getLatitud()).thenReturn(-50);
        when(ubicacion1.getLongitud()).thenReturn(-25);

        when(ubicacion2.getLatitud()).thenReturn(-125);
        when(ubicacion2.getLongitud()).thenReturn(-100);

        assertEquals(150,calculador.distanciaEntreLasUbicaciones(ubicacion1,ubicacion2));
    }

    @Test
    void distanciaEntreLasUbicacionesUnaPositivasYOtraNegativas() {
        when(ubicacion1.getLatitud()).thenReturn(50);
        when(ubicacion1.getLongitud()).thenReturn(25);

        when(ubicacion2.getLatitud()).thenReturn(-125);
        when(ubicacion2.getLongitud()).thenReturn(-100);

        assertEquals(300,calculador.distanciaEntreLasUbicaciones(ubicacion1,ubicacion2));
    }


    //  -------------------- distanciaEntreLosPuntos

    @Test
    void distanciaEntreLosPuntosPositivos() {
        assertEquals(25,calculador.distanciaEntreLosPuntos(100,75));
    }

    @Test
    void distanciaEntreLosPuntosNegativos() {
        assertEquals(25,calculador.distanciaEntreLosPuntos(-100,-75));
    }

    @Test
    void distanciaEntreLosPuntosUnoPositivoOtroNegativo() {
        assertEquals(175,calculador.distanciaEntreLosPuntos(100,-75));
    }

}