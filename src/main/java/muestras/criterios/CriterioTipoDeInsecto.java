package main.java.muestras.criterios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;

public class CriterioTipoDeInsecto implements Criterio{
    private TipoDeOpinion tipoABuscar;

    public CriterioTipoDeInsecto(TipoDeOpinion opinionATenerEnCuenta) {
        tipoABuscar = opinionATenerEnCuenta;
    }

    public TipoDeOpinion getTipoABuscar(){
        return tipoABuscar;
    }

    @Override
    public List<Muestra> realizarBusqueda(ArrayList<Muestra> muestras){
    	List<Muestra> resultado = muestras.stream()
    			.filter(m-> m.getTipoVinchuca().equals(this.getTipoABuscar()))
    			.collect(Collectors.toList());
    	return resultado;
    }
}
