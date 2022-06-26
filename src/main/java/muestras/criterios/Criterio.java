package main.java.muestras.criterios;

import java.util.ArrayList;
import main.java.muestras.Muestra;

public interface Criterio {
    public ArrayList<Muestra> realizarBusqueda (ArrayList<Muestra>  muestras);
}
