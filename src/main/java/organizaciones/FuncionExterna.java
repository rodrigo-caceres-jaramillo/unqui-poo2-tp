package organizaciones;


import muestras.Muestra;
import zonasDeCoberturas.ZonaDeCobertura;

public interface FuncionExterna {

    public Void nuevoEvento(OrganizacioneNoGubernamental organizacion, ZonaDeCobertura zona, Muestra muestra);

}
