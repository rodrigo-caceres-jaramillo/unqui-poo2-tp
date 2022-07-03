package test.java.muestras.criterios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.java.muestras.criterios.CriterioFechaUltimaVotacion;
import main.java.muestras.criterios.comparadorDeFechas.ComparadorDeFechas;
import main.java.muestras.TipoDeOpinion;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import main.java.muestras.Muestra;
import main.java.muestras.tipos.TipoDeMuestra;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CriterioFechaUltimaVotacionTest {
    CriterioFechaUltimaVotacion criterioFechaUltimaVotacion;
    ComparadorDeFechas comparador;
    LocalDate fecha;
    LocalDate f1;
    TipoDeOpinion tipoDeOpinion;
    TipoDeMuestra tipoDeMuestra;
    ArrayList<Muestra> muestras;
    Muestra muestra1;
    Muestra muestra2;

    @BeforeEach
    void setUp() {
        //Mocks
    	comparador = mock(ComparadorDeFechas.class);
    	tipoDeOpinion = TipoDeOpinion.ChincheFoliada;
        tipoDeMuestra = mock(TipoDeMuestra.class);

        fecha = LocalDate.of(2020, Month.APRIL, 10);
        f1 = LocalDate.of(2010, Month.APRIL, 10);
        
        muestras = new ArrayList<Muestra>();
        muestra1 =  mock(Muestra.class);
        muestra2 =  mock(Muestra.class);

        //Añado a la lista
        muestras.add(muestra1);
        muestras.add(muestra2);

        //Critertio a ver (SUT)
        criterioFechaUltimaVotacion = new CriterioFechaUltimaVotacion(comparador, fecha);
    }

    @Test
    void realizarBusqueda() {
        //Armo el resultado
        List<Muestra> muestrasEsperadas = new ArrayList<Muestra>();
        muestrasEsperadas.add(muestra1);

        //Caso no querido
        TipoDeMuestra tipoDeMuestraNoQuerido = mock(TipoDeMuestra.class);

        //Respuestas del mock
        when(muestra1.getUltimaVotacion()).thenReturn(f1);
        when(muestra2.getUltimaVotacion()).thenReturn(fecha);
        when(comparador.compararEntre(f1, fecha)).thenReturn(true);

        assertEquals(muestrasEsperadas,criterioFechaUltimaVotacion.realizarBusqueda(muestras));
    }
}