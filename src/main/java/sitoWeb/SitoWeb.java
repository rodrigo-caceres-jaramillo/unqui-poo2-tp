package sitoWeb;

import muestras.AdministradorDeMuestras;
import muestras.Muestra;
import muestras.Opinion;
import organizaciones.OrganizacioneNoGubernamental;
import zonasDeCoberturas.AdministradorDeZonasDeCoberturas;
import zonasDeCoberturas.ZonaDeCobertura;
import java.util.List;
import java.util.Set;

public class SitoWeb {
	private AdministradorDeMuestras adminMuestras;
    private AdministradorDeZonasDeCoberturas adminzonasZonas;
    private List<OrganizacioneNoGubernamental> organizaciones;
    // Constructor
    public SitoWeb(AdministradorDeMuestras adminDeLasMuestra,AdministradorDeZonasDeCoberturas adminDeLasZonas, List<OrganizacioneNoGubernamental> organizacionesAPoner){
        this.adminMuestras = adminDeLasMuestra;
        this.adminzonasZonas = adminDeLasZonas;
        this.organizaciones = organizacionesAPoner;
    }
    // Gets y sets
    public AdministradorDeMuestras getAdministradorDeMuestras() {
        return adminMuestras;
    }

    public void setMuestras(AdministradorDeMuestras muestras) {
        this.adminMuestras = muestras;
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

    // Metodos

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

    public Muestra muestraN(Integer id) {
    	return this.getAdministradorDeMuestras().muestraN(id);
    }

    public List<Muestra> muestrasAMenosDeDesde(float metros,Muestra muestraAVer){
        return this.getAdministradorDeMuestras().muestrasAMenosDeDesde(metros,muestraAVer);
    }

    public void  opinarSobreLaMuestraNumero(Integer id, Opinion opinionAponer){
        if(true){   // si esta opinion cambia el estado de la muestra a Validada  entonces ...
            this.getAdministradorDeZonas().avisarALasOrganizacionesQueSeValidoLaMuestraNumero(id);
        }
    }

    }
