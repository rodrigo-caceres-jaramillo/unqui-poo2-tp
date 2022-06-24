package main.java.muestras.criterios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.TipoDeMuestra;

public class CriterioTipoDeInsecto implements Criterio{

    private TipoDeOpinion opinionABuscar;

    public CriterioNivelDeVerificacion(TipoDeOpinion opinionATenerEnCuenta) {
        opinionABuscar = opinionATenerEnCuenta;
    }

    public TipoDeOpinion getTipoABuscar(){
        return opinionABuscar;
    }

    @Override
    public ArrayList<Muestra> realizarBusqueda(ArrayList<Muestra> muestras) {
        return (ArrayList<Muestra>) muestras.stream().filter(m-> m.getTipoVinchuca() == this.getTipoABuscar()).collect(Collectors.toList()); // cambiar == por equals
    }
}
