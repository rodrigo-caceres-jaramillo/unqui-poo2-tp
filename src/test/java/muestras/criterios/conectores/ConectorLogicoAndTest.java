package muestras.criterios.conectores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.muestras.Muestra;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ConectorLogicoAndTest {
    ConectorLogicoAnd conectorLogicoAnd;
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

        conectorLogicoAnd = new ConectorLogicoAnd();
    }

    @Test
    void conectarArray() {
        ArrayList<Muestra> respuesta = new ArrayList<Muestra>();
        respuesta.add(muestra4);
        respuesta.add(muestra5);
        assertEquals(conectorLogicoAnd.conectarArray(muestras,otraMuestras),respuesta);


    }


}