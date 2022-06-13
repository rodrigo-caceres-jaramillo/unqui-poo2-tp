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
    SitioWeb sitioWeb;
    TipoDeMuestra tipoDeMuestra;

    @BeforeEach
    void setUp() {
        user = mock(Usuario.class);
        sitioWeb = mock(SitioWeb.class);
        tipoBasico = new Basico();
        tipoDeOpinion = TipoDeOpinion.ChincheFoliada;
        ubi  = mock(Ubicacion.class);
        //tipoDeOpinion = mock(TipoDeOpinion.class);
        muestra = mock(Muestra.class);
        user1 = new Usuario(123, "jose Marquez", sitioWeb);
        when(user.getSitio()).thenReturn(sitioWeb);

    }
    
    @Test
    void registrarMuestraBasicoTest() {
        tipoBasico.registrarMuestra(tipoDeOpinion,"Foto",ubi,user);
        verify(sitioWeb).agregarNuevaMuestra(tipoDeOpinion,"Foto",ubi ,user , any(SinVerificar.class));
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
    	assertTrue(tipoBasico.cumpleCondicionDeExperto(user1));
    	assertTrue(user1.getTipo() instanceof Experto);
    }  
    
	private void registrar11Muestras() {
		user1.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubi);
		user1.registrarMuestra(TipoDeOpinion.ImagenPocoClara, "estoEsUnaFoto", ubi);
		user1.registrarMuestra(TipoDeOpinion.VinchucaGuasayana, "estoEsUnaFoto", ubi);
		user1.registrarMuestra(TipoDeOpinion.VinchucaInfestans, "estoEsUnaFoto", ubi);
		user1.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubi);
		user1.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubi);
		user1.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubi);
		user1.registrarMuestra(TipoDeOpinion.VinchucaSordida, "estoEsUnaFoto", ubi);
		user1.registrarMuestra(TipoDeOpinion.ImagenPocoClara, "estoEsUnaFoto", ubi);
		user1.registrarMuestra(TipoDeOpinion.ChincheFoliada, "estoEsUnaFoto", ubi);
		user1.registrarMuestra(TipoDeOpinion.ImagenPocoClara, "estoEsUnaFoto", ubi);
	}
	private void crear21Opiniones() {
		user1.opinarDeMuestraN(001, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(050, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(002, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(003, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(004, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(005, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(006, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(007, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(123, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(132, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(010, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(011, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(012, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(013, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(014, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(015, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(016, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(017, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(412, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(234, TipoDeOpinion.ChincheFoliada);
		user1.opinarDeMuestraN(020, TipoDeOpinion.ChincheFoliada);
	}

}