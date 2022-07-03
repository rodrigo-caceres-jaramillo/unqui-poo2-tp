package main.java.usuarios.tipos;

import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.SinVerificar;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

public class Basico extends TipoDeUsuario{


	
	@Override
	public void actualizarUsuario(Usuario usuario) {
		if (this.cumpleCondicionDeExperto(usuario)) {
			usuario.setTipo(new Experto());
		}
	}

	@Override
	public boolean esUnTipoDeExperto(){
		return false;
	}

}
