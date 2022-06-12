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
import main.java.muestras.tipos.TipoDeMuestra;

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
        tipoExperto = mock(Experto.class);
        tipoDeOpinion = TipoDeOpinion.ChincheFoliada;
    }

    @Test
    void registrarMuestraBasicoTest() {
        tipoExperto.registrarMuestra(tipoDeOpinion,"Foto",ubi,user);
        verify(user).getSitio().agregarNuevaMuestra(tipoDeOpinion,"Foto",ubi,user,any(TipoDeMuestra.class));
    }

    @Test
    void usuarioBasicoNocumpleCondicionDeExpertoTest() {
        when(user.getTipo()).thenReturn(tipoExperto);

        tipoExperto.actualizarUsuario(user);

        assertEquals(user.getTipo(),tipoExperto);
    }

    @Test
    void usuarioBasicoCumpleCondicionDeExpertoTest() {
        Experto experto = new Experto();
        when(user.getTipo()).thenReturn(tipoExperto);

        tipoExperto.actualizarUsuario(user);

        assertEquals(user.getTipo(),experto);
    }

}


