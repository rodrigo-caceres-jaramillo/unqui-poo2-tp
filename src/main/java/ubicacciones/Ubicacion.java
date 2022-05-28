package main.java.ubicacciones;

import main.java.muestras.Muestra;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Ubicacion  {
    private int longitud;
    private int latitud;
    private CalculadorDeDistancias calculador;

    public Ubicacion(int nuevaLongitud, int nuevaLatitud){
        longitud = nuevaLongitud;
        latitud  = nuevaLatitud ;
        calculador = calculador.getInstancia();
    }

    public int getLongitud(){return longitud;}

    public int getLatitud(){return latitud;}

    public int distanciaEntre(Ubicacion ubicacionAVer){
        CalculadorDeDistancias calculador = new CalculadorDeDistancias();
        return  calculador.distanciaEntreLasUbicaciones(this,ubicacionAVer);
    }
    public List<Ubicacion> ubicacionesAMenosDe(ArrayList<Ubicacion> ubicaciones, int metros){
        CalculadorDeDistancias calculador = new CalculadorDeDistancias();
        return  ubicaciones.stream().
                filter(u->calculador.distanciaEntreLasUbicaciones(this,u) <= metros).
                collect(Collectors.toList()) ;
    }

    /*
    public List<Muestra> muestrasAMenosDeDesde(int metros,Muestra muestraAVer){
        CalculadorDeDistancias calculador = new CalculadorDeDistancias();
        return muestraAVer.getCollectorMuestras().stream().
                filter(m->calculador.distanciaEntreLasUbicaciones(m.getUbicacion(),muestraAVer.getUbicacion()) <= metros).
                collect(Collectors.toList()) ;
    }
   */
}
