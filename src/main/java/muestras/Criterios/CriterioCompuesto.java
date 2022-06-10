package muestras.Criterios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CriterioCompuesto extends Criterio{
    private String conector;
    private Criterio criterio1;
    private Criterio criterio2;

    public CriterioCompuesto(String conectorAPoner,Criterio criterioAponer, Criterio criterioAponerTambien){
        conector = conectorAPoner;
        criterio1 = criterioAponer;
        criterio2 = criterioAponerTambien;
    }

    public String getConector(){
        return conector;
    }


    @Override
    public ArrayList<Muestra> realizarBusqueda(LocalDate fechaABuscar, TipoDeOpinion opinionABuscar, TipoDeMuestra tipoABuscar, ArrayList<Muestra> muestras) {
        ArrayList<Muestra> resultadoDelCriterio1 = criterio1.realizarBusqueda(fechaABuscar,opinionABuscar,tipoABuscar,muestras);
        ArrayList<Muestra> resultadoDelCriterio2 = criterio1.realizarBusqueda(fechaABuscar,opinionABuscar,tipoABuscar,muestras);
        if(this.getConector() == "or"){
           return this.añadirAtodosDelSinRepetir(resultadoDelCriterio1,resultadoDelCriterio2);
       }else{
           return this.comuneEntre(resultadoDelCriterio2,resultadoDelCriterio1);
       }
    }

    public ArrayList<Muestra> añadirAtodosDelSinRepetir(ArrayList<Muestra> xs , ArrayList<Muestra> ys){
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

    public  ArrayList<Muestra> comuneEntre (ArrayList<Muestra> xs , ArrayList<Muestra> ys) {

        ArrayList<Muestra> muestrasEnComun = new ArrayList<Muestra>();
        for (int i = 0; i < ys.size(); i++) {
            if(xs.contains(ys.get(i))){
                muestrasEnComun.add(xs.get(i));
            }
        }
        return muestrasEnComun;
    }
}
