package main.java.usuarios.tipos;

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
