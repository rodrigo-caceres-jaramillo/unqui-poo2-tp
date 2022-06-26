package main.java.muestras.criterios.comparadorDeFechas;

import java.time.LocalDate;

public class ComparadorDeFechasIgual implements ComparadorDeFechas{

	@Override
	public boolean compararEntre(LocalDate fechaA, LocalDate fechaB) {
		return fechaA.equals(fechaB);
	}

}
