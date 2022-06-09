package main.java.organizaciones;

import main.java.muestras.Muestra;
import main.java.ubicacciones.Ubicacion;
import main.java.zonasDeCoberturas.ZonaDeCobertura;

public class OrganizacioneNoGubernamental {

    private Ubicacion ubicacionDeLaOrg;
    private TipoDeOrganizacion tipo;
    private int cantidadDeTrabajadores;
    private FuncionExterna funcionNuevaMuestra;
    private FuncionExterna funcionValidacion;

    public OrganizacioneNoGubernamental(Ubicacion ubicacionAPoner, TipoDeOrganizacion tipoDeLaOrg, int cantidadDeTrabajadoresAPoner,FuncionExterna funNuevaMuestra,FuncionExterna funValidacion){
        ubicacionDeLaOrg = ubicacionAPoner;
        tipo = tipoDeLaOrg;
        cantidadDeTrabajadores = cantidadDeTrabajadoresAPoner;
        funcionNuevaMuestra = funNuevaMuestra;
        funcionValidacion = funValidacion;
    }

    public FuncionExterna getFuncionNuevaMuestra(){
        return funcionNuevaMuestra;
    }

    public FuncionExterna getFuncionValidacion(){
        return funcionValidacion;
    }

    public void seRegistroNuevaMuestra(ZonaDeCobertura zona, Muestra muestra){
        this.getFuncionNuevaMuestra().nuevoEvento(this,zona,muestra);
    }

    public void seValidoUnaMuestra(ZonaDeCobertura zona, Muestra muestra){
        this.getFuncionValidacion().nuevoEvento(this,zona,muestra);
    }

}
