package test.java.muestras;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.muestras.AdministradorDeMuestras;
import main.java.muestras.Muestra;
import main.java.muestras.Opinion;
import main.java.muestras.TipoDeOpinion;
import main.java.muestras.criterios.Criterio;
import main.java.muestras.tipos.SinVerificar;
import main.java.muestras.tipos.TipoDeMuestra;
import main.java.muestras.tipos.Verificada;
import main.java.ubicacciones.Ubicacion;
import main.java.usuarios.Usuario;

class AdministradoDeMuestrasTest {
	AdministradorDeMuestras adminDeMuestras;
	Ubicacion ubicacion;
	Usuario usuario;
	TipoDeMuestra tipoDeMuestra;
	TipoDeMuestra tipoDeMuestra2;
	
	@BeforeEach
    void setUp() {
		adminDeMuestras = new AdministradorDeMuestras();
		ubicacion = mock(Ubicacion.class);
		usuario = mock(Usuario.class);
		tipoDeMuestra = new SinVerificar();
		tipoDeMuestra2 = new Verificada();
	}
	
	@Test
	void getMuestrasTest() {
		assertTrue(adminDeMuestras.getMuestras().isEmpty());
	}
	
	@Test
	void setMuestrasTest() {
		ArrayList<Muestra> nuevasMuestras = new ArrayList<Muestra>();
		adminDeMuestras.setMuestras(nuevasMuestras);
		assertEquals(adminDeMuestras.getMuestras(), nuevasMuestras);
	}
	
	@Test
	void getSiguienteIdTest() {
		assertEquals(adminDeMuestras.getSiguienteId(), 0);
	}
	
	@Test
	void setSiguienteIdTest() {
		adminDeMuestras.setSiguienteId(2);
		assertEquals(adminDeMuestras.getSiguienteId(), 2);
	}
	
	@Test
	void agregarNuevaMuestraTest() {
		adminDeMuestras.agregarNuevaMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubicacion, usuario, tipoDeMuestra);
		assertEquals(adminDeMuestras.getMuestras().size(), 1);
	}
	
	@Test
	void muestraNTest() {
		adminDeMuestras.agregarNuevaMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubicacion, usuario, tipoDeMuestra);
		adminDeMuestras.agregarNuevaMuestra(TipoDeOpinion.VinchucaGuasayana, "foto", ubicacion, usuario, tipoDeMuestra);
		assertEquals(adminDeMuestras.muestraN(1).getTipoVinchuca(),TipoDeOpinion.VinchucaGuasayana );
	}
	
	@Test
	void muestrasAMenosDeDesdeTest() {
		float distancia = 5f;

		Muestra muestraAVer = mock(Muestra.class);
		Muestra muestra1 = mock(Muestra.class);

		ArrayList<Muestra> muestras = new ArrayList<Muestra>();
		adminDeMuestras.setMuestras(muestras);

		muestras.add(muestra1);
		when(muestra1.getUbicacion().distanciaEntre(muestraAVer)).thenReturn(1f);

		assertEquals(muestras,adminDeMuestras.muestrasAMenosDeDesdeTest(distancia,muestraAVer));
	}
	
	@Test
	void agregarOpinionAMuestraNTest() {
		Opinion unaOpinion = mock(Opinion.class);
		adminDeMuestras.agregarNuevaMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubicacion, usuario, tipoDeMuestra);
		adminDeMuestras.agregarOpinionAMuestraN(0, unaOpinion);
		assertEquals(adminDeMuestras.muestraN(0).getOpiniones().size(), 2);
	}
	
	@Test
	void muestraNSeVerificoTest() {
		adminDeMuestras.agregarNuevaMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubicacion, usuario, tipoDeMuestra);
		TipoDeMuestra tipoInicial = adminDeMuestras.muestraN(0).getTipo();
		adminDeMuestras.muestraN(0).setTipo(tipoDeMuestra2);
		assertTrue(adminDeMuestras.muestraNSeVerifico(0, tipoInicial));
	}
	
	@Test
	void ultimaMuestraCreadaTest() {
		adminDeMuestras.agregarNuevaMuestra(TipoDeOpinion.ChincheFoliada, "foto", ubicacion, usuario, tipoDeMuestra);
		Muestra ultimaMuestra = adminDeMuestras.muestraN(0);
		assertEquals(adminDeMuestras.ultimaMuestraCreada(), ultimaMuestra);
	}
	
	@Test
	void realizarBusquedaTest() {
		LocalDate date = LocalDate.now();
		Criterio criterio = mock(Criterio.class);
		adminDeMuestras.realizarBusqueda(date, TipoDeOpinion.ChincheFoliada, tipoDeMuestra, criterio);
		verify(criterio).realizarBusqueda(date,TipoDeOpinion.ChincheFoliada, tipoDeMuestra,adminDeMuestras.getMuestras());
	}
}
