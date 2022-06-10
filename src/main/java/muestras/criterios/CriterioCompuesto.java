package main.java.muestras.Criterios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.TipoDeMuestra;
import muestras.criterios.conectores.ConectorLogico;
import main.java.muestras.Criterios.Criterio;

public class CriterioCompuesto implements Criterio {
    private ConectorLogico conector;
    private Criterio criterio1;
    private Criterio criterio2;

    public CriterioCompuesto(ConectorLogico conectorAPoner, Criterio criterioAponer, Criterio criterioAponerTambien) {
        conector = conectorAPoner;
        criterio1 = criterioAponer;
        criterio2 = criterioAponerTambien;
    }

    public ConectorLogico getConector() {
        return conector;
    }


    @Override
    public ArrayList<Muestra> realizarBusqueda(LocalDate fechaABuscar, TipoDeOpinion opinionABuscar, TipoDeMuestra tipoABuscar, ArrayList<Muestra> muestras) {
        ArrayList<Muestra> resultadoDelCriterio1 = criterio1.realizarBusqueda(fechaABuscar, opinionABuscar, tipoABuscar, muestras);
        ArrayList<Muestra> resultadoDelCriterio2 = criterio1.realizarBusqueda(fechaABuscar, opinionABuscar, tipoABuscar, muestras);
        return conector.conectarArray(resultadoDelCriterio1,resultadoDelCriterio2);
    }

}