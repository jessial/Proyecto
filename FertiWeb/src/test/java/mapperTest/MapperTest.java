package mapperTest;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import dominio.Analisis;
import persistencia.entidad.AnalisisEntidad;

public class MapperTest {
	
	private static final String JSON_ANALISIS = "{\"codigo\":1,\"codigoParcela\":1,\"fechaAnalisis\":null,\"ph\":0,\"mo\":0,\"n\":0,\"m\":0,\"k\":0,\"mg\":0,\"ca\":0,\"al\":0,\"na\":0,\"s\":0,\"fe\":0,\"b\":0,\"cu\":0,\"mn\":0,\"zn\":0,\"saNa\":0,\"saK\":0,\"saCa\":0,\"saMg\":0,\"saAl\":0,\"porcentajeA\":0,\"porcentajeL\":0,\"porcentajeAr\":0,\"cice\":0}";
	private DozerBeanMapper mapperDozer;
	
	
	@Before
	public void before() throws Exception {
		mapperDozer = new DozerBeanMapper();
	}
	
	@Test
	public void convertirAnalisisEnEntidad() throws Exception {
		//Arrange
		ObjectMapper mapperJson = new ObjectMapper();
		Analisis analisis = mapperJson.readValue(JSON_ANALISIS, Analisis.class);
		analisis.setFechaAnalisis(new Date());
		AnalisisEntidad analisisEntidad = new AnalisisEntidad();

		//Act
		mapperDozer.map(analisis, analisisEntidad);
		
		//Assert
		assertEquals(analisis.hashCode(), analisisEntidad.hashCode());
	}

}
