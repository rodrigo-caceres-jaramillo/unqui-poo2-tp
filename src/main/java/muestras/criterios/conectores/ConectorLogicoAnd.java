package main.java.muestras.criterios.conectores;

import java.util.ArrayList;
import main.java.muestras.Muestra;

public class ConectorLogicoAnd implements ConectorLogico{

    public ArrayList<Muestra> conectarArray(ArrayList<Muestra> xs, ArrayList<Muestra> ys){
        for(int i = 0;i<ys.size();i++){
            this.añadirSiNoEsta(xs,ys.get(i));
        }
        return xs;
    }

    public void  añadirSiNoEsta(ArrayList<Muestra> array,Muestra m){
        if(! array.contains(m)){
            array.add(m);
        }
    }
}
