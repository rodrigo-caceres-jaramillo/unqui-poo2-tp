package main.java.muestras;

import java.time.LocalDate;
import java.util.ArrayList;

import main.java.muestras.tipos.SiendoVerificada;
import main.java.muestras.tipos.SinVerificar;
import main.java.muestras.tipos.TipoDeMuestra;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;
import main.java.usuarios.tipos.Basico;

public class Muestra {
	private Integer id;
	private TipoDeOpinion tipoVinchuta;
    private Usuario usuario;
    private LocalDate creacion;
    private LocalDate ultimaVotacion;
    private Foto foto;
    private Ubicacion ubicacion;
    private ArrayList<Opinion> opiniones;
    private TipoDeMuestra tipo;
    // Constructor
	public Muestra(TipoDeOpinion tipoVinchuta, Usuario id, Foto foto, Ubicacion ubicacion, TipoDeMuestra tipo) {
		super();
		this.tipoVinchuta = tipoVinchuta;
		this.usuario = id;
		this.creacion = LocalDate.now();
		this.ultimaVotacion = null;
		this.foto = foto;
		this.ubicacion = ubicacion;
		this.opiniones = new ArrayList<Opinion>();
		Opinion opinionInicial = new Opinion(id, tipoVinchuta);
		this.opiniones.add(opinionInicial);
		this.tipo = tipo;
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
	public TipoDeMuestra getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeMuestra tipo) {
		this.tipo = tipo;
	}
	// Metodos
	public void agregarOpinion(Opinion opinion) {
		this.tipo.agregarOpinionA(opinion, this);
	}
}
