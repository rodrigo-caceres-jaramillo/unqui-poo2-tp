package test.java.muestras.criterios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import main.java.muestras.criterios.CriterioTipoDeInsecto;
import main.java.muestras.TipoDeOpinion;
import java.time.LocalDate;
import java.util.ArrayList;
import main.java.muestras.Muestra;
import main.java.muestras.tipos.TipoDeMuestra;
import org.mockito.Mock;

class CriterioTipoDeInsectoTest {
    CriterioTipoDeInsecto criterioDeInsectos;
    LocalDate fecha;
    TipoDeOpinion tipoDeInsecto;
    TipoDeMuestra tipoDeMuestra;
    ArrayList<Muestra> muestras;
    Muestra muestra1;
    Muestra muestra2;

    @BeforeEach
    void setUp() {
        //Mocks
        tipoDeInsecto = TipoDeOpinion.ChincheFoliada;
        tipoDeMuestra = mock(TipoDeMuestra.class);
        muestra1 =  mock(Muestra.class);
        muestra2 =  mock(Muestra.class);

        //Añado a la lista
        muestras = new ArrayList<Muestra>();
        muestras.add(muestra1);
        muestras.add(muestra2);

        //Critertio a ver (SUT)
        criterioDeInsectos = new CriterioTipoDeInsecto(tipoDeInsecto);
    }

    @Test
    void realizarBusqueda() {
        //Armo el resultado
        ArrayList<Muestra> muestrasEsperadas = new ArrayList<Muestra>();
        muestrasEsperadas.add(muestra2);

        //Caso no querido
        TipoDeOpinion tipoDeInsectoNoQuerido = TipoDeOpinion.VinchucaGuasayana;

        //Respuestas del mock
        when(muestra1.getTipoVinchuca()).thenReturn(tipoDeInsectoNoQuerido);
        when(muestra2.getTipoVinchuca()).thenReturn(tipoDeInsecto);

        assertEquals(muestrasEsperadas,criterioDeInsectos.realizarBusqueda(muestras));
    }


}