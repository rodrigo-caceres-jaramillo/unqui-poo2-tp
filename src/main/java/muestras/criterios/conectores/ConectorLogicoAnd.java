package main.java.muestras.criterios.conectores;

import java.util.ArrayList;
import main.java.muestras.Muestra;

public class ConectorLogicoAnd implements ConectorLogico{

    public ArrayList<Muestra> conectarArray(ArrayList<Muestra> xs, ArrayList<Muestra> ys){
        ArrayList<Muestra> muestrasEnComun = new ArrayList<main.java.muestras.Muestra>();
        for (int i = 0; i < ys.size(); i++) {
            if(xs.contains(ys.get(i)) && ! muestrasEnComun.contains(ys.get(i))){
                muestrasEnComun.add(xs.get(i));
            }
        }
        return muestrasEnComun;
    }
}
