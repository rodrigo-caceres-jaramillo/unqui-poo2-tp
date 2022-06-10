package muestras.criterios.conectores;

import java.util.ArrayList;

public class ConectorLogicoOr implements ConectorLogico{

    public ArrayList<main.java.muestras.Muestra> conectarArray(ArrayList<main.java.muestras.Muestra> xs, ArrayList<main.java.muestras.Muestra> ys){
        ArrayList<main.java.muestras.Muestra> muestrasEnComun = new ArrayList<main.java.muestras.Muestra>();
        for (int i = 0; i < ys.size(); i++) {
            if(xs.contains(ys.get(i)) && ! muestrasEnComun.contains(ys.get(i))){
                muestrasEnComun.add(xs.get(i));
            }
        }
        return muestrasEnComun;
    }

}
