package muestras.Criterios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CriterioNivelDeVerificacion extends Criterio{

    @Override
    public ArrayList<Muestra> realizarBusqueda(LocalDate fechaABuscar, TipoDeOpinion opinionABuscar, TipoDeMuestra tipoABuscar, ArrayList<Muestra> muestras) {
        return muestras.stream().filter(m-> m.getTipo() == tipoABuscar).collect(Collectors.toList());
    }

}
