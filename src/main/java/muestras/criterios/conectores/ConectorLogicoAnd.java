package main.java.muestras.criterios.conectores;

import java.util.ArrayList;
import java.util.List;

import main.java.muestras.Muestra;

public class ConectorLogicoAnd implements ConectorLogico{

    public List<Muestra> conectarArray(List<Muestra> xs, List<Muestra> ys){
        List<Muestra> muestrasEnComun = new ArrayList<main.java.muestras.Muestra>();
        for (int i = 0; i < ys.size(); i++) {
            if(xs.contains(ys.get(i)) && ! muestrasEnComun.contains(ys.get(i))){
                muestrasEnComun.add(ys.get(i));
            }
        }
        return muestrasEnComun;
    }
}
