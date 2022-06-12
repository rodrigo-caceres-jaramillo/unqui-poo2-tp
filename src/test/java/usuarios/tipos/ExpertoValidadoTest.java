package test.java.usuarios.tipos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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

	Usuario user;
    Ubicacion ubi;
    TipoDeOpinion tipo;
    Muestra muestra;
    ExpertoValidado tipoExpertoValido;
    SitioWeb sitioWeb;
    TipoDeOpinion tipoDeOpinion;

    
    @BeforeEach
    void setUp() {
    	sitioWeb = mock(SitioWeb.class);
        user = mock(Usuario.class);
        tipoExpertoValido = new ExpertoValidado();
        tipo = mock(TipoDeOpinion.class);
        ubi = mock(Ubicacion.class);
        tipoDeOpinion = TipoDeOpinion.ChincheFoliada;

        //user1 = new Usuario(123, "jose Marquez", sitioWeb);
		//user1.setTipo(tipoExpertoValido)
        //muestra = mock(Muestra.class);
    }

    @Test
    void registrarMuestraTest() {
        user.registrarMuestra(tipoDeOpinion,"Foto",ubi);

        verify(user).getSitio().agregarNuevaMuestra(tipoDeOpinion,"Foto",ubi,user,any(TipoDeMuestra.class));
    }

    @Test
    void actualizarUsuarioTest() {
        tipoExpertoValido.actualizarUsuario(user);
    }



}