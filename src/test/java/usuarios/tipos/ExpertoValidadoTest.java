package test.java.usuarios.tipos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

	Usuario user1;
    Ubicacion ubi;
    TipoDeOpinion tipo;
    Muestra muestra;
    ExpertoValidado tipoExpertoValido;
    SitioWeb sitioWeb;

    
    @BeforeEach
    void setUp() {
    	sitioWeb = mock(SitioWeb.class);
        //muestra = mock(Muestra.class);
        tipoExpertoValido = mock(ExpertoValidado.class);
        user1 = new Usuario(123, "jose Marquez", sitioWeb);
		user1.setTipo(tipoExpertoValido);
    }
    /*
    @Test
    void registrarMuestraBasicoTest() {
    	when(user.getSitio()).thenReturn(sitio);
    	tipoExpertoValidado.registrarMuestra(tipo, "Foto", ubi, user);  // Cambiar this
        verify(user).getSitio().agregarNuevaMuestra(tipo, "Foto", ubi, user, any(SiendoVerificada.class));
        //TipoDeMuestra siendoValidada
    }
    */
    @Test
    void usuariocumpleCondicionDeExperto() {
    	when(tipoExpertoValido.cumpleCondicionDeExperto(user1)).thenReturn(true);
    	//verify(tipoExperto).cumpleCondicionDeExperto(user1);
    	assertTrue(user1.getTipo().cumpleCondicionDeExperto(user1));
}
}