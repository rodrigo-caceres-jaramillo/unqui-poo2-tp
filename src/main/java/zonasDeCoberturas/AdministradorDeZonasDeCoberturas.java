package zonasDeCoberturas;

import muestras.Muestra;

import java.util.ArrayList;

public class AdministradorDeZonasDeCoberturas {

    private ArrayList<ZonaDeCobertura> todasLasZonas;

    public AdministradorDeZonasDeCoberturas(ArrayList<ZonaDeCobertura> zonasExistentes){
        this.setTodasLasZonas(zonasExistentes);
    }

    public void setTodasLasZonas(ArrayList<ZonaDeCobertura> zonas){
        todasLasZonas = zonas;
    }

    public ArrayList<ZonaDeCobertura> getTodasLasZonas(){
        return todasLasZonas;
    }


    public void actualizarZonasConNuevaMuestra(Muestra muestraAAgregar){
        this.getTodasLasZonas().stream().forEach(zona -> zona.agregarMuestraSiPerteneceALaZona(muestraAAgregar));
    }

    public void agregarNuevaZona(ZonaDeCobertura nuevaZona){
        todasLasZonas.add(nuevaZona);
    }

}
