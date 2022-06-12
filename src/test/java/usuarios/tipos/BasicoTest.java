package test.java.usuarios.tipos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import main.java.usuarios.tipos.Experto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.usuarios.tipos.Basico;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.sitioWeb.SitioWeb;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;
import main.java.muestras.tipos.TipoDeMuestra;
import main.java.usuarios.tipos.Experto;

class BasicoTest {

    Usuario user;
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
        //ubi  = mock(Ubicacion.class);
        //tipoDeOpinion = mock(TipoDeOpinion.class);
        //muestra = mock(Muestra.class);
        //user1 = new Usuario(123, "jose Marquez", sitioWeb);

    }

    @Test
    void registrarMuestraBasicoTest() {
        tipoBasico.registrarMuestra(tipoDeOpinion,"Foto",ubi,user);
        verify(user).getSitio().agregarNuevaMuestra(tipoDeOpinion,"Foto",ubi,user,any(TipoDeMuestra.class));
    }

    @Test
    void usuarioBasicoNocumpleCondicionDeExpertoTest() {
        when(user.getTipo()).thenReturn(tipoBasico);

        tipoBasico.actualizarUsuario(user);

        assertEquals(user.getTipo(),tipoBasico);
    }

    @Test
    void usuarioBasicoCumpleCondicionDeExpertoTest() {
        Experto experto = new Experto();
        when(user.getTipo()).thenReturn(tipoBasico);

        tipoBasico.actualizarUsuario(user);

        assertEquals(user.getTipo(),experto);
    }


}
