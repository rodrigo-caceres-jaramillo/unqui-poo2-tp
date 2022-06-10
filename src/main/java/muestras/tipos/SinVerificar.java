package main.java.muestras.tipos;

import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.ExpertoValidado;

public class SinVerificar extends TipoDeMuestra{

	@Override
	public void agregarOpinionA(Opinion opinion, Muestra muestra) {
		muestra.getOpiniones().add(opinion);
		this.actualizarResultadoActual(muestra, opinion);
		this.comprobarVerificacionDeLaMuestra(opinion, muestra);
	}
	
	public void actualizarResultadoActual(Muestra muestra, Opinion opinion) {
		if(this.ocurrenciasDeTipoEn(muestra.getOpiniones(), opinion.getTipo()) 
				>= this.ocurrenciasDeTipoEn(muestra.getOpiniones(), muestra.getResultadoActual())) {
					muestra.setResultadoActual(opinion.getTipo());
			}
	}
	
	public void comprobarVerificacionDeLaMuestra(Opinion opinion, Muestra muestra) {
		if(opinion.getTipoUsuario() instanceof Experto ||
			   opinion.getTipoUsuario() instanceof ExpertoValidado) {
				muestra.setTipo(new SiendoVerificada());
				muestra.setResultadoActual(opinion.getTipo());
			}
	}
}