package main.java.sitioWeb;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import main.java.muestras.AdministradorDeMuestras;
import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.TipoDeMuestra;
import main.java.muestras.tipos.Verificada;
import main.java.organizaciones.OrganizacioneNoGubernamental;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;
import main.java.usuarios.tipos.Basico;
import main.java.zonasDeCoberturas.AdministradorDeZonasDeCoberturas;
import main.java.zonasDeCoberturas.ZonaDeCobertura;
import main.java.muestras.criterios.Criterio;

public class SitioWeb {
	private AdministradorDeMuestras adminMuestras;
    private AdministradorDeZonasDeCoberturas adminzonasZonas;
    private List<OrganizacioneNoGubernamental> organizaciones;
    // Constructor
    public SitioWeb(AdministradorDeMuestras adminDeLasMuestra,AdministradorDeZonasDeCoberturas adminDeLasZonas, List<OrganizacioneNoGubernamental> organizacionesAPoner){
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

    public void agregarNuevaMuestra(Muestra muestra){
        this.getAdministradorDeMuestras().agregarNuevaMuestra(muestra);
        muestra.getUsuario().registrarMuestra();
        this.getAdministradorDeZonas().actualizarZonasConNuevaMuestra(muestra); /
    }

    public void agregarNuevaZona(ZonaDeCobertura zonaAAgregar){
        this.getAdministradorDeZonas().agregarNuevaZona(zonaAAgregar);
    }

    public void agregarNuevaOrganizacion(OrganizacioneNoGubernamental orgAAgregar){
        this.getOrganizaciones().add(orgAAgregar);
    }

    public List<ZonaDeCobertura> zonasQueSolapanCon(ZonaDeCobertura zonaAVer){
        return this.getAdministradorDeZonas().zonasQueSolapaCon(zonaAVer);
    }

    public List<ZonaDeCobertura> zonasDeInteresDeLaOrg(OrganizacioneNoGubernamental orgAVer){
        return this.getAdministradorDeZonas().zonasDeInteresDeLaOrg(orgAVer);
    }

    //Precondicion debe existir la zon
    public void organizacionSeInterezaEnLaZona(OrganizacioneNoGubernamental org,ZonaDeCobertura zonaDeInteres){
        zonaDeInteres.agregarOrganizacionInterezada(org);
    }

    //Precondicion debe existir la zon y
    // la organizacion debe estar interesada en la zona de la que quiere "desligarse"
    public void organizacionSeDejaDeInterezaEnLaZona(OrganizacioneNoGubernamental org,ZonaDeCobertura zonaDeInteres){
        zonaDeInteres.eliminarOrganizacionQueSeDejoDeInterezar(org);
    }

    public List<Muestra> muestrasAMenosDeDesde(float metros,Muestra muestraAVer){
        return this.getAdministradorDeMuestras().muestrasAMenosDeDesde(metros,muestraAVer);
    }
    
    public void opinarSobreLaMuestraN(Muestra muestra, Opinion opinion){
    	TipoDeMuestra tipoInicial= muestra.getTipo();
        muestra.agregarOpinion(opinion);
         if(muestra.seVerifico(tipoInicial)){
            this.getAdministradorDeZonas().avisarALasOrganizacionesQueSeValidoLaMuestraNumero(muestra);
         }
    }

    public TipoDeOpinion resultadoActualDeMuestraN(Muestra muestra) {
        return muestra.getResultadoActual();
    } 
    
    public boolean esSuMuestra(Muestra muestra, Integer idDeUsuario) {
        return muestra.fueCreadaPorUsuario(idDeUsuario);
	}

	public boolean muestraNTieneOpinionDeUsuarioN(Muestra muestra, Integer idUsuario) {
        return muestra.tieneUnaOpinionDeUsuarioN(idUsuario);
	}

    public List<Muestra> realizarBusqueda(Criterio criterioFiltro){ //ArrayList<Muestra> realizarBusqueda(Criterio criterioFiltro)
       return  this.getAdministradorDeMuestras().realizarBusqueda(criterioFiltro);
    }

    public void opinarDeMuestraN(Muestra muestra, TipoDeOpinion tipo, Usuario user) {
        if(! this.esSuMuestra(muestra, user.getId()) &&
           ! this.muestraNTieneOpinionDeUsuarioN(muestra, user.getId())) {
              Opinion op = new Opinion(user.getId(), tipo, user.getTipo());
              this.opinarSobreLaMuestraN(muestra, op);
              user.hiceUnaOpinion();
        }
    }

}
