package main.java.muestras;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import main.java.muestras.tipos.TipoDeMuestra;
import main.java.muestras.tipos.Verificada;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;
import main.java.muestras.criterios.Criterio;

public class AdministradorDeMuestras {
    private ArrayList<Muestra> muestras;

	// Constructor
    public AdministradorDeMuestras() {
		super();
		this.muestras = new ArrayList<Muestra>();
    }

	// Gets y sets
	public ArrayList<Muestra> getMuestras() {
		return muestras;
	}

	public void setMuestras(ArrayList<Muestra> muestras) {
		this.muestras = muestras;
	}

	// Metodos
	public void agregarNuevaMuestra(Muestra muestra){
		this.getMuestras().add(muestra);
	} 

	public List<Muestra> muestrasAMenosDeDesde(float metros, Muestra muestraAVer){
		return this.getMuestras().stream().filter(m->m.getUbicacion().distanciaEntre(muestraAVer.getUbicacion()) <= metros).collect(Collectors.toList()) ;
	}

	public ArrayList<Muestra> realizarBusqueda(Criterio criterioFiltro){
		return criterioFiltro.realizarBusqueda(this.getMuestras());
	}

}
