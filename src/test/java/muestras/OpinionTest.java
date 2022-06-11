package test.java.muestras;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.TipoDeUsuario;

class OpinionTest {
    Opinion opinion;
    TipoDeUsuario tipoDeUsuario;
    TipoDeOpinion tipoOpinion;
    Integer id;

    @BeforeEach
    void setUp() {
        tipoDeUsuario = mock(Basico.class);
        tipoOpinion = TipoDeOpinion.ChincheFoliada;
        id = 852;
        opinion = new Opinion(id,tipoOpinion,tipoDeUsuario);

    }

    @Test
    void getTipoUsuarioTest() {
        assertEquals(tipoDeUsuario,opinion.getTipoUsuario());
    }

    @Test
    void setIdTest() {
        Integer idNuevo = 789;
        opinion.setId(idNuevo);
        assertEquals(idNuevo, opinion.getIdUsuario());
    }

    @Test
    void setTipoUsuarioTest() {
        TipoDeUsuario tipoDeUsuarioNuevo =  mock(TipoDeUsuario.class);
        opinion.setTipoUsuario(tipoDeUsuarioNuevo);
        assertEquals(tipoDeUsuarioNuevo,opinion.getTipoUsuario());
    }

    @Test
    void getFechaTest() {
        assertEquals(LocalDate.now(),opinion.getFecha());
    }

    @Test
    void setFechaTest() {
        LocalDate fecha = LocalDate.now();
        opinion.setFecha(fecha);
        assertEquals(LocalDate.now(),opinion.getFecha());
    }

    @Test
    void getTipoTest() {
        assertEquals(tipoOpinion,opinion.getTipo());
    }

    @Test
    void setTipoTest() {
        TipoDeUsuario tipoDeUsuarioNuevo =  mock(TipoDeUsuario.class);
        opinion.setTipoUsuario(tipoDeUsuarioNuevo);
        assertEquals(tipoDeUsuarioNuevo,opinion.getTipoUsuario());
    }

    @Test
    void getIdUsuarioTest() {
        assertEquals(id,opinion.getIdUsuario());
    }

    @Test
    void setIdUsuarioTest() {
        Integer idNuevo =  147;
        opinion.setIdUsuario(idNuevo);
        assertEquals(idNuevo,opinion.getIdUsuario());
    }
}
