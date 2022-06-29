package test.java.usuarios.tipos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.ExpertoValidado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.InstanceOf;

import main.java.usuarios.tipos.Basico;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.sitioWeb.SitioWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;
import main.java.muestras.tipos.SinVerificar;
import main.java.muestras.tipos.TipoDeMuestra;

class BasicoTest {

    Usuario user;
    Usuario user1;
    Ubicacion ubi;
    TipoDeOpinion tipoDeOpinion;
    Muestra muestra;
    Basico tipoBasico;
    SitioWeb web;
    TipoDeMuestra tipoDeMuestra;

    @BeforeEach
    void setUp() {
        user = mock(Usuario.class);
        web = mock(SitioWeb.class);
        tipoBasico = new Basico();
        tipoDeOpinion = TipoDeOpinion.ChincheFoliada;
        ubi  = mock(Ubicacion.class);
        //tipoDeOpinion = mock(TipoDeOpinion.class);
        muestra = mock(Muestra.class);
        user1 = new Usuario(123, "jose Marquez", web);
        when(user.getSitio()).thenReturn(web);

    }
    
    @Test
    void registrarMuestraBasicoTest() {
        tipoBasico.registrarMuestra(tipoDeOpinion,"Foto",ubi,user);
        verify(web).agregarNuevaMuestra(tipoDeOpinion,"Foto",ubi ,user , any(SinVerificar.class));
        //verify(user).getSitio().agregarNuevaMuestra(tipoDeOpinion,"Foto",ubi,user,new SinVerificar());
    } 
	 
    @Test
    void usuarioBasicoNocumpleCondicionDeExpertoTest() {
        when(user.getTipo()).thenReturn(tipoBasico);
        tipoBasico.actualizarUsuario(user);
        assertFalse(tipoBasico.cumpleCondicionDeExperto(user));
    } 
    
    @Test
    void actualizarUsuarioTest() {
    	registrar11Muestras(); 
    	crear21Opiniones();
    	tipoBasico.actualizarUsuario(user1);
    	//assertTrue(tipoBasico.cumpleCondicionDeExperto(user1));
    	assertTrue(user1.getTipo() instanceof Experto);
    }    
	private void registrar11Muestras() {
	
		web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user1);
		web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user1);
		web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user1);
		web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user1);
		web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user1);
		web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user1);
		web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user1);
		web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user1);
		web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user1);
		web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user1);
		web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user1);
	}
	private void crear21Opiniones() {
		web.opinarDeMuestraN(001, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(002, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(003, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(004, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(005, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(006, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(007, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(032, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(043, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(010, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(011, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(012, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(013, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(014, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(015, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(016, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(017, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(023, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(031, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(020, TipoDeOpinion.ChincheFoliada, user1);
		web.opinarDeMuestraN(021, TipoDeOpinion.ChincheFoliada, user1);
		
	}


	@Test
	void esUnTipoDeExpertoVerdadero() {
		assertFalse(tipoBasico.esUnTipoDeExperto());
	}

}