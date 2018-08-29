package integracion;

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;

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
import persistencia.repositorio.RolRepository;
import persistencia.repositorio.TipoCultivoRepository;

public class ControladorDatosTest {
	
	private static final String JSON_ANALISIS = "{\"codigo\":1,\"codigoParcela\":1,\"fechaAnalisis\":null,\"ph\":0,\"mo\":0,\"n\":0,\"m\":0,\"k\":0,\"mg\":0,\"ca\":0,\"al\":0,\"na\":0,\"s\":0,\"fe\":0,\"b\":0,\"cu\":0,\"mn\":0,\"zn\":0,\"saNa\":0,\"saK\":0,\"saCa\":0,\"saMg\":0,\"saAl\":0,\"porcentajeA\":0,\"porcentajeL\":0,\"porcentajeAr\":0,\"cice\":0}";
	private ControladorDatos controladorDatos;
	
	@Mock
	AnalisisRepository analisisRepository;
	
	@Mock
	RolRepository rolRepository;
	
	@Mock
	TipoCultivoRepository tipoCultivoRepository;
	
	
	
	@Mock
	DozerBeanMapper mapperDozer;
	
	@Before
	public void before() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void convertirAnalisisEnEntidad() throws Exception {
		// Arrange
		controladorDatos = new ControladorDatos(new DozerBeanMapper(), analisisRepository, rolRepository,tipoCultivoRepository);
		ObjectMapper mapperJson = new ObjectMapper();
		Analisis analisis = mapperJson.readValue(JSON_ANALISIS, Analisis.class);
		analisis.setFechaAnalisis(new Date());

		// Act
		controladorDatos.guardarAnalisis(analisis);

		// Assert
		verify(analisisRepository, atMost(1)).save(Mockito.any(AnalisisEntidad.class));

	}
	
}
