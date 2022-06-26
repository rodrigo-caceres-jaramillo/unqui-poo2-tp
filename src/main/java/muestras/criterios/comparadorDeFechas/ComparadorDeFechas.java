package main.java.muestras.criterios.comparadorDeFechas;

import java.time.LocalDate;

public interface ComparadorDeFechas {

	boolean compararEntre(LocalDate ultimaVotacion, LocalDate fecha);
}
