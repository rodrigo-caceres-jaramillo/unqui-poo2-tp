package main.java.sitoWeb;

import main.java.muestras.AdministradorDeMuestras;
import main.java.muestras.Muestra;
import main.java.organizaciones.OrganizacioneNoGubernamental;
import main.java.zonasDeCoberturas.AdministradorDeZonasDeCoberturas;
import main.java.zonasDeCoberturas.ZonaDeCobertura;
import java.util.List;

public class SitoWeb {
    private AdministradorDeMuestras AdminMuestras;
    private AdministradorDeZonasDeCoberturas adminzonasZonas;
    private List<OrganizacioneNoGubernamental> organizaciones;


    public SitoWeb(AdministradorDeMuestras adminDeLasMuestra,AdministradorDeZonasDeCoberturas adminDeLasZonas, List<OrganizacioneNoGubernamental> organizacionesAPoner){
        AdminMuestras = adminDeLasMuestra;
        adminzonasZonas = adminDeLasZonas;
        organizaciones = organizacionesAPoner;
    }

    public AdministradorDeMuestras getAdministradorDeMuestras() {
        return AdminMuestras;
    }

    public void setMuestras(AdministradorDeMuestras muestras) {
        this.AdminMuestras = muestras;
    }

    public AdministradorDeZonasDeCoberturas getAdministradorDeZonas() {
        return adminzonasZonas;
    }

    public void setZonasDeCoberturas(AdministradorDeZonasDeCoberturas zonasDeCoberturas) {
        this.adminzonasZonas = zonasDeCoberturas;
    }

    public List<OrganizacioneNoGubernamental> getOrganizaciones() {
        return organizaciones;
    }

    public void setOrganizaciones(List<OrganizacioneNoGubernamental> organizaciones) {
        this.organizaciones = organizaciones;
    }

    public void agregarNuevaMuestra(Muestra mustraAAgregar){
        this.getAdministradorDeMuestras().agregarNuevaMuestra(mustraAAgregar);
        this.getAdministradorDeZonas().actualizarZonasConNuevaMuestra(mustraAAgregar);
    }

    public void agregarNuevaZona(ZonaDeCobertura zonaAAgregar){
        this.getAdministradorDeZonas().agregarNuevaZona(zonaAAgregar);
    }

    public void agregarNuevaOrganizacion(OrganizacioneNoGubernamental orgAAgregar){
        this.getOrganizaciones().add(orgAAgregar);
    }

    public List<ZonaDeCobertura> zonasQueSolapadasCon(ZonaDeCobertura zonaAVer){
        return this.getAdministradorDeZonas().zonasQueSolapadasCon(zonaAVer);
    }

    public List<ZonaDeCobertura> zonasDeInteresDeLaOrg(OrganizacioneNoGubernamental orgAVer){
        return this.getAdministradorDeZonas().zonasDeInteresDeLaOrg(orgAVer);
    }

    //Precondicion debe existir la zon
    public void organizacionSeInterezaEnLaZona(OrganizacioneNoGubernamental org,ZonaDeCobertura zonaDeInteres){
        zonaDeInteres.getOrganizacionesInteresadas().add(org);  // Ver si esta bien
    }

    //Precondicion debe existir la zon
    public void organizacionSeDejaDeInterezaEnLaZona(OrganizacioneNoGubernamental org,ZonaDeCobertura zonaDeInteres){
        zonaDeInteres.getOrganizacionesInteresadas().remove(org);  // Ver si esta bien
    }

}
