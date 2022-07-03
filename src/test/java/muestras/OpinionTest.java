package test.java.muestras;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.usuarios.Usuario;
import main.java.usuarios.tipos.Basico;
import main.java.usuarios.tipos.TipoDeUsuario;

class OpinionTest {
    Opinion opinion;
    Usuario usuario;
    TipoDeUsuario tipoDeUsuario;
    TipoDeOpinion tipoOpinion;

    @BeforeEach
    void setUp() {
        usuario = mock(Usuario.class);
        tipoDeUsuario = mock(Basico.class);
        when(usuario.getTipo()).thenReturn(tipoDeUsuario);
        tipoOpinion = TipoDeOpinion.ChincheFoliada;
        opinion = new Opinion(usuario,tipoOpinion);
    }

    @Test
    void getUsuarioTest() {
        assertEquals(usuario,opinion.getUsuario());
    }
    
    @Test
    void setUsuarioTest() {
        Usuario nuevoUsuario = mock(Usuario.class);
    	opinion.setUsuario(nuevoUsuario);
        assertEquals(nuevoUsuario, opinion.getUsuario());
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
    void getTipoUsuarioTest() {
        assertEquals(tipoDeUsuario,opinion.getTipoUsuario());
    }
    
    @Test
    void setTipoUsuarioTest() {
        TipoDeUsuario tipoDeUsuarioNuevo =  mock(TipoDeUsuario.class);
        opinion.setTipoUsuario(tipoDeUsuarioNuevo);
        assertEquals(tipoDeUsuarioNuevo,opinion.getTipoUsuario());
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
    
    // metodos
    
    @Test 
    void esOpinionDeAlgunExpertoTest() {
    	when(tipoDeUsuario.esUnTipoDeExperto()).thenReturn(true);
    	assertTrue(opinion.esOpinionDeAlgunExperto());
    }
    
    @Test 
    void noEsOpinionDeAlgunExpertoTest() {
    	when(tipoDeUsuario.esUnTipoDeExperto()).thenReturn(false);
    	assertFalse(opinion.esOpinionDeAlgunExperto());
    }
    
}
