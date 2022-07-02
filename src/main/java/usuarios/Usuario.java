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
	private TipoDeUsuario tipoDeUsuario;
	private ArrayList<LocalDateTime> fechasDePublicaciones;
	private ArrayList<LocalDateTime> fechasDeOpiniones;
	// private Boolean esExpertoExterno;
	// Constructor
	public Usuario(Integer id, String nombre, SitioWeb unSitio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoDeUsuario = new Basico();
		this.sitio = unSitio;
		this.fechasDePublicaciones = new ArrayList<LocalDateTime>();
		this.fechasDeOpiniones = new ArrayList<LocalDateTime>();
	}
	// Gets y sets
	public ArrayList<LocalDateTime> getRegistroPublicaciones(){
		return fechasDePublicaciones; 
	}
	public void setRegistroPublicaciones(ArrayList<LocalDateTime> lista) {
		this.fechasDePublicaciones = lista;
	}
	public ArrayList<LocalDateTime> getRegistroOpiniones(){
		return fechasDeOpiniones;
	}
	public void setRegistroOpiniones(ArrayList<LocalDateTime> lista) {
		this.fechasDeOpiniones = lista;
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
		return tipoDeUsuario;
	}
	public void setTipo(TipoDeUsuario tipo) {
		this.tipoDeUsuario = tipo;
	}
	
	public void agregarFechaDeOpinion(LocalDateTime unaFecha) {
		fechasDeOpiniones.add(unaFecha);
		this.getTipo().actualizarUsuario(this);
	}
	
	public void agregarFechaDePublicacion(LocalDateTime unaFecha) {
		fechasDePublicaciones.add(unaFecha);
		this.getTipo().actualizarUsuario(this); 
	} 
	
	public void validarseExternamenta() {
		this.setTipo(new ExpertoValidado());
	}
	
	public void registrarMuestra(TipoDeOpinion especie, String foto, Ubicacion ubicacion) {
	 	this.getTipo().registrarMuestra(especie, foto, ubicacion, this);
        this.agregarFechaDePublicacion(LocalDateTime.now());
	}

	public void hiceUnaPublicacion(){
		// muestra.setTipo(this.tipo().subTarea);
		this.agregarFechaDePublicacion(LocalDateTime.now());
	}
}