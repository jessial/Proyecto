package integracion;

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;

import java.io.FileReader;
import java.util.Date;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.databind.ObjectMapper;

import controladores.ControladorDatos;
import dominio.Analisis;
import persistencia.entidad.AnalisisEntidad;
import persistencia.repositorio.AnalisisRepository;

public class ControladorDatosTest {

	private ControladorDatos controladorDatos;

	@Mock
	AnalisisRepository analisisRepository;

	@Mock
	DozerBeanMapper mapperDozer;

	@Before
	public void before() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void convertirAnalisisEnEntidad() throws Exception {
		// Arrange
		controladorDatos = new ControladorDatos(new DozerBeanMapper(), analisisRepository, null, null, null, null, null,
				null, null, null, null, null);
		FileReader file = new FileReader("src/test/java/jsonTest/JSON_ANALISIS.json");
		ObjectMapper mapperJson = new ObjectMapper();
		Analisis analisis = mapperJson.readValue(file, Analisis.class);
		analisis.setFechaAnalisis(new Date());

		// Act
		controladorDatos.guardarAnalisis(analisis);

		// Assert
		verify(analisisRepository, atMost(1)).save(Mockito.any(AnalisisEntidad.class));

	}

}
