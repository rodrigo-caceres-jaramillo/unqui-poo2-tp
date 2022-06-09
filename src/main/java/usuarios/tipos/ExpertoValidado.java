package main.java.usuarios.tipos;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.SiendoVerificada;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

public class ExpertoValidado extends TipoDeUsuario{

	@Override
	public void registrarMuestra(TipoDeOpinion especie, String foto, Ubicacion ubicacion, Usuario usuario) {
		Muestra muestra = new Muestra(especie, usuario, foto, ubicacion, new SiendoVerificada());
		usuario.getSitio().agregarNuevaMuestra(muestra);
		
	}

}
