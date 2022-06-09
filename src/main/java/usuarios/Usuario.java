package main.java.usuarios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.sitioWeb.SitioWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.ExpertoValidado;
import main.java.usuarios.tipos.TipoDeUsuario;

public class Usuario {
	private SitioWeb sitio;
	private Integer id;
	private String nombre;
	private TipoDeUsuario tipo;
	private ArrayList<LocalDate> registroPublicaciones;
	private ArrayList<LocalDate> registroOpiniones;
	// private Boolean esExpertoExterno;
	// Constructor
	public Usuario(Integer id, String nombre, SitioWeb unSitio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = new Basico();
		this.sitio = unSitio;
		this.registroPublicaciones = new ArrayList<LocalDate>();
		this.registroOpiniones = new ArrayList<LocalDate>();
	}
	// Gets y sets
	public ArrayList<LocalDate> getRegistroPublicaciones(){
		return registroPublicaciones;
	}
	public void setRegistroPublicaciones(ArrayList<LocalDate> lista) {
		this.registroPublicaciones = lista;
	}
	public ArrayList<LocalDate> getRegistroOpiniones(){
		return registroOpiniones;
	}
	public void setRegistroOpiniones(ArrayList<LocalDate> lista) {
		this.registroOpiniones = lista;
	}
	public SitioWeb getSitio() {
		return sitio;
	}
	public void setSitio(SitioWeb sitio) {
		this.sitio = sitio;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TipoDeUsuario getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeUsuario tipo) {
		this.tipo = tipo;
	}
	// Metodos
	public void registrarMuestra(TipoDeOpinion especie, String foto, Ubicacion ubicacion) {
		this.tipo.registrarMuestra(especie, foto, ubicacion, this);
		this.registrarPublicacion(LocalDate.now());
		this.actualizarTipoDeUsuario();
	}
	public void opinarDeMuestraN(Integer idMuestra, TipoDeOpinion tipo) {
		Opinion opinion = new Opinion(this.getId(), tipo, this.getTipo());
		this.getSitio().opinarSobreLaMuestraN(idMuestra, opinion);
		this.registrarOpiniones(LocalDate.now());
		this.actualizarTipoDeUsuario();
		
	}
	
	private void registrarOpiniones(LocalDate unaFecha) {
		registroOpiniones.add(unaFecha);
	}
	private void registrarPublicacion(LocalDate unaFecha) {
		registroPublicaciones.add(unaFecha);
	}
	
	// ------------------- revisar ---------------------------------------------------
	
	private void actualizarTipoDeUsuario() {
		// cada vez que realiza una opinion o una publicacion, revisa si el usuario
		// tiene el estado correcto, lo actualiza si es necesario.
		if( this.cumpleCondicionDeExperto() && !(this.getTipo() instanceof ExpertoValidado)){
			this.setTipo(new Experto());
		} else {
			this.setTipo(new Basico());
		}
	}

	private boolean cumpleCondicionDeExperto() {
		// retorna verdadero si cumple con la condicion de que tiene mas de 10 envios y 20 revisiones
		// en el mes.
		return cumple10EnviosEnElMes(registroPublicaciones, LocalDate.now()) &&
				cumple20RevisionesEnElMes(registroOpiniones, LocalDate.now());
	}

	private boolean cumple20RevisionesEnElMes(ArrayList<LocalDate> listaDeFechas, LocalDate unaFecha) {
		// retorna verdadero en caso de haya 20 fechas menores a 30 dias con "unaFecha".
		int counter = 0;
		for(LocalDate fecha : listaDeFechas) {
			counter =+ unoSi(fecha, unaFecha); 
		}
		return (counter > 20);
	}

	private int unoSi(LocalDate fecha, LocalDate unaFecha) {
		// retorna 1 si la diferencia es menor a 30 dias, 0 sino.
		long diff = ChronoUnit.DAYS.between(fecha, unaFecha);
		if(diff < 30) {
			return 1;
		} else {
			return 0;
		}
	}
/*
	private int difereciaDias(Date fecha, Date unaFecha) {
		// retorna la diferencia de dias entre una fecha y otra.
		return fecha.compareTo(unaFecha);
	}
*/
	private boolean cumple10EnviosEnElMes(ArrayList<LocalDate> listaDeFechas, LocalDate unaFecha) {
		// retorna verdadero en caso de que haya mas de 10 fechas con diferencia de menos de 30 dias con "unaFecha".
		int counter = 0;
		for(LocalDate fecha : listaDeFechas) {
			counter =+ unoSi(fecha, unaFecha); 
		}
		return (counter > 10);
	}
}
