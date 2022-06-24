package main.java.muestras.criterios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.TipoDeMuestra;

public class CriterioNivelDeVerificacion implements Criterio{

    private TipoDeMuestra tipoABuscar;

    public CriterioNivelDeVerificacion(TipoDeMuestra tipoATenerEnCuenta) {
        tipoABuscar = tipoATenerEnCuenta;
    }

    public TipoDeMuestra getTipoABuscar(){
        return tipoABuscar;
    }

    @Override
    public ArrayList<Muestra> realizarBusqueda(TipoDeMuestra tipoABuscar, ArrayList<Muestra> muestras) {
        return (ArrayList<Muestra>) muestras.stream().filter(m-> m.getTipo() == this.getTipoABuscar() ).collect(Collectors.toList()); // cambiar == por equals
    }
}
