package zonasDeCoberturas;

import muestras.Muestra;
import organizaciones.OrganizacioneNoGubernamental;
import ubicacciones.CalculadorDeDistancias;
import ubicacciones.Ubicacion;
import organizaciones.FuncionExterna;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCobertura {
    private String nombre;
    private Ubicacion epicentro;
    private float radio;
    private List<Muestra> muestrasEnLaZona;
    private List<OrganizacioneNoGubernamental> organizacionesInteresadas;

    public ZonaDeCobertura(String nombreNuevo,Ubicacion epicentroAPoner, float radioAPoner,ArrayList<Muestra> muestras, List<OrganizacioneNoGubernamental> orgsInteresadas ){
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

    public float getRadio() {
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

   public void avisarALasOrganizacionesQueSeValidoLaMuestraNumero(Integer id){
        int indice = 0;
        for(int i=0; this.getMuestrasEnLaZona().get(i).getId() != id && this.getMuestrasEnLaZona().size() > i;i++){
            indice++;
        }
       Muestra muestraQueSeValido = this.getMuestrasEnLaZona().get(indice);
       this.getOrganizacionesInteresadas().stream().forEach(o-> o.seValidoUnaMuestra(this,muestraQueSeValido));
   }





}

