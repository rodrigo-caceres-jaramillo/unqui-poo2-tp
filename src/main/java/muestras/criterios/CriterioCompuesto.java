package main.java.muestras.criterios;

import java.time.LocalDate;
import java.util.ArrayList;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.criterios.conectores.ConectorLogico;
import main.java.muestras.tipos.TipoDeMuestra;

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
        ArrayList<Muestra> resultadoDelCriterio1 = criterio1.realizarBusqueda(muestras);
        ArrayList<Muestra> resultadoDelCriterio2 = criterio2.realizarBusqueda(muestras);
        return conector.conectarArray(resultadoDelCriterio1,resultadoDelCriterio2);
    }

}