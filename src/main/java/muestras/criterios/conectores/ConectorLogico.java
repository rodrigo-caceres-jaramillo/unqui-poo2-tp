package muestras.criterios.conectores;

import java.util.ArrayList;
import main.java.muestras.Muestra;

public interface ConectorLogico {

    public ArrayList<Muestra> conectarArray(ArrayList<Muestra> xs, ArrayList<Muestra> ys);
}
