package muestras.Criterios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.TipoDeMuestra;


public class CriterioFechaUltimaVotacion extends Criterio{

    @Override
    public ArrayList<Muestra> realizarBusqueda(LocalDate fechaABuscar, TipoDeOpinion opinionABuscar, TipoDeMuestra tipoABuscar, ArrayList<Muestra> muestras) {
        LocalDate ultFecha = muestras.stream().max(m->m.getUltimaVotacion());
        return muestras.stream().filter(m-> m.getUltimaVotacion() == ultFecha).collect(Collectors.toList());
    }
}
