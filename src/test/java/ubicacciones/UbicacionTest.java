package ubicacciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ubicacciones.Ubicacion;

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
        ubicacion1 = new Ubicacion(25,25);
        ubicacion2 = new Ubicacion(0,0);
        ubicacion3 = new Ubicacion(-25,-25);
        ubicacion3 = new Ubicacion(-50,-50);

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
        todasLasUbi.add(ubicacion1);
        todasLasUbi.add(ubicacion2);
        todasLasUbi.add(ubicacion3);
        todasLasUbi.add(ubicacion4);

        ArrayList<Ubicacion> ubicacionesCercadeUbi1 = new ArrayList<>();
        ubicacionesCercadeUbi1.add(ubicacion2);
        ubicacionesCercadeUbi1.add(ubicacion3);

        assertEquals(ubicacion1.ubicacionesAMenosDe(todasLasUbi,25),ubicacionesCercadeUbi1);}

}