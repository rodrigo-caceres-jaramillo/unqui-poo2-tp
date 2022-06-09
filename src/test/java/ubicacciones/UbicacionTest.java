package test.java.ubicacciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.ubicacciones.Ubicacion;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UbicacionTest {

    Ubicacion ubicacion1;
    Ubicacion ubicacion2;
    Ubicacion ubicacion3;
    Ubicacion ubicacion4;

    @BeforeEach
    void setUp() {
        ubicacion1 = new Ubicacion(25f,25f);
        ubicacion2 = new Ubicacion(0f,0f);
        ubicacion3 = new Ubicacion(-25f,-25f);
        ubicacion4 = new Ubicacion(-50f,-50f);

    }

    @Test
    void getLongitudTest(){assertEquals(25,ubicacion1.getLongitud()); }

    @Test
    void getLatitudTest(){assertEquals(25,ubicacion1.getLatitud()); }

    @Test
    void distanciaEntre1y2(){ assertEquals(50,ubicacion1.distanciaEntre(ubicacion2)); }

    @Test
    void distanciaEntre2y3(){
        assertEquals(50,ubicacion2.distanciaEntre(ubicacion3));
    }

    @Test
    void distanciaEntre1y3(){
        assertEquals(100,ubicacion1.distanciaEntre(ubicacion3));
    }

    @Test
    void ubicacionesAMenosDe(){
        ArrayList<Ubicacion> todasLasUbi = new ArrayList<>();
        todasLasUbi.add(ubicacion2);
        todasLasUbi.add(ubicacion3);
        todasLasUbi.add(ubicacion4);

        ArrayList<Ubicacion> ubicacionesCercadeUbi1 = new ArrayList<>();
        ubicacionesCercadeUbi1.add(ubicacion2);

        assertEquals(ubicacion1.ubicacionesAMenosDe(todasLasUbi,60),ubicacionesCercadeUbi1);}

}