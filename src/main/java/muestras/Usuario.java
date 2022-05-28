package main.java.muestras;

import main.java.sitoWeb.SitoWeb;
import main.java.ubicacciones.Ubicacion;

public class Usuario {
	private SitoWeb sitio;
	private Integer id;
	private String nombre;
	private Boolean esExperto;
	// Constructor
	public Usuario(Integer id, String nombre, Boolean esExperto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.esExperto = esExperto;
	}
	// Gets y sets
	public SitoWeb getSitio() {
		return sitio;
	}
	public void setSitio(SitoWeb sitio) {
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
	public Boolean getEsExperto() {
		return esExperto;
	}
	public void setEsExperto(Boolean esExperto) {
		this.esExperto = esExperto;
	}
	// Metodos
	public void registrarMuestra(TipoDeOpinion especie, Foto foto, Ubicacion ubicacion) {
		Muestra muestra = new Muestra(especie, this, foto, ubicacion);
		this.getSitio().agregarNuevaMuestra(muestra);
	}
	public void opinarDeMuestraN(Integer idMuestra, TipoDeOpinion tipo) {
		Muestra muestra = this.getSitio().muestraN(idMuestra);
		Opinion opinion = new Opinion(this, tipo);
		muestra.agregarOpinion(opinion);
		
	}
}
