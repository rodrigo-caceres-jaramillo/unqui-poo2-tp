package main.java.muestras;

import java.time.LocalDate;
import java.util.ArrayList;

import main.java.ubicacciones.Ubicacion;

public class Muestra {
	private Integer id;
	private TipoDeOpinion tipoVinchuta;
    private Usuario usuario;
    private LocalDate creacion;
    private LocalDate ultimaVotacion;
    private Boolean verificado;
    private Foto foto;
    private Ubicacion ubicacion;
    private ArrayList<Opinion> opiniones;
    // Constructor
	public Muestra(TipoDeOpinion tipoVinchuta, Usuario id, Foto foto, Ubicacion ubicacion) {
		super();
		this.tipoVinchuta = tipoVinchuta;
		this.usuario = id;
		this.creacion = LocalDate.now();
		this.ultimaVotacion = null;
		this.verificado = false;
		this.foto = foto;
		this.ubicacion = ubicacion;
		this.opiniones = new ArrayList<Opinion>();
		Opinion opinionInicial = new Opinion(id, tipoVinchuta);
		this.opiniones.add(opinionInicial);
		
	}
	// Gets y sets
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TipoDeOpinion getTipoVinchuta() {
		return tipoVinchuta;
	}
	public void setTipoVinchuta(TipoDeOpinion tipoVinchuta) {
		this.tipoVinchuta = tipoVinchuta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setId(Usuario usuario) {
		this.usuario = usuario;
	}
	public LocalDate getCreacion() {
		return creacion;
	}
	public void setCreacion(LocalDate creacion) {
		this.creacion = creacion;
	}
	public LocalDate getUltimaVotacion() {
		return ultimaVotacion;
	}
	public void setUltimaVotacion(LocalDate ultimaVotacion) {
		this.ultimaVotacion = ultimaVotacion;
	}
	public Boolean getVerificado() {
		return verificado;
	}
	public void setVerificado(Boolean verificado) {
		this.verificado = verificado;
	}
	public Foto getFoto() {
		return foto;
	}
	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	public ArrayList<Opinion> getOpiniones() {
		return opiniones;
	}
	public void setOpiniones(ArrayList<Opinion> opiniones) {
		this.opiniones = opiniones;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Ubicacion getUbicacion(){
        return ubicacion;
    }
	// Metodos
	public void agregarOpinion(Opinion opinion) {
		this.getOpiniones().add(opinion);
	}
	
	/*public TipoDeOpinion resultadoActual() {
		TipoDeOpinion resultado = ;
		
		return resultado;
	}*/
}
