package main.java.muestras.criterios;

import java.util.ArrayList;
import java.util.List;

import main.java.muestras.Muestra;
import main.java.muestras.criterios.conectores.ConectorLogico;

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
        return this.conector;
    }
    
    public Criterio getCriterio1() {
    	return this.criterio1;
    }
    
    public Criterio getCriterio2() {
    	return this.criterio2;
    }

    @Override
    public List<Muestra> realizarBusqueda(ArrayList<Muestra> muestras) { // public ArrayList<Muestra> realizarBusqueda(ArrayList<Muestra> muestras)
        List<Muestra> resultadoDelCriterio1 = this.getCriterio1().realizarBusqueda(muestras); // ArrayList<Muestra> resultadoDelCriterio1
        List<Muestra> resultadoDelCriterio2 = this.getCriterio2().realizarBusqueda(muestras); // ArrayList<Muestra> resultadoDelCriterio2
        return this.getConector().conectarArray(resultadoDelCriterio1,resultadoDelCriterio2);
    }

}