package test.java.usuarios.tipos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.Experto;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.sitioWeb.SitioWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;


class ExpertoTest {

    Usuario user1;
    Ubicacion ubi;
    TipoDeOpinion tipo;
    Muestra muestra;
    Experto tipoExperto;
    SitioWeb sitioWeb;

    @BeforeEach
    void setUp() {
    	sitioWeb = mock(SitioWeb.class);
        //muestra = mock(Muestra.class);
        tipoExperto = mock(Experto.class);
        user1 = new Usuario(123, "jose Marquez", sitioWeb);
		user1.setTipo(tipoExperto);
    }
    	/*
    @Test
    void registrarMuestraBasicoTest() {
        tipoExperto.registrarMuestra(tipo,"Foto",ubi,user1);  // Cambiar this
        verify(user1).getSitio().agregarNuevaMuestra(muestra);
    }
 		*/
    @Test
    void usuariocumpleCondicionDeExperto() {
        	when(tipoExperto.cumpleCondicionDeExperto(user1)).thenReturn(true);
        	//verify(tipoExperto).cumpleCondicionDeExperto(user1);
        	assertTrue(user1.getTipo().cumpleCondicionDeExperto(user1));
    }
}


