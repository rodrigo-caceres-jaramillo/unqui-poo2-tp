package usuarios.tipos;

import muestras.Foto;
import muestras.TipoDeOpinion;
import ubicacciones.Ubicacion;
import usuarios.Usuario;

public abstract class TipoDeUsuario {
	public abstract void registrarMuestra(TipoDeOpinion especie, Foto foto, Ubicacion ubicacion, Usuario usuario);
}
