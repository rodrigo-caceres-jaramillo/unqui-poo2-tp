package test.java.muestras.criterios.comparadorDeFechas;

import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.muestras.criterios.comparadorDeFechas.ComparadorDeFechasMayor;

class ComparadorDeFechasMayorTest {
	ComparadorDeFechasMayor comparador;
	
	@BeforeEach
    void setUp() {
		comparador = new ComparadorDeFechasMayor();
	}
	@Test
	void compararEntreTest() {
		LocalDate fechaMayor = LocalDate.of(2020, 10, 1);
		LocalDate fechaMenor = LocalDate.of(2000, 11, 20);
		assertTrue(comparador.compararEntre(fechaMenor, fechaMayor));
	}

}
