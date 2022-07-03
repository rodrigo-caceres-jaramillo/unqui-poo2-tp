package main.java.usuarios.tipos;

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
