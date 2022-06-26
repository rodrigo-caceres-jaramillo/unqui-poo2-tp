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
	public void agregarNuevaMuestra(TipoDeOpinion especie, String foto, Ubicacion ubicacion, Usuario usuario, TipoDeMuestra tipoDeMuestra){
		Muestra muestra = new Muestra(this.getSiguienteId(), especie, usuario, foto, ubicacion, tipoDeMuestra);
		this.getMuestras().add(muestra);
		this.setSiguienteId(this.getSiguienteId() + 1);
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
		Muestra muestra =this.muestraN(idMuestra);
		muestra.agregarOpinion(unaOpinion);
	}
	
	public Boolean muestraNSeVerifico(Integer idMuestra, TipoDeMuestra tipoInicial) { 
		Muestra muestra =this.muestraN(idMuestra);
		return (muestra.getTipo() instanceof Verificada && !(tipoInicial instanceof Verificada)); 
		// Se puede usar equals o
		// Se puede hacer un metodo en el Tipo 
		// Questionar cuanto va a escalar el sistema
	}
	
	//Precondicion: debe haber almenos una muestra subida
	public Muestra ultimaMuestraCreada() {
		Integer ultimaId =this.getSiguienteId() - 1;
		return this.muestraN(ultimaId);
	}

	public ArrayList<Muestra> realizarBusqueda(Criterio criterioFiltro){
		return criterioFiltro.realizarBusqueda(this.getMuestras());
	}
	public boolean muestraNTieneOpinionDeUsuarioN(Integer idMuestra, Integer idUsuario) {
		return this.muestraN(idMuestra).tieneUnaOpinionDeUsuarioN(idUsuario);
	}
	
	public boolean muestraNEsDeUsuarioN(Integer idMuestra, Integer idDeUsuario) {
		return this.muestraN(idMuestra).fueCreadaPorUsuario(idDeUsuario);
	}

}
