package main.java.usuarios.tipos;

import main.java.muestras.Foto;
import main.java.muestras.TipoDeOpinion;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

public abstract class TipoDeUsuario {
	public abstract void registrarMuestra(TipoDeOpinion especie, Foto foto, Ubicacion ubicacion, Usuario usuario);
}
