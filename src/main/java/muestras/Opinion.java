package main.java.muestras;

import java.time.LocalDate;

import main.java.usuarios.tipos.TipoDeUsuario;

public class Opinion {
	private Integer idUsuario;
	private LocalDate fecha;
	private TipoDeOpinion tipo;
	private TipoDeUsuario tipoUsuario;
	// Constructor
	public Opinion(Integer idUsuario, TipoDeOpinion tipo, TipoDeUsuario tipoUsuario) {
		super();
		this.setIdUsuario(idUsuario);
		
		this.fecha = LocalDate.now();
		this.tipo = tipo;
	}
	// Gets y sets
	public TipoDeUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setId(Integer id) {
		this.setIdUsuario(id);
	}
	public void setTipoUsuario(TipoDeUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
}

