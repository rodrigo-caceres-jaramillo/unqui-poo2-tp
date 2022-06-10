package muestras.criterios;

import muestras.criterios.conectores.ConectorLogico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import main.java.muestras.Criterios.CriterioCompuesto;
import main.java.muestras.TipoDeOpinion;
import java.time.LocalDate;
import java.util.ArrayList;
import main.java.muestras.Muestra;
import main.java.muestras.tipos.TipoDeMuestra;
import org.mockito.Mock;
import main.java.muestras.Criterios.Criterio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CriterioCompuestoTest {

    CriterioCompuesto criterioCompuesto;
    LocalDate fecha;
    TipoDeOpinion tipoDeOpinion;
    TipoDeMuestra tipoDeMuestra;
    ArrayList<Muestra> muestras;
    Muestra muestra1;
    Muestra muestra2;
    Criterio c1;
    Criterio c2;
    ConectorLogico conectorLogico;

    @BeforeEach
    void setUp() {
        //Mocks
        tipoDeOpinion = mock(TipoDeOpinion.class);
        tipoDeMuestra = mock(TipoDeMuestra.class);

        fecha = mock(LocalDate.class);

        muestra1 =  mock(Muestra.class);
        muestra2 =  mock(Muestra.class);

        c1 =  mock(Criterio.class);
        c2 =  mock(Criterio.class);

        conectorLogico = mock(ConectorLogico.class);

        //Añado a la lista
        muestras.add(muestra1);
        muestras.add(muestra2);

        //Critertio a ver (SUT)
        criterioCompuesto = new CriterioCompuesto(conectorLogico,c1,c2);
    }

    @Test
    void getConector() {
        assertEquals(conectorLogico,criterioCompuesto.getConector());
    }

    @Test
    void realizarBusqueda() {

        //Verificar que le llega a criterios
        verify(c1).realizarBusqueda(fecha,tipoDeOpinion,tipoDeMuestra,muestras);
        verify(c2).realizarBusqueda(fecha,tipoDeOpinion,tipoDeMuestra,muestras);

        //Verificar que le llega a connector
        ArrayList<Muestra> resultadoc1 = new ArrayList<>();
        when(c1.realizarBusqueda(fecha,tipoDeOpinion,tipoDeMuestra,muestras)).thenReturn(resultadoc1);

        ArrayList<Muestra> resultadoc2 = new ArrayList<>();
        when(c2.realizarBusqueda(fecha,tipoDeOpinion,tipoDeMuestra,muestras)).thenReturn(resultadoc2);

        verify(conectorLogico).conectarArray(resultadoc1,resultadoc2);

        //Armo el resultado
        ArrayList<Muestra> resultado = new ArrayList<>();
        when(conectorLogico.conectarArray(resultadoc1,resultadoc2)).thenReturn(resultado);

        //Respuestas del mock
        assertEquals(resultado,criterioCompuesto.realizarBusqueda(fecha,tipoDeOpinion,tipoDeMuestra,muestras));
    }

}