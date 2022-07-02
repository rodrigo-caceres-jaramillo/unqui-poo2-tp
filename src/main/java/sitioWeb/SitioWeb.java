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

    public void agregarNuevaMuestra(Muestra muestra){  // antes --> TipoDeOpinion especie, String foto, Ubicacion ubicacion, Usuario usuario, TipoDeMuestra tipoDeMuestra
        //this.getAdministradorDeMuestras().agregarNuevaMuestra(especie, foto, ubicacion, usuario, tipoDeMuestra);;
    	
    	//muestra.getUsuario().procesarMuestra(muestra); ---> settea la muestra base, agregandole los datos correctos o se podria poner por precondicion.
    	
        this.getAdministradorDeMuestras().agregarNuevaMuestra(muestra);

        muestra.getUsuario().registrarMuestra();

        //Muestra nuevaMuestra = this.getAdministradorDeMuestras().ultimaMuestraCreada();
        this.getAdministradorDeZonas().actualizarZonasConNuevaMuestra(muestra); // nuevaMuestra
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

    /*public Muestra muestraN(Integer id) {
    	return this.getAdministradorDeMuestras().muestraN(id);
    }
    */

    public List<Muestra> muestrasAMenosDeDesde(float metros,Muestra muestraAVer){
        return this.getAdministradorDeMuestras().muestrasAMenosDeDesde(metros,muestraAVer);
    }
    
    public void opinarSobreLaMuestraN(Muestra muestra, Opinion opinion){  // antes --> Integer idMuestra, Opinion opinion
    	//Muestra muestra =  this.getAdministradorDeMuestras().muestraN(idMuestra);
    	TipoDeMuestra tipoInicial= muestra.getTipo();
    	//this.getAdministradorDeMuestras().agregarOpinionAMuestraN(idMuestra, opinion);
        muestra.agregarOpinion(opinion);
        //if(this.getAdministradorDeMuestras().muestraNSeVerifico(idMuestra, tipoInicial)) {
         if(muestra.seVerifico(tipoInicial)){
            this.getAdministradorDeZonas().avisarALasOrganizacionesQueSeValidoLaMuestraNumero(muestra); // idMuestra
         }
    }

    public TipoDeOpinion resultadoActualDeMuestraN(Muestra muestra) { // Integer idMuestra
    	//return this.getAdministradorDeMuestras().muestraN(idMuestra).getResultadoActual();
        return muestra.getResultadoActual();
    } 
    
    public boolean esSuMuestra(Muestra muestra, Integer idDeUsuario) { // Integer idMuestra, Integer idDeUsuario
		//return this.getAdministradorDeMuestras().muestraNEsDeUsuarioN(idMuestra, idDeUsuario);
        return muestra.fueCreadaPorUsuario(idDeUsuario);
	}

	public boolean muestraNTieneOpinionDeUsuarioN(Muestra muestra, Integer idUsuario) { // Integer idMuestra, Integer idUsuario
		//return this.getAdministradorDeMuestras().muestraNTieneOpinionDeUsuarioN(idMuestra, idUsuario);
        return muestra.tieneUnaOpinionDeUsuarioN(idUsuario);
	}

    public ArrayList<Muestra> realizarBusqueda(Criterio criterioFiltro){
       return  this.getAdministradorDeMuestras().realizarBusqueda(criterioFiltro);
    }

    // nuevos metodos para registrar muestra y opinion. NO FUNCIONAN TODAVIA
    // se decidio utilizar agregarNuevaMuestra.
    /* 
    public void registrarMuestra(TipoDeOpinion especie, String foto, Ubicacion ubicacion, Usuario user) {
        //user.getTipo().registrarMuestra(especie, foto, ubicacion, user);
        //user.agregarFechaDePublicacion(LocalDateTime.now());
        user.registrarMuestra(especie, foto, ubicacion);
    }
	*/
    /*
    public void opinarDeMuestraN(Integer idMuestra, TipoDeOpinion tipo, Usuario user) {
        if(! this.esSuMuestra(idMuestra, user.getId()) &&
            ! this.muestraNTieneOpinionDeUsuarioN(idMuestra, user.getId())) {
        	Opinion op = new Opinion(user.getId(), tipo, user.getTipo());
            this.opinarSobreLaMuestraN(idMuestra, op);
            user.agregarFechaDeOpinion(LocalDateTime.now());
        }  
    }
    */

    public void opinarDeMuestraN(Muestra muestra, TipoDeOpinion tipo, Usuario user) {
        if(! this.esSuMuestra(muestra, user.getId()) &&
           ! this.muestraNTieneOpinionDeUsuarioN(muestra, user.getId())) {
              Opinion op = new Opinion(user.getId(), tipo, user.getTipo());
              this.opinarSobreLaMuestraN(muestra, op);
              user.hiceUnaOpinion();
        }
    }

}
