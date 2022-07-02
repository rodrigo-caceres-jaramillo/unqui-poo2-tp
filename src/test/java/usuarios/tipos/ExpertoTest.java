package test.java.usuarios.tipos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.Experto;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.sitioWeb.SitioWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;
import main.java.muestras.tipos.SiendoVerificada;

class ExpertoTest {

    Usuario user;
    Ubicacion ubi;
    TipoDeOpinion tipo;
    TipoDeOpinion tipoDeOpinion;
    Muestra muestra;
    Experto tipoExperto;
    SitioWeb sitioWeb;

    @BeforeEach
    void setUp() {
    	sitioWeb = mock(SitioWeb.class);
        user = mock(Usuario.class);
        tipoExperto = new Experto();
        ubi = mock(Ubicacion.class);
        tipoDeOpinion = TipoDeOpinion.ChincheFoliada;
    }

    /*
    @Test
    void registrarMuestraBasicoTest() {
    	tipoExperto.registrarMuestra(tipoDeOpinion,"Foto",ubi,user);
        verify(sitioWeb).agregarNuevaMuestra(tipoDeOpinion,"Foto",ubi,user, any(SiendoVerificada.class));
    }
    */

    @Test
    void usuarioExpertoCumpleCondicionDeExpertoTest() {
    	ArrayList<LocalDateTime> fechas = new ArrayList();
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		fechas.add(LocalDateTime.now());
		
    	when(user.getRegistroOpiniones()).thenReturn(fechas);
    	when(user.getRegistroPublicaciones()).thenReturn(fechas);
    	
    	tipoExperto.actualizarUsuario(user);
    	assertTrue(tipoExperto.cumpleCondicionDeExperto(user));
    }

    @Test
    void usuarioExpertoactualizarUsuarioTest() {
      //  Experto experto = new Experto();
        when(user.getTipo()).thenReturn(tipoExperto);
        tipoExperto.actualizarUsuario(user);
        assertTrue(user.getTipo() instanceof Experto);
    }


    @Test
    void esUnTipoDeExpertoVerdadero() {
        assertTrue(tipoExperto.esUnTipoDeExperto());
    }


}