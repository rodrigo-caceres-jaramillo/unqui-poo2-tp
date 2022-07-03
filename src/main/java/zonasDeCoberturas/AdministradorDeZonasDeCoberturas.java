package main.java.zonasDeCoberturas;

import main.java.muestras.Muestra;
import main.java.organizaciones.OrganizacioneNoGubernamental;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdministradorDeZonasDeCoberturas {
    private ArrayList<ZonaDeCobertura> todasLasZonas;
 
    // Constructor
    public AdministradorDeZonasDeCoberturas(ArrayList<ZonaDeCobertura> zonasExistentes){
        this.setTodasLasZonas(zonasExistentes);
    }
    
    // Gets y sets
    public void setTodasLasZonas(ArrayList<ZonaDeCobertura> zonas){
        todasLasZonas = zonas;
    }

    public ArrayList<ZonaDeCobertura> getTodasLasZonas(){
        return todasLasZonas;
    }

    // Metodos
    public void actualizarZonasConNuevaMuestra(Muestra muestraAAgregar){
        this.getTodasLasZonas().stream().forEach(zona -> zona.agregarMuestraSiPerteneceALaZona(muestraAAgregar));
    }

    public void agregarNuevaZona(ZonaDeCobertura nuevaZona){
        todasLasZonas.add(nuevaZona);
    }

    public List<ZonaDeCobertura> zonasQueSolapaCon(ZonaDeCobertura zonaAVer) {
        return this.getTodasLasZonas().stream().
                filter(zona -> zona.estaSolapadaCon(zonaAVer)).collect(Collectors.toList());
    }

    public List<ZonaDeCobertura> zonasDeInteresDeLaOrg(OrganizacioneNoGubernamental orgAVer){
        return this.getTodasLasZonas().stream().
                filter(z -> z.laOrganizacioEstaInteresadaEnEstaZona(orgAVer)).collect(Collectors.toList());
    }

    public void avisarALasOrganizacionesQueSeValidoLaMuestraNumero(Muestra muestra){
        this.getTodasLasZonas().stream().
                forEach(z->z.avisarALasOrganizacionesQueSeValidoLaMuestraNumero(muestra));
    }

}
