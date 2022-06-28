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

    public void agregarNuevaMuestra(TipoDeOpinion especie, String foto, Ubicacion ubicacion, Usuario usuario, TipoDeMuestra tipoDeMuestra){
        this.getAdministradorDeMuestras().agregarNuevaMuestra(especie, foto, ubicacion, usuario, tipoDeMuestra);;
        Muestra nuevaMuestra = this.getAdministradorDeMuestras().ultimaMuestraCreada();
        this.getAdministradorDeZonas().actualizarZonasConNuevaMuestra(nuevaMuestra);
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
        //zonaDeInteres.getOrganizacionesInteresadas().add(org);  --> antes
        zonaDeInteres.agregarOrganizacionInterezada(org);
    }

    //Precondicion debe existir la zon y
    // la organizacion debe estar interesada en la zona de la que quiere "desligarse"
    public void organizacionSeDejaDeInterezaEnLaZona(OrganizacioneNoGubernamental org,ZonaDeCobertura zonaDeInteres){
        //zonaDeInteres.getOrganizacionesInteresadas().remove(org);  --> antes
        zonaDeInteres.eliminarOrganizacionQueSeDejoDeInterezar(org);
    }

    public Muestra muestraN(Integer id) {
    	return this.getAdministradorDeMuestras().muestraN(id);
    }

    public List<Muestra> muestrasAMenosDeDesde(float metros,Muestra muestraAVer){
        return this.getAdministradorDeMuestras().muestrasAMenosDeDesde(metros,muestraAVer);
    }

    public void opinarSobreLaMuestraN(Integer idMuestra, Opinion opinion){  //Reducimos en 1 la cantidad de busquedas al quedarnos con la muestra y crear una variable con el tipo inicial de la misma
    	Muestra muestra =  this.getAdministradorDeMuestras().muestraN(idMuestra);
    	TipoDeMuestra tipoInicial= muestra.getTipo();
    	this.getAdministradorDeMuestras().agregarOpinionAMuestraN(idMuestra, opinion);
    	if(this.getAdministradorDeMuestras().muestraNSeVerifico(idMuestra, tipoInicial)) {
            this.getAdministradorDeZonas().avisarALasOrganizacionesQueSeValidoLaMuestraNumero(idMuestra);
        }
    }
    
    public TipoDeOpinion resultadoActualDeMuestraN(Integer idMuestra) {
    	return this.getAdministradorDeMuestras().muestraN(idMuestra).getResultadoActual();
    }
    
    public boolean esSuMuestra(Integer idMuestra, Integer idDeUsuario) {
		return this.getAdministradorDeMuestras().muestraNEsDeUsuarioN(idMuestra, idDeUsuario);
	}

	public boolean muestraNTieneOpinionDeUsuarioN(Integer idMuestra, Integer idUsuario) {
		return this.getAdministradorDeMuestras().muestraNTieneOpinionDeUsuarioN(idMuestra, idUsuario);
	}

    public ArrayList<Muestra> realizarBusqueda(Criterio criterioFiltro){
       return  this.getAdministradorDeMuestras().realizarBusqueda(criterioFiltro);
    }
    // nuevos metodos para registrar muestra y opinion. NO FUNCIONAN TODAVIA
    public void registrarMuestra(TipoDeOpinion especie, String foto, Ubicacion ubicacion, Usuario user) {
        user.getTipo().registrarMuestra(especie, foto, ubicacion, user);
        user.agregarFechaDePublicacion(LocalDateTime.now());
        user.getTipo().actualizarUsuario(user);
    }
    
    public void opinarDeMuestraN(Integer idMuestra, TipoDeOpinion tipo, Usuario user) {
        if(! this.esSuMuestra(idMuestra, user.getId()) &&
            ! this.muestraNTieneOpinionDeUsuarioN(idMuestra, user.getId())) {
                 this.opinarSobreLaMuestraN(idMuestra, user.crearOpinion(tipo));
                 user.agregarFechaDeOpinion(LocalDateTime.now());
                 user.getTipo().actualizarUsuario(user);
        }  
    }
}
