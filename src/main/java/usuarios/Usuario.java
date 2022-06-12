package main.java.usuarios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.sitioWeb.SitioWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.ExpertoValidado;
import main.java.usuarios.tipos.TipoDeUsuario;

public class Usuario {
	private SitioWeb sitio;
	private Integer id;
	private String nombre;
	private TipoDeUsuario tipo;
	private ArrayList<LocalDateTime> registroPublicaciones;
	private ArrayList<LocalDateTime> registroOpiniones;
	// private Boolean esExpertoExterno;
	// Constructor
	public Usuario(Integer id, String nombre, SitioWeb unSitio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = new Basico();
		this.sitio = unSitio;
		this.registroPublicaciones = new ArrayList<LocalDateTime>();
		this.registroOpiniones = new ArrayList<LocalDateTime>();
	}
	// Gets y sets
	public ArrayList<LocalDateTime> getRegistroPublicaciones(){
		return registroPublicaciones;
	}
	public void setRegistroPublicaciones(ArrayList<LocalDateTime> lista) {
		this.registroPublicaciones = lista;
	}
	public ArrayList<LocalDateTime> getRegistroOpiniones(){
		return registroOpiniones;
	}
	public void setRegistroOpiniones(ArrayList<LocalDateTime> lista) {
		this.registroOpiniones = lista;
	}
	public SitioWeb getSitio() {
		return sitio;
	}
	public void setSitio(SitioWeb sitio) {
		this.sitio = sitio;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TipoDeUsuario getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeUsuario tipo) {
		this.tipo = tipo;
	}
	// Metodos
	public void registrarMuestra(TipoDeOpinion especie, String foto, Ubicacion ubicacion) {
		this.tipo.registrarMuestra(especie, foto, ubicacion, this);
		this.registrarPublicacion(LocalDateTime.now());
		this.tipo.actualizarUsuario(this);
	}
	public void opinarDeMuestraN(Integer idMuestra, TipoDeOpinion tipo) {
		if(! this.sitio.esSuMuestra(idMuestra, this.getId()) &&
		   ! this.sitio.muestraNTieneOpinionDeUsuarioN(idMuestra, this.getId())) {
			    this.getSitio().opinarSobreLaMuestraN(idMuestra, crearOpinion(tipo));
			    this.registrarOpiniones(LocalDateTime.now());
			    this.tipo.actualizarUsuario(this);
		} 
	}
	public Opinion crearOpinion(TipoDeOpinion tipo) {
		Opinion opinion = new Opinion(this.getId(), tipo, this.getTipo());
		return opinion;
	}
	
	public void registrarOpiniones(LocalDateTime unaFecha) {
		registroOpiniones.add(unaFecha);
	}
	
	public void registrarPublicacion(LocalDateTime unaFecha) {
		registroPublicaciones.add(unaFecha);
	} 
	
	public void validarseExternamenta() {
		this.setTipo(new ExpertoValidado());
	} 
}