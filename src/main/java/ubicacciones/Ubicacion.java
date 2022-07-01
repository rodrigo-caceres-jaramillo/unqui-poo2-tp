package main.java.ubicacciones;

import main.java.muestras.Muestra;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Ubicacion  {
    private float longitud;
    private float latitud;
    private CalculadorDeDistancias calculador;

    public Ubicacion(float nuevaLongitud, float nuevaLatitud){
        longitud = nuevaLongitud;
        latitud  = nuevaLatitud ;
        calculador = calculador.getInstancia();
    }

    public float getLongitud(){return longitud;}

    public float getLatitud(){return latitud;}

    public float distanciaEntre(Ubicacion ubicacionAVer){
        return  calculador.distanciaEntreLasUbicaciones(this,ubicacionAVer);
    }
    public List<Ubicacion> ubicacionesAMenosDe(ArrayList<Ubicacion> ubicaciones, int metros){
        return  ubicaciones.stream().
                filter(u->calculador.distanciaEntreLasUbicaciones(this,u) <= metros).
                collect(Collectors.toList()) ;
    }

}
