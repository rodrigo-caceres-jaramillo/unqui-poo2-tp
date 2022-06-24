package main.java.muestras.criterios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.TipoDeMuestra;


public class CriterioFechaDeCreacion implements Criterio{
    private LocalDate fecha;

    public CriterioFechaDeCreacion(LocalDate fechaAver) {
        fecha = fechaAver;
    }

    public LocalDate getFecha(){
        return fecha;
    }

    @Override
    public ArrayList<Muestra> realizarBusqueda(ArrayList<Muestra> muestras) {
        return (ArrayList<Muestra>) muestras.stream().filter(m-> m.getCreacion() == this.getFecha() ).collect(Collectors.toList()); // sacar Stream del return
    }
}
