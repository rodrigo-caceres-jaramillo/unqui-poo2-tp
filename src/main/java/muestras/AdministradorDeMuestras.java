package main.java.muestras;

import java.util.ArrayList;
import java.util.Optional;

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

}
