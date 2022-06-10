package muestras.criterios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import main.java.muestras.Criterios.CriterioTipoDeInsecto;
import main.java.muestras.TipoDeOpinion;
import java.time.LocalDate;
import java.util.ArrayList;
import main.java.muestras.Muestra;
import main.java.muestras.tipos.TipoDeMuestra;
import org.mockito.Mock;


class CriterioTipoDeInsectoTest {

    CriterioTipoDeInsecto criterioDeInsectos;
    LocalDate fecha;
    TipoDeOpinion tipoDeOpinion;
    TipoDeMuestra tipoDeMuestra;
    ArrayList<Muestra> muestras;
    Muestra muestra1;
    Muestra muestra2;

    @BeforeEach
    void setUp() {
        //Mocks
        tipoDeOpinion = mock(TipoDeOpinion.class);
        tipoDeMuestra = mock(TipoDeMuestra.class);

        muestra1 =  mock(Muestra.class);
        muestra2 =  mock(Muestra.class);

        //Añado a la lista
        muestras.add(muestra1);
        muestras.add(muestra2);

        //Critertio a ver (SUT)
        criterioDeInsectos = new CriterioTipoDeInsecto();
    }

    @Test
    void realizarBusqueda() {

        //Armo el resultado
        ArrayList<Muestra> muestrasEsperadas = new ArrayList<Muestra>();
        muestrasEsperadas.add(muestra2);

        //Caso no querido
        TipoDeOpinion tipoDeOpinionNoQuerido = mock(TipoDeOpinion.class);

        //Respuestas del mock
        when(muestra1.getTipoVinchuca()).thenReturn(tipoDeOpinionNoQuerido);
        when(muestra2.getTipoVinchuca()).thenReturn(tipoDeOpinion);

        assertEquals(muestrasEsperadas,criterioDeInsectos.realizarBusqueda(fecha,tipoDeOpinion,tipoDeMuestra,muestras));
    }


}