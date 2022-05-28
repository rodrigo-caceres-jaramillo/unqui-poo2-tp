package test.java.ubicacciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.ubicacciones.Ubicacion;

import static org.junit.jupiter.api.Assertions.*;

class UbicacionTest {

    Ubicacion ubicacion1;
    Ubicacion ubicacion2;
    Ubicacion ubicacion3;


    @BeforeEach
    void setUp() {
        ubicacion1 = new Ubicacion(25,25);
        ubicacion2 = new Ubicacion(0,0);
        ubicacion3 = new Ubicacion(-25,-25);

    }

    @Test
    void distanciaEntre1y2(){
        assertEquals(50,ubicacion1.distanciaEntre(ubicacion2));
    }

    @Test
    void distanciaEntre2y3(){
        assertEquals(50,ubicacion2.distanciaEntre(ubicacion3));
    }

    @Test
    void distanciaEntre1y3(){
        assertEquals(100,ubicacion1.distanciaEntre(ubicacion3));
    }


}