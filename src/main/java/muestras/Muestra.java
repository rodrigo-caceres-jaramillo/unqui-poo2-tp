package muestras;

import java.time.LocalDate;
import java.util.ArrayList;

import muestras.tipos.SiendoVerificada;
import muestras.tipos.SinVerificar;
import muestras.tipos.TipoDeMuestra;
import ubicacciones.Ubicacion;
import usuarios.Usuario;
import usuarios.tipos.Basico;

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
		this.getTipo().agregarOpinionA(opinion, this);
	}
}
