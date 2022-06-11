package test.java.usuarios.tipos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    Ubicacion ubi;
    TipoDeOpinion tipo;
    Muestra muestra;
    SitioWeb sitio;
    ExpertoValidado tipoExpertoValidado ;

    
    @BeforeEach
    void setUp() {
    	tipoExpertoValidado = new ExpertoValidado();
    	user = mock(Usuario.class);
        ubi = mock(Ubicacion.class);
        tipo = TipoDeOpinion.ChincheFoliada;
        muestra = mock(Muestra.class);
        sitio = mock(SitioWeb.class);
        user.setTipo(tipoExpertoValidado);
        
    }

    @Test
    void registrarMuestraBasicoTest() {
    	when(user.getSitio()).thenReturn(sitio);
    	tipoExpertoValidado.registrarMuestra(tipo, "Foto", ubi, user);  // Cambiar this
        verify(user).getSitio().agregarNuevaMuestra(tipo, "Foto", ubi, user, any(SiendoVerificada.class));
        //TipoDeMuestra siendoValidada
    }
}