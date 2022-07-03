package main.java.muestras.criterios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import main.java.muestras.Muestra;
import main.java.muestras.tipos.TipoDeMuestra;

public class CriterioNivelDeVerificacion implements Criterio{
    private TipoDeMuestra tipoABuscar;

    public CriterioNivelDeVerificacion(TipoDeMuestra tipoATenerEnCuenta) {
        this.tipoABuscar = tipoATenerEnCuenta;
    }

    public TipoDeMuestra getTipoABuscar(){
        return this.tipoABuscar;
    }

    @Override
    public List<Muestra> realizarBusqueda(ArrayList<Muestra> muestras){
    	List<Muestra> resultado = muestras.stream()
    			.filter(m-> m.getTipo().equals(this.getTipoABuscar()))
    			.collect(Collectors.toList());
    	return resultado;
    }
}
