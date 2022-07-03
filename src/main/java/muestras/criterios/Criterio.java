package main.java.muestras.criterios;

import java.util.ArrayList;
import java.util.List;

import main.java.muestras.Muestra;

public interface Criterio {
    public List<Muestra> realizarBusqueda(ArrayList<Muestra> muestras); //public ArrayList<Muestra> realizarBusqueda (ArrayList<Muestra>  muestras);
}
