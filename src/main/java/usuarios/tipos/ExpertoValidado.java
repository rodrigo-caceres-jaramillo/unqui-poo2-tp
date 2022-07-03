package main.java.usuarios.tipos;

import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.SiendoVerificada;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

public class ExpertoValidado extends TipoDeUsuario{


	
	@Override
	public void actualizarUsuario(Usuario usuario) {
	}

	@Override
	public boolean esUnTipoDeExperto(){
		return true;
	}

}
