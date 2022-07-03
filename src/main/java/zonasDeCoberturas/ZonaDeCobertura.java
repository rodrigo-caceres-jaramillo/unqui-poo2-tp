package main.java.zonasDeCoberturas;

import java.util.ArrayList;
import java.util.List;

import main.java.muestras.Muestra;
import main.java.organizaciones.OrganizacioneNoGubernamental;
import main.java.ubicacciones.Ubicacion;

public class ZonaDeCobertura {
    private String nombre;
    private Ubicacion epicentro;
    private float radio;
    private List<Muestra> muestrasEnLaZona;
    private List<OrganizacioneNoGubernamental> organizacionesInteresadas;
 
    // Constructor
    public ZonaDeCobertura(String nombreNuevo,Ubicacion epicentroAPoner, float radioAPoner,ArrayList<Muestra> muestras, List<OrganizacioneNoGubernamental> orgsInteresadas ){
        nombre          = nombreNuevo;
        epicentro       = epicentroAPoner;
        radio           = radioAPoner;
        muestrasEnLaZona = muestras;
        organizacionesInteresadas = orgsInteresadas;
    }

    // Gets y sets
    public List<OrganizacioneNoGubernamental> getOrganizacionesInteresadas(){
    	return organizacionesInteresadas;
    }

    public Ubicacion getEpicentro(){
        return  epicentro;
    }

    public String getNombre() {
        return nombre;
    }

    public float getRadio() {
        return radio;
    }


    public List<Muestra> getMuestrasEnLaZona(){
    	return muestrasEnLaZona;
    }

    // Metodos
    public boolean estaSolapadaCon(ZonaDeCobertura zonaAVer){
           return  this.zonaChocaCon(zonaAVer)      || 
                   this.zonaEstaAdentroDe(zonaAVer) ;
    }

    public boolean zonaEstaAdentroDe(ZonaDeCobertura zonaAVer){
        return  this.getEpicentro().distanciaEntre(zonaAVer.getEpicentro()) <
                Math.max(this.getRadio(),zonaAVer.getRadio()) - Math.min(this.getRadio(),zonaAVer.getRadio());
    }

    public boolean zonaChocaCon(ZonaDeCobertura zonaAVer){
        return this.getEpicentro().distanciaEntre(zonaAVer.getEpicentro()) < this.getRadio() + zonaAVer.getRadio();
    }

    public boolean esLaMismaZona(ZonaDeCobertura zonaAAgregar){
        return this.getRadio()     == zonaAAgregar.getRadio()     &&
               this.getEpicentro() == zonaAAgregar.getEpicentro() ;
    }

   public void agregarMuestra(Muestra muestraAVer){
       this.getMuestrasEnLaZona().add(muestraAVer);
    }

   public void agregarMuestraSiPerteneceALaZona(Muestra muestraAVer){
       float distancia = this.epicentro.distanciaEntre(muestraAVer.getUbicacion());
       if(distancia <= this.getRadio()){
           this.avisarALasOrganizacionesQueSeRegistroNuevaMuestra(muestraAVer);
           this.agregarMuestra(muestraAVer);
       }
   }

   public void avisarALasOrganizacionesQueSeRegistroNuevaMuestra(Muestra muestra){
        this.getOrganizacionesInteresadas().stream().forEach(o -> o.seRegistroNuevaMuestra(this,muestra));
   }

   public boolean laOrganizacioEstaInteresadaEnEstaZona(OrganizacioneNoGubernamental org){
        return this.getOrganizacionesInteresadas().contains(org);
   }

   public void avisarALasOrganizacionesQueSeValidoLaMuestraNumero(Muestra muestra){
       this.getOrganizacionesInteresadas().stream().forEach(o-> o.seValidoUnaMuestra(this,muestra));
   }

  public void agregarOrganizacionInterezada(OrganizacioneNoGubernamental org){
        this.getOrganizacionesInteresadas().add(org);
  }

  //Precondicion debe existir la organizacion a remover
  public void eliminarOrganizacionQueSeDejoDeInterezar(OrganizacioneNoGubernamental org){
        this.getOrganizacionesInteresadas().remove(org);
  }

}

