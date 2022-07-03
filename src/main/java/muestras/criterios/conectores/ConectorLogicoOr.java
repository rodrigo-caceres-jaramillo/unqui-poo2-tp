package main.java.muestras.criterios.conectores;

import java.util.List;

import main.java.muestras.Muestra;

public class ConectorLogicoOr implements ConectorLogico{

    public List<Muestra> conectarArray(List<Muestra> xs, List<Muestra> ys){
        for(int i = 0;i<ys.size();i++){
            this.añadirSiNoEsta(xs,ys.get(i));
        }
        return xs;
    }

    public void añadirSiNoEsta(List<Muestra> array,Muestra m){
        if(! array.contains(m)){
            array.add(m);
        }
    }
}


