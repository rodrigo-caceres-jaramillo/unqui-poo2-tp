package main.java.usuarios.tipos;

import java.time.LocalDateTime;

import main.java.muestras.TipoDeOpinion;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

public abstract class TipoDeUsuario {
	public abstract void registrarMuestra(TipoDeOpinion especie, String foto, Ubicacion ubicacion, Usuario usuario);

	public abstract void actualizarUsuario(Usuario usuario);
	
	public boolean cumpleCondicionDeExperto(Usuario usuario) {
		return this.cumple10EnviosEnElMes(usuario, LocalDateTime.now()) &&
				this.cumple20RevisionesEnElMes(usuario, LocalDateTime.now());
	}
	// Combinar el funcionamiento de los dos metodos, agregando la cantidad de revisiones/opiniones
	// Si es sobre opiniones o revisiones
	private boolean cumple20RevisionesEnElMes(Usuario usuario , LocalDateTime unaFecha) {
		int counter = 0;
		for(LocalDateTime fecha : usuario.getRegistroOpiniones()) {
			counter = counter + this.unoSi(fecha, unaFecha); 
		}
		return (counter > 20);
	}
	
	private boolean cumple10EnviosEnElMes(Usuario usuario, LocalDateTime unaFecha) {
		int counter = 0;
		for(LocalDateTime fecha : usuario.getRegistroPublicaciones()) {
			counter = counter + this.unoSi(fecha, unaFecha); 
		}
		return (counter > 10);
	}
	
	private int unoSi(LocalDateTime fecha, LocalDateTime unaFecha) {
		LocalDateTime f1= unaFecha.minusDays(30);
		boolean diff = fecha.isAfter(f1);
		 
		if(diff) { 
			return 1;
		} else { 
			return 0;
		}
	}
}
