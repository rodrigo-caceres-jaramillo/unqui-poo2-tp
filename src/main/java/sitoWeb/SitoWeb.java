package sitoWeb;

import muestras.AdministradorDeMuestras;
import muestras.Muestra;
import organizaciones.OrganizacioneNoGubernamental;
import zonasDeCoberturas.AdministradorDeZonasDeCoberturas;
import zonasDeCoberturas.ZonaDeCobertura;

import java.util.List;

public class SitoWeb {
    private AdministradorDeMuestras muestras;
    private AdministradorDeZonasDeCoberturas zonasDeCoberturas;
    private List<OrganizacioneNoGubernamental> organizaciones;


    public SitoWeb(AdministradorDeMuestras adminMuestra,AdministradorDeZonasDeCoberturas adminZonas, List<OrganizacioneNoGubernamental> organizacionesAPoner){
        muestras = adminMuestra;
        zonasDeCoberturas = adminZonas;
        organizaciones = organizacionesAPoner;
    }

    public AdministradorDeMuestras getMuestras() {
        return muestras;
    }

    public void setMuestras(AdministradorDeMuestras muestras) {
        this.muestras = muestras;
    }

    public AdministradorDeZonasDeCoberturas getZonasDeCoberturas() {
        return zonasDeCoberturas;
    }

    public void setZonasDeCoberturas(AdministradorDeZonasDeCoberturas zonasDeCoberturas) {
        this.zonasDeCoberturas = zonasDeCoberturas;
    }

    public List<OrganizacioneNoGubernamental> getOrganizaciones() {
        return organizaciones;
    }

    public void setOrganizaciones(List<OrganizacioneNoGubernamental> organizaciones) {
        this.organizaciones = organizaciones;
    }

    public void agregarMuestra(Muestra mustraAAgregar){
        this.getMuestras().agregarNuevaMuestra(mustraAAgregar);
        this.getZonasDeCoberturas().actualizarZonasConNuevaMuestra(mustraAAgregar);
    }

    public void registrarNuevaZona(ZonaDeCobertura zonaAAgregar){
        this.getZonasDeCoberturas().agregarNuevaZona(zonaAAgregar);
    }

}
