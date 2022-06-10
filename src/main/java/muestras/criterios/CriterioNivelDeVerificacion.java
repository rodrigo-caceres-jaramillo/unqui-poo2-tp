package main.java.muestras.Criterios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.TipoDeMuestra;

public class CriterioNivelDeVerificacion implements Criterio{

    @Override
    public ArrayList<Muestra> realizarBusqueda(LocalDate fechaABuscar, TipoDeOpinion opinionABuscar, TipoDeMuestra tipoABuscar, ArrayList<Muestra> muestras) {
        return (ArrayList<Muestra>) muestras.stream().filter(m-> m.getTipo() == tipoABuscar).collect(Collectors.toList());
    }
}
