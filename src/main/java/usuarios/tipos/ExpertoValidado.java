package usuarios.tipos;

import muestras.Foto;
import muestras.Muestra;
import muestras.TipoDeOpinion;
import muestras.tipos.SiendoVerificada;
import ubicacciones.Ubicacion;
import usuarios.Usuario;

public class ExpertoValidado extends TipoDeUsuario{

	@Override
	public void registrarMuestra(TipoDeOpinion especie, Foto foto, Ubicacion ubicacion, Usuario usuario) {
		Muestra muestra = new Muestra(especie, usuario, foto, ubicacion, new SiendoVerificada());
		usuario.getSitio().agregarNuevaMuestra(muestra);
	}

}
