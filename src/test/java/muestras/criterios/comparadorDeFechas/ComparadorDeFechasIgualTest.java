package test.java.muestras.criterios.comparadorDeFechas;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.muestras.criterios.comparadorDeFechas.ComparadorDeFechasIgual;

class ComparadorDeFechasIgualTest {
	ComparadorDeFechasIgual comparador;
	
	@BeforeEach
    void setUp() {
		comparador = new ComparadorDeFechasIgual();
	}
	
	@Test
	void compararEntreTest() {
		LocalDate fecha = LocalDate.of(2020, 10, 1);
		assertTrue(comparador.compararEntre(fecha, fecha));
	}

}
