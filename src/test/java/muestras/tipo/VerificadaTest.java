package test.java.muestras.tipo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.tipos.Verificada;

class VerificadaTest {
	Verificada tipoVerificada;
	Muestra muestra;
	Opinion opinion;
	
	@BeforeEach
    void setUp() {
		muestra = mock(Muestra.class);
		opinion = mock(Opinion.class);
		tipoVerificada = new Verificada();
	}
	
	@Test
	void agregarOpinionATest() {
		tipoVerificada.agregarOpinionA(opinion, muestra);
		verify(muestra, never()).getOpiniones();
	}

}
