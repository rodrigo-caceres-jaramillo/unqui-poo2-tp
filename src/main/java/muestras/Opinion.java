package main.java.muestras;

import java.time.LocalDate;
import main.java.usuarios.Usuario;
import main.java.usuarios.tipos.TipoDeUsuario;

public class Opinion {
	private Usuario usuario;
	private LocalDate fecha;
	private TipoDeOpinion tipo;
	private TipoDeUsuario tipoUsuario;
	
	// Constructor
	public Opinion(Usuario usuario, TipoDeOpinion tipo) {
		super();
		this.usuario = usuario;
		this.fecha = LocalDate.now();
		this.tipo = tipo;
		this.tipoUsuario = usuario.getTipo();
	}
	// Gets y sets
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public TipoDeUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoDeUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
   
    public TipoDeOpinion getTipo() {
		return tipo;
	}
	
    public void setTipo(TipoDeOpinion tipo) {
		this.tipo = tipo;
	}
		
	//metodos
	public boolean esOpinionDeAlgunExperto(){ 
		return this.getTipoUsuario().esUnTipoDeExperto();
	}
}

