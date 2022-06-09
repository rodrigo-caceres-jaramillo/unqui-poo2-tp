package main.java.muestras;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdministradorDeMuestras {
    private ArrayList<Muestra> muestras;
    private Integer siguienteId;
    // Constructor
    public AdministradorDeMuestras() {
		super();
		this.muestras = new ArrayList<Muestra>();
		this.siguienteId= 0;
    }
	// Gets y sets
    public ArrayList<Muestra> getMuestras() {
		return muestras;
	}

	public void setMuestras(ArrayList<Muestra> muestras) {
		this.muestras = muestras;
	}

	public Integer getSiguienteId() {
		return siguienteId;
	}

	public void setSiguienteId(Integer siguienteId) {
		this.siguienteId = siguienteId;
	}

	// Metodos
	public void agregarNuevaMuestra(Muestra muestra){
        this.getMuestras().add(muestra);
    }

	public Muestra muestraN(Integer id) {
		return (this.getMuestras().stream()
				.filter(muestra -> id.equals(muestra.getId()))
				.findAny().get());
	}

	public List<Muestra> muestrasAMenosDeDesde(float metros, Muestra muestraAVer){
		return this.getMuestras().stream().filter(m->m.getUbicacion().distanciaEntre(muestraAVer.getUbicacion()) <= metros).collect(Collectors.toList()) ;
	}
	public void agregarOpinionAMuestraN(Integer idMuestra, Opinion unaOpinion) {
		// TODO Auto-generated method stub
		
		Muestra muestra =this.muestraN(idMuestra);
		muestra.agregarOpinion(unaOpinion);
		this.comprobarValidacion(muestra);
	}
	private void comprobarValidacion(Muestra unaMuestra) {
		// TODO Auto-generated method stub
		//if(unaMuestra.opinionesDeExpertos()) {
			
		//}
	}

}
