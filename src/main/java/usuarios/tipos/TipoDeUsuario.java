package main.java.usuarios.tipos;

import java.time.LocalDateTime;
import java.util.ArrayList;

import main.java.muestras.TipoDeOpinion;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

public abstract class TipoDeUsuario {

	public abstract void actualizarUsuario(Usuario usuario);
	
	public abstract boolean esUnTipoDeExperto();
	
	public boolean cumpleCondicionDeExperto(Usuario usuario) {

		return (cumpleXCantidadDeYEnElMes(10, usuario.getRegistroPublicaciones(), LocalDateTime.now())
				&& cumpleXCantidadDeYEnElMes(20, usuario.getRegistroOpiniones(), LocalDateTime.now()));
	}

	private boolean esDespuesDe(LocalDateTime fecha, LocalDateTime unaFecha) {
		LocalDateTime f1 = unaFecha.minusDays(30);
		return fecha.isAfter(f1);
	}
	
	private boolean cumpleXCantidadDeYEnElMes(int cantidad,ArrayList<LocalDateTime> fechas,LocalDateTime unaFecha) {
		return fechas.stream().filter(f -> this.esDespuesDe(f, unaFecha)).count() > cantidad;
	}
}
