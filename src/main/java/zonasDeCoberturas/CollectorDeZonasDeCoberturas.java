package zonasDeCoberturas;

import java.util.ArrayList;

public class CollectorDeZonasDeCoberturas {

    private ArrayList<ZonaDeCobertura> todasLasZonas;

    public CollectorDeZonasDeCoberturas(ArrayList<ZonaDeCobertura> zonasExistentes){
        this.setTodasLasZonas(zonasExistentes);
    }

    public void setTodasLasZonas(ArrayList<ZonaDeCobertura> zonas){
        todasLasZonas = zonas;
    }

    public ArrayList<ZonaDeCobertura> getTodasLasZonas(){
        return todasLasZonas;
    }

    public void registrarNuevaZona(ZonaDeCobertura nuevaZona){   //Agregar una nueva zona y le agrega las zonas solapadas
        this.getTodasLasZonas().stream().forEach(zona -> zona.agregarSiEsZonaSolapada(nuevaZona)); // Agrega la nueva zona en las zonas viejas si solapan
        this.getTodasLasZonas().stream().forEach(zona -> nuevaZona.agregarSiEsZonaSolapada(zona)); // Agrega las zonas viejas en la nueva zona si solapan
        // seria bueno hacerlo en una sola linea

        this.agregarNuevaZona(nuevaZona);
    }

    public void agregarNuevaZona(ZonaDeCobertura nuevaZona){
        todasLasZonas.add(nuevaZona);
    }

}
