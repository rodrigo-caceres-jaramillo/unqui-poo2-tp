package main.java.muestras;

import java.time.LocalDate;
import java.util.ArrayList;
import main.java.muestras.tipos.TipoDeMuestra;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

public class Muestra {
	//private Integer id;
	private TipoDeOpinion tipoVinchuca;
    private Usuario usuario;
    private LocalDate creacion;
    private LocalDate ultimaVotacion;
    private String foto; // string1
    private Ubicacion ubicacion;
    private ArrayList<Opinion> opiniones; 
    private TipoDeMuestra tipo;
    private TipoDeOpinion resultadoActual;
    // Constructor
	public Muestra(/*Integer id,*/TipoDeOpinion tipoVinchuca, Usuario usuario, String foto, Ubicacion ubicacion, TipoDeMuestra tipo) {
		super();
		//this.id = id;
		this.tipoVinchuca = tipoVinchuca;
		this.usuario = usuario;
		this.creacion = LocalDate.now();
		this.ultimaVotacion = LocalDate.now();
		this.foto = foto;
		this.ubicacion = ubicacion;
		this.opiniones = new ArrayList<Opinion>();
		Opinion opinionInicial = new Opinion(usuario.getId(), tipoVinchuca, usuario.getTipo());
		this.opiniones.add(opinionInicial);
		this.tipo = tipo;
		this.resultadoActual = tipoVinchuca;
	}
	// Gets y sets

	/*public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	*/

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
	
	public boolean tieneUnaOpinionDeUsuarioN(Integer idUsuario) {	
		return this.getOpiniones().stream().anyMatch(p -> p.getIdUsuario().equals(idUsuario));
	}
	
	public boolean fueCreadaPorUsuario(Integer idDeUsuario) {
		return this.getUsuario().getId().equals(idDeUsuario);
	}

	public boolean seVerifico(TipoDeMuestra tipoM){
		return  this.getTipo().esVerificado() && (tipoM != this.getTipo());
	}

}
