package muestras;

import java.time.LocalDate;

import usuarios.Usuario;

public class Opinion {
	private Usuario usuario;
	private LocalDate fecha;
	private TipoDeOpinion tipo;
	// Constructor
	public Opinion(Usuario usuario, TipoDeOpinion tipo) {
		super();
		this.usuario = usuario;
		
		this.fecha = LocalDate.now();
		this.tipo = tipo;
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

    public TipoDeOpinion getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeOpinion tipo) {
		this.tipo = tipo;
	}
}

