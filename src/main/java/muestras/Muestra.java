package main.java.muestras;

import java.time.LocalDate;
import java.util.ArrayList;
import main.java.muestras.tipos.TipoDeMuestra;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

public class Muestra {
	private TipoDeOpinion tipoVinchuca;
    private Usuario usuario;
    private LocalDate creacion;
    private LocalDate ultimaVotacion;
    private String foto;
    private Ubicacion ubicacion;
    private ArrayList<Opinion> opiniones; 
    private TipoDeMuestra tipo;
    private TipoDeOpinion resultadoActual;
    // Constructor
	public Muestra(TipoDeOpinion tipoVinchuca, Usuario usuario, String foto, Ubicacion ubicacion, TipoDeMuestra tipo) {
		super();
		this.tipoVinchuca = tipoVinchuca;
		this.usuario = usuario;
		this.creacion = LocalDate.now();
		this.ultimaVotacion = LocalDate.now();
		this.foto = foto;
		this.ubicacion = ubicacion;
		this.opiniones = new ArrayList<Opinion>();
		Opinion opinionInicial = new Opinion(usuario, tipoVinchuca);
		this.opiniones.add(opinionInicial);
		this.tipo = tipo;
		this.resultadoActual = tipoVinchuca;
	}
	// Gets y sets
	public TipoDeOpinion getTipoVinchuca() {
		return tipoVinchuca;
	}
	
	public void setTipoVinchuca(TipoDeOpinion tipoVinchuca) {
		this.tipoVinchuca = tipoVinchuca;
	}
	
    public Usuario getUsuario() {
		return usuario;
	}
    
    public void setUsuario(Usuario usuario) {
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

    public String getFoto() {
		return foto;
	}
	
    public void setFoto(String foto) {
		this.foto = foto;
	}

    public ArrayList<Opinion> getOpiniones() {
		return opiniones;
	}
	
    public void setOpiniones(ArrayList<Opinion> opiniones) {
		this.opiniones = opiniones;
	}

	public Ubicacion getUbicacion(){
        return ubicacion;
    }
	
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
    public TipoDeMuestra getTipo() {
		return tipo;
	}
	
    public void setTipo(TipoDeMuestra tipo) {
		this.tipo = tipo;
	}

	public TipoDeOpinion getResultadoActual() {
		return resultadoActual;
	}
	
	public void setResultadoActual(TipoDeOpinion tipo) {
		this.resultadoActual = tipo;
	}
	
	// Metodos
	public void agregarOpinion(Opinion opinion) {
		this.getTipo().agregarOpinionA(opinion, this);
	}
	
	public boolean tieneUnaOpinionDeUsuario(Usuario usuario) {	
		return this.getOpiniones().stream()
				.anyMatch(p -> p.getUsuario().equals(usuario));
	}

	public boolean seVerifico(TipoDeMuestra tipoM){
		return  this.getTipo().esVerificado() && (! tipoM.equals(this.getTipo()));
	}
}
