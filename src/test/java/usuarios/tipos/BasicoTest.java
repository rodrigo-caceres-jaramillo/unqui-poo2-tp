package test.java.usuarios.tipos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.usuarios.tipos.Basico;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.sitioWeb.SitioWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

class BasicoTest {

    Usuario user1;
    Ubicacion ubi;
    TipoDeOpinion tipoDeOpinion;
    Muestra muestra;
    Basico tipoBasico;
    SitioWeb sitioWeb;

    @BeforeEach
    void setUp() {
        //user = mock(Usuario.class);
        //ubi  = mock(Ubicacion.class);
        sitioWeb = mock(SitioWeb.class);
        //tipoDeOpinion = mock(TipoDeOpinion.class);
        //muestra = mock(Muestra.class);
        tipoBasico = new Basico();
        user1 = new Usuario(123, "jose Marquez", sitioWeb);
		user1.setTipo(tipoBasico);
    }
/*
    @Test
    void registrarMuestraBasicoTest() {
        tipoBasico.registrarMuestra(tipo,"Foto",ubi,user);  // Cambiar this
        verify(user).getSitio().agregarNuevaMuestra(muestra);
    }
    */
    @Test
    void usuarioBasicoNocumpleCondicionDeExpertoTest() {
    	assertFalse(user1.getTipo().cumpleCondicionDeExperto(user1));
    }

}
