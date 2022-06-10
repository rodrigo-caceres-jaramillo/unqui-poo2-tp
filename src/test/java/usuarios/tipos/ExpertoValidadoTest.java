package usuarios.tipos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import main.java.usuarios.tipos.ExpertoValidado;

import main.java.muestras.Muestra;
import main.java.muestras.TipoDeOpinion;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;


class ExpertoValidadoTest {

    Usuario user;
    Ubicacion ubi;
    TipoDeOpinion tipo;
    Muestra muestra;
    ExpertoValidado tipoExpertoValidado ;

    @BeforeEach
    void setUp() {
        user = mock(Usuario.class);
        ubi = mock(Ubicacion.class);
        tipo = mock(TipoDeOpinion.class);
        muestra = mock(Muestra.class);
        tipoExpertoValidado = new ExpertoValidado();
    }

    @Test
    void registrarMuestraBasicoTest() {
        tipoExperto.registrarMuestra(tipo, "Foto", ubi, user);  // Cambiar this
        verify(user).getSitio().agregarNuevaMuestra(muestra);
    }
}