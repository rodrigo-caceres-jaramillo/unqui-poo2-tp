package organizaciones;

import ubicacciones.Ubicacion;

public class OrganizacioneNoGubernamental {

    private Ubicacion ubicacionDeLaOrg;
    private TipoDeOrganizacion tipo;
    private int cantidadDeTrabajadores;

    public OrganizacioneNoGubernamental(Ubicacion ubicacionAPoner, TipoDeOrganizacion tipoDeLaOrg, int cantidadDeTrabajadoresAPoner){
        ubicacionDeLaOrg = ubicacionAPoner;
        tipo = tipoDeLaOrg;
        cantidadDeTrabajadores = cantidadDeTrabajadoresAPoner;
    }

    public void funcionExterna(){}

}
