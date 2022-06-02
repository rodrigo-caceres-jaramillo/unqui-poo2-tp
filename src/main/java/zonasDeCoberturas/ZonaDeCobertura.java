package main.java.zonasDeCoberturas;

import main.java.muestras.Muestra;
import main.java.organizaciones.OrganizacioneNoGubernamental;
import main.java.ubicacciones.CalculadorDeDistancias;
import main.java.ubicacciones.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCobertura {
    private String nombre;
    private Ubicacion epicentro;
    private int radio;
    private List<Muestra> muestrasEnLaZona;
    private List<OrganizacioneNoGubernamental> organizacionesInteresadas;

    public ZonaDeCobertura(String nombreNuevo,Ubicacion epicentroAPoner, int radioAPoner,ArrayList<Muestra> muestras, List<OrganizacioneNoGubernamental> orgsInteresadas ){
        nombre          = nombreNuevo;
        epicentro       = epicentroAPoner;
        radio           = radioAPoner;
        muestrasEnLaZona = muestras;
        organizacionesInteresadas = orgsInteresadas;
    }

    public List<OrganizacioneNoGubernamental> getOrganizacionesInteresadas(){return organizacionesInteresadas;}

    public Ubicacion getEpicentro(){
        return  epicentro;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRadio() {
        return radio;
    }


    public List<Muestra> getMuestrasEnLaZona(){return muestrasEnLaZona;}


    public boolean estaSolapadaCon(ZonaDeCobertura zonaAVer){
           return  this.zonaChocaCon(zonaAVer)      ||   // se fija si hay una intersepcion
                   this.zonaEstaAdentroDe(zonaAVer) ;    // se fija si uno de los 2 circuferencia esta dentro de la otra
    }

    public boolean zonaEstaAdentroDe(ZonaDeCobertura zonaAVer){
        //la distancia entre sus centros es menor que la diferencia de las longitudes de sus radios.
        return  this.getEpicentro().distanciaEntre(zonaAVer.getEpicentro()) <
                Math.max(this.getRadio(),zonaAVer.getRadio()) - Math.min(this.getRadio(),zonaAVer.getRadio());
    }

    public boolean zonaChocaCon(ZonaDeCobertura zonaAVer){
        return this.getEpicentro().distanciaEntre(zonaAVer.getEpicentro()) < this.getRadio() + zonaAVer.getRadio();
    }

    /*  Hacer desde sitio web le pregunte al Administrador de zonas que zonas solapan con y pasarla zona por parametro
    public void agregarSiEsZonaSolapada(ZonaDeCobertura zonaAAgregar){  // si no esta solapada no hace nada
        if(this.estaSolapadaCon(zonaAAgregar) && ! this.esLaMismaZona(zonaAAgregar) ){   // una zona no puede tener a si misma en zonas solapadas
           this.getZonasSolapadas().add(zonaAAgregar);
        }
    }
   */

    public boolean esLaMismaZona(ZonaDeCobertura zonaAAgregar){
        return this.getRadio()     == zonaAAgregar.getRadio()     &&
               this.getEpicentro() == zonaAAgregar.getEpicentro() ;
    }

   public void agregarMuestra(Muestra muestraAVer){
       this.getMuestrasEnLaZona().add(muestraAVer);
    }

   public void agregarMuestraSiPerteneceALaZona(Muestra muestraAVer){
       int distancia = this.epicentro.distanciaEntre(muestraAVer.getUbicacion());
       if(distancia <= this.getRadio()){
           // this.avisarALasOrganizaciones()
           this.getMuestrasEnLaZona().add(muestraAVer);
       }
   }

   public void avisarALasOrganizaciones(){
        this.getOrganizacionesInteresadas().stream().forEach(o -> o.funcionExterna());
   }

   public boolean laOrganizacioEstaInteresadaEnEstaZona(OrganizacioneNoGubernamental org){
        return this.getOrganizacionesInteresadas().contains(org);
   }

   public void avisarQueSeValidoLaMuestraMuestraNumero(Integer id){
        if(this.getMuestrasEnLaZona().stream().anyMatch(m-> m.getId().equals(id)) ){
            this.getOrganizacionesInteresadas().stream().forEach(o-> o.seValidoUnaMuestra());
        }
   }

    //
}
