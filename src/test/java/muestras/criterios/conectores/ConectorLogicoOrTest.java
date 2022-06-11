package test.java.muestras.criterios.conectores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import main.java.muestras.Muestra;
import main.java.muestras.criterios.conectores.ConectorLogicoOr;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ConectorLogicoOrTest {
    ConectorLogicoOr  conectorLogicoOr;
    Muestra muestra;
    Muestra muestra1;
    Muestra muestra2;
    Muestra muestra3;
    Muestra muestra4;
    Muestra muestra5;
    Muestra muestra6;
    Muestra muestra7;
    Muestra muestra8;
    Muestra muestra9;
    ArrayList<Muestra> muestras;
    ArrayList<Muestra> otraMuestras;

    @BeforeEach
    void setUp() {
        muestra = mock(Muestra.class);
        muestra1 = mock(Muestra.class);
        muestra2 = mock(Muestra.class);
        muestra3 = mock(Muestra.class);
        muestra4 = mock(Muestra.class);
        muestra5 = mock(Muestra.class);
        muestra6 = mock(Muestra.class);
        muestra7 = mock(Muestra.class);
        muestra8 = mock(Muestra.class);
        muestra9 = mock(Muestra.class);

        muestras = new ArrayList<Muestra>();
        muestras.add(muestra1);
        muestras.add(muestra2);
        muestras.add(muestra3);
        muestras.add(muestra4);
        muestras.add(muestra5);

        otraMuestras = new ArrayList<Muestra>();
        otraMuestras.add(muestra4);
        otraMuestras.add(muestra5);
        otraMuestras.add(muestra6);
        otraMuestras.add(muestra7);

        conectorLogicoOr = new ConectorLogicoOr();
    }

    @Test
    void conectarArray() {
        ArrayList<Muestra> respuesta = new ArrayList<Muestra>();
        respuesta.add(muestra1);
        respuesta.add(muestra2);
        respuesta.add(muestra3);
        respuesta.add(muestra4);
        respuesta.add(muestra5);
        respuesta.add(muestra6);
        respuesta.add(muestra7);

        assertEquals(conectorLogicoOr.conectarArray(muestras,otraMuestras),respuesta);
    }

    @Test
    void añadirSiNoEsta() {
        ArrayList<Muestra> muestrasAVer = new ArrayList<Muestra>();
        muestrasAVer.add(muestra1);
        muestrasAVer.add(muestra2);
        muestrasAVer.add(muestra3);

        //Agrego muestra4 pero falta muestra5
        conectorLogicoOr.añadirSiNoEsta(muestrasAVer,muestra4);
        assertNotEquals(muestras,muestrasAVer);

        //Agrego muestra5 y no falta nada
        conectorLogicoOr.añadirSiNoEsta(muestrasAVer,muestra5);
        assertEquals(muestras,muestrasAVer);

        //Se intenta agregar pero ya esta
        conectorLogicoOr.añadirSiNoEsta(muestrasAVer,muestra4);
        assertEquals(muestras,muestrasAVer);
    }
}