package main.java.usuarios;

import main.java.muestras.Foto;
import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.sitoWeb.SitoWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.TipoDeUsuario;

public class Usuario {
	private SitoWeb sitio;
	private Integer id;
	private String nombre;
	private TipoDeUsuario tipo;
	// Constructor
	public Usuario(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.setTipo(new Basico());
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
	public TipoDeUsuario getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeUsuario tipo) {
		this.tipo = tipo;
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
