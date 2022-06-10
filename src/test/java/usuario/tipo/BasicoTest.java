package test.java.usuario.tipo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

class BasicoTest {

    Usuario user;
    Ubicacion ubi;
    TipoDeOpinion tipo;
    Muestra muestra;

    @BeforeEach
    void setUp() {
        user = mock(Usuario.class);
        ubi  = mock(Ubicacion.class);
        tipo = mock(TipoDeOpinion.class);
        muestra = mock(Muestra.class);
    }


    @Test
    void registrarMuestraBasicoTest() {
        this.registrarMuestra(tipo,"Foto",ubi,user);  // Cambiar this
        verify(user).getSitio().agregarNuevaMuestra(muestra);
    }

}
