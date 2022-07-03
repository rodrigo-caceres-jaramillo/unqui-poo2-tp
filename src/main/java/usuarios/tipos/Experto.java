package main.java.usuarios.tipos;

import main.java.usuarios.Usuario;

public class Experto extends TipoDeUsuario{

	@Override
	public void actualizarUsuario(Usuario usuario) {
		if (!this.cumpleCondicionDeExperto(usuario)) {
			usuario.setTipo(new Basico());
		}
	}

	@Override
	public boolean esUnTipoDeExperto(){
		return true;
	}

}
