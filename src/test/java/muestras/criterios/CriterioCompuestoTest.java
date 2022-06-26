package test.java.muestras.criterios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.criterios.Criterio;
import main.java.muestras.criterios.CriterioCompuesto;
import main.java.muestras.criterios.conectores.ConectorLogico;
import main.java.muestras.tipos.TipoDeMuestra;

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
        tipoDeOpinion = TipoDeOpinion.ChincheFoliada;
        tipoDeMuestra = mock(TipoDeMuestra.class);

        fecha = LocalDate.of(2020, Month.APRIL, 10);

        muestras = new ArrayList<Muestra>();
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
    	criterioCompuesto.realizarBusqueda(muestras);
        //Verificar que le llega a criterios
        verify(c1).realizarBusqueda(muestras);
        verify(c2).realizarBusqueda(muestras);

        //Verificar que le llega a connector
        ArrayList<Muestra> resultadoc1 = new ArrayList<>();
        when(c1.realizarBusqueda(muestras)).thenReturn(resultadoc1);

        ArrayList<Muestra> resultadoc2 = new ArrayList<>();
        when(c2.realizarBusqueda(muestras)).thenReturn(resultadoc2);

        verify(conectorLogico).conectarArray(resultadoc1,resultadoc2);

        //Armo el resultado
        ArrayList<Muestra> resultado = new ArrayList<>();
        when(conectorLogico.conectarArray(resultadoc1,resultadoc2)).thenReturn(resultado);

        //Respuestas del mock
        assertEquals(resultado,criterioCompuesto.realizarBusqueda(muestras));
    }

}