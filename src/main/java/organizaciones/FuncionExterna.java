package main.java.organizaciones;


import main.java.muestras.Muestra;
import main.java.zonasDeCoberturas.ZonaDeCobertura;

public interface FuncionExterna {
    public Void nuevoEvento(OrganizacioneNoGubernamental organizacion, ZonaDeCobertura zona, Muestra muestra);
}
