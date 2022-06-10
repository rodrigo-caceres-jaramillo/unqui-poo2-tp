package muestras.Criterios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CriterioTipoDeInsecto extends Criterio{

    @Override
    public ArrayList<Muestra> realizarBusqueda(LocalDate fechaABuscar, TipoDeOpinion opinionABuscar, TipoDeMuestra tipoABuscar, ArrayList<Muestra> muestras) {
        return muestras.stream().filter(m-> m.getTipoVinchuca() == tipoABuscar).collect(Collectors.toList());
    }
}
