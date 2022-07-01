package main.java.usuarios.tipos;

import java.time.LocalDateTime;
import java.util.ArrayList;

import main.java.muestras.TipoDeOpinion;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

public abstract class TipoDeUsuario {
	public abstract void registrarMuestra(TipoDeOpinion especie, String foto, Ubicacion ubicacion, Usuario usuario);

	public abstract void actualizarUsuario(Usuario usuario);
	
	public abstract boolean esUnTipoDeExperto();
	
	public boolean cumpleCondicionDeExperto(Usuario usuario) {
		//return this.cumple10EnviosEnElMes(usuario, LocalDateTime.now()) &&
		//this.cumple20RevisionesEnElMes(usuario, LocalDateTime.now());
		return (cumpleXCantidadDeYEnElMes(10, usuario.getRegistroPublicaciones(), LocalDateTime.now())
				&& cumpleXCantidadDeYEnElMes(20, usuario.getRegistroOpiniones(), LocalDateTime.now()));
	}
	// Combinar el funcionamiento de los dos metodos, agregando la cantidad de revisiones/opiniones
	// Si es sobre opiniones o revisiones
	/*
	private boolean cumple20RevisionesEnElMes(Usuario usuario , LocalDateTime unaFecha) {
		// cumpleXCantidadDeYEnElMes(20,usuario.getRegistroOpiniones(),unaFecha);
		int counter = 0;
		for(LocalDateTime fecha : usuario.getRegistroOpiniones()) {
			counter = counter + this.unoSi(fecha, unaFecha); 
		}
		return (counter > 20);
	}
	
	private boolean cumple10EnviosEnElMes(Usuario usuario, LocalDateTime unaFecha) {
		// cumpleXCantidadDeYEnElMes(10,usuario.getRegistroPublicaciones(),unaFecha);
		int counter = 0;
		for(LocalDateTime fecha : usuario.getRegistroPublicaciones()) {
			counter = counter + this.unoSi(fecha, unaFecha); 
		}
		return (counter > 10);
	}
	*/
	private boolean esDespuesDe(LocalDateTime fecha, LocalDateTime unaFecha) {
		LocalDateTime f1 = unaFecha.minusDays(30);
		return fecha.isAfter(f1);
	}
	
	private boolean cumpleXCantidadDeYEnElMes(int cantidad,ArrayList<LocalDateTime> fechas,LocalDateTime unaFecha) {
		return fechas.stream().filter(f -> this.esDespuesDe(f, unaFecha)).count() > cantidad;
	}
}
