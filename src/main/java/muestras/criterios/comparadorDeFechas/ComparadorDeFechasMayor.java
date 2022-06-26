package main.java.muestras.criterios.comparadorDeFechas;

import java.time.LocalDate;

public class ComparadorDeFechasMayor implements ComparadorDeFechas{
	
	public boolean compararEntre(LocalDate fechaA, LocalDate fechaB) {
		return fechaA.isBefore(fechaB);
	}
}
