package test.java.usuarios.tipos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import main.java.usuarios.tipos.Experto;
import main.java.usuarios.tipos.ExpertoValidado;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.tipos.SiendoVerificada;
import main.java.muestras.tipos.TipoDeMuestra;
import main.java.sitioWeb.SitioWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;


class ExpertoValidadoTest {

	Usuario user;
	Usuario user1;
    Ubicacion ubi;
    TipoDeOpinion tipo;
    Muestra muestra;
    ExpertoValidado tipoExpertoValido;
    SitioWeb web;
    TipoDeOpinion tipoDeOpinion;

    
    @BeforeEach
    void setUp() {
    	web = mock(SitioWeb.class);
        user = mock(Usuario.class);
        tipoExpertoValido = new ExpertoValidado();
        //ubi = mock(Ubicacion.class);
        tipoDeOpinion = TipoDeOpinion.ChincheFoliada;
        
    }

    /*
    @Test
    void registrarMuestraTest() {
    	web.registrarMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubi, user);
        verify(user).getSitio().agregarNuevaMuestra(tipoDeOpinion,"Foto",ubi,user,any(TipoDeMuestra.class));
    }
    */

    @Test
    void esUnTipoDeExpertoVerdaderoTest() {
    	assertTrue(tipoExpertoValido.esUnTipoDeExperto());
    }

}