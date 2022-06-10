package usuarios.tipos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.usuarios.tipos.Basico;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

class BasicoTest {

    Usuario user;
    Ubicacion ubi;
    TipoDeOpinion tipo;
    Muestra muestra;
    Basico tipoBasico;

    @BeforeEach
    void setUp() {
        user = mock(Usuario.class);
        ubi  = mock(Ubicacion.class);
        tipo = mock(TipoDeOpinion.class);
        muestra = mock(Muestra.class);
        tipoBasico = new Basico();
    }

    @Test
    void registrarMuestraBasicoTest() {
        tipoBasico.registrarMuestra(tipo,"Foto",ubi,user);  // Cambiar this
        verify(user).getSitio().agregarNuevaMuestra(muestra);
    }

}
