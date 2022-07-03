package main.java.muestras.criterios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import main.java.muestras.Muestra;
import main.java.muestras.criterios.comparadorDeFechas.ComparadorDeFechas;

public class CriterioFechaUltimaVotacion implements Criterio{
	private LocalDate fecha;
	private ComparadorDeFechas comparador;
	
    public CriterioFechaUltimaVotacion(ComparadorDeFechas comparador, LocalDate fecha) {
    	this.comparador = comparador;
    	this.fecha = fecha;	
    }
    
    public LocalDate getFecha() {
    	return this.fecha;
    }
    
    public ComparadorDeFechas getComparador() {
    	return this.comparador;
    }

	@Override
	public List<Muestra> realizarBusqueda(ArrayList<Muestra> muestras) { // public ArrayList<Muestra> realizarBusqueda(ArrayList<Muestra> muestras)
		ArrayList<Muestra> resultado = (ArrayList<Muestra>) muestras.stream()
				.filter(m -> comparador.compararEntre(m.getUltimaVotacion(), fecha))
				.collect(Collectors.toList());
		return resultado;
	}
}



