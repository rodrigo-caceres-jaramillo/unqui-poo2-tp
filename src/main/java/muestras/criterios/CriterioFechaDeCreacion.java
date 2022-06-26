package main.java.muestras.criterios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.muestras.Muestra;
import main.java.muestras.criterios.comparadorDeFechas.ComparadorDeFechas;

public class CriterioFechaDeCreacion implements Criterio{
    private LocalDate fecha;
    private ComparadorDeFechas comparador;

    public CriterioFechaDeCreacion(ComparadorDeFechas comparador, LocalDate fechaAver) {
        this.comparador = comparador;
    	this.fecha = fechaAver;
    }

    public LocalDate getFecha(){
        return this.fecha;
    }
    
    public ComparadorDeFechas getComparador() {
    	return this.comparador;
    }

    @Override
    public ArrayList<Muestra> realizarBusqueda(ArrayList<Muestra> muestras) {
    	ArrayList<Muestra> resultado = (ArrayList<Muestra>) muestras.stream()
				.filter(m -> comparador.compararEntre(m.getCreacion(), fecha))
				.collect(Collectors.toList());
		return resultado;
    }
}
