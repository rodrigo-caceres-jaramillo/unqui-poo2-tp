package main.java.muestras.Criterios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.TipoDeMuestra;


public class CriterioFechaUltimaVotacion implements Criterio{

    @Override
    public ArrayList<Muestra> realizarBusqueda(LocalDate fechaABuscar, TipoDeOpinion opinionABuscar, TipoDeMuestra tipoABuscar, ArrayList<Muestra> muestras) {
        LocalDate ultFecha = muestras.get(0).getUltimaVotacion();
        for(int i =0;i<muestras.size();i++){
            ultFecha = this.ultimaFechaEntre(ultFecha,muestras.get(i).getUltimaVotacion()) ;
        }
        final LocalDate f = ultFecha;
        return muestras.stream().filter(m-> m.getUltimaVotacion().equals(f)).collect(Collectors.toList());
    }

    public LocalDate ultimaFechaEntre(LocalDate d1, LocalDate d2){
        if(d1.isAfter(d2)){
            return d1;
        }else{
            return d2;
        }
    }

}



