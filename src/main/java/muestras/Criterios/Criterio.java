package muestras.Criterios;

import java.time.LocalDate;
import java.util.ArrayList;
import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.TipoDeMuestra;

public interface Criterio {

    public ArrayList<Muestra> realizarBusqueda (LocalDate fechaABuscar, TipoDeOpinion opinionABuscar, TipoDeMuestra tipoABuscar,ArrayList<Muestra>  muestras);
}
