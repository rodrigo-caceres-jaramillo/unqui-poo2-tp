package usuarios;

import muestras.Foto;
import muestras.Muestra;
import muestras.Opinion;
import muestras.TipoDeOpinion;
import sitoWeb.SitoWeb;
import ubicacciones.Ubicacion;
import usuarios.tipos.Basico;
import usuarios.tipos.TipoDeUsuario;

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
		this.tipo.registrarMuestra(especie, foto, ubicacion, this);
	}
	public void opinarDeMuestraN(Integer idMuestra, TipoDeOpinion tipo) {
		Muestra muestra = this.getSitio().muestraN(idMuestra);
		Opinion opinion = new Opinion(this, tipo);
		muestra.agregarOpinion(opinion);
	}
	
}
