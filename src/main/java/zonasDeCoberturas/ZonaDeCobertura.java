package zonasDeCoberturas;

import muestras.Muestra;
import ubicacciones.CalculadorDeDistancias;
import ubicacciones.Ubicacion;

import java.util.ArrayList;

public class ZonaDeCobertura {
    private String nombre;
    private Ubicacion epicentro;
    private int radio;
    private ArrayList<Muestra> muestrasEnLaZona;
    private ArrayList<ZonaDeCobertura> zonasSolapadas;

    public ZonaDeCobertura(String nombreNuevo,Ubicacion epicentroAPoner, int radioAPoner,ArrayList<Muestra> muestras, ArrayList<ZonaDeCobertura> zonas ){
        nombre          = nombreNuevo;
        epicentro       = epicentroAPoner;
        radio           = radioAPoner;
        muestrasEnLaZona = muestras;
        zonasSolapadas  = zonas;
    }

    public Ubicacion getEpicentro(){
        return  epicentro;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRadio() {
        return radio;
    }

    public ArrayList<ZonaDeCobertura> getZonasSolapadas() {
        return zonasSolapadas;
    }

    public ArrayList<Muestra> getMuestrasEnLaZona(){return muestrasEnLaZona;}


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

    public void agregarSiEsZonaSolapada(ZonaDeCobertura zonaAAgregar){  // si no esta solapada no hace nada
        if(this.estaSolapadaCon(zonaAAgregar) && ! this.esLaMismaZona(zonaAAgregar) ){   // una zona no puede tener a si misma en zonas solapadas
           this.getZonasSolapadas().add(zonaAAgregar);
        }
    }

    public boolean esLaMismaZona(ZonaDeCobertura zonaAAgregar){
        return this.getRadio()     == zonaAAgregar.getRadio()     &&
               this.getEpicentro() == zonaAAgregar.getEpicentro() ;
    }

   public void agregarMuestra(Muestra muestraAVer){
       this.getMuestrasEnLaZona().add(muestraAVer);
    }

}
