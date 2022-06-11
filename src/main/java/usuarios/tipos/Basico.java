package main.java.usuarios.tipos;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.SinVerificar;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

public class Basico extends TipoDeUsuario{

	@Override
	public void registrarMuestra(TipoDeOpinion especie, String foto, Ubicacion ubicacion, Usuario usuario) {
		usuario.getSitio().agregarNuevaMuestra(especie, foto, ubicacion, usuario, new SinVerificar());
	}
}
