package mapperTest;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dominio.Analisis;
import persistencia.entidad.AnalisisEntidad;

public class MapperTest {
	
	private DozerBeanMapper mapperDozer;
	
	
	@Before
	public void before() throws Exception {
		mapperDozer = new DozerBeanMapper();
		
	}
	
	@Test
	public void convertirAnalisisEnEntidad() throws Exception {
		//Arrange
		FileReader file = new FileReader("src/test/java/jsonTest/JSON_ANALISIS.json");
		ObjectMapper mapperJson = new ObjectMapper();
		Analisis analisis = mapperJson.readValue(file, Analisis.class);
		analisis.setFechaAnalisis(new Date());
		AnalisisEntidad analisisEntidad = new AnalisisEntidad();

		//Act
		mapperDozer.map(analisis, analisisEntidad);
		
		//Assert
		assertEquals(analisis.hashCode(), analisisEntidad.hashCode());
	}
	
	@Test
	public void convertirListAnalisisEnEntidad() throws Exception {
		//Arrange
		FileReader file = new FileReader("src/test/java/jsonTest/JSON_LIST_ANALISIS.json");
		ObjectMapper mapperJson = new ObjectMapper();
		List<Analisis> analisis = mapperJson.readValue(file, new TypeReference<List<Analisis>>(){});
		List<AnalisisEntidad> analisisEntidad = new ArrayList<>();
		
		//Act
		mapperDozer.map(analisis, analisisEntidad);
		
		//Assert
		assertEquals(analisis.hashCode(), analisisEntidad.hashCode());
	}

}
