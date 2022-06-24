package main.java.muestras.criterios;

import java.time.LocalDate;
import java.util.ArrayList;
import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.TipoDeMuestra;

public interface Criterio {
    public ArrayList<Muestra> realizarBusqueda (ArrayList<Muestra>  muestras);
}
