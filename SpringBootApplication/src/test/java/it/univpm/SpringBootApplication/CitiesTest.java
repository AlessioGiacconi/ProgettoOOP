package it.univpm.SpringBootApplication;

import it.univpm.SpringBootApplication.model.City;

import java.util.ArrayList;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * Classe usata per testare il funzionamento della classe Model City.
 * Verifica che la lettura delle città monitorate dall'applicazione, contenute in un file Cities.txt, avvenga correttamente.
 * @author Alessio Giacconi
 * @author Erxhes Dedja
 */



public class CitiesTest {

		private City c = new City();
		private Vector<String> cities = new Vector<String>();
		private Vector<String> vectorCities = new Vector<String>();
			
		@BeforeEach
		void setUp() throws Exception{
			cities = c.getNames();
			vectorCities.add("Los Angeles");
			vectorCities.add("New York");
			vectorCities.add("Chicago");
			vectorCities.add("San Francisco");
			vectorCities.add("Seattle");
		}
		
		@AfterEach
		void tearDown() throws Exception{
			
		}
		
		@Test
		@DisplayName("Test Monitored Cities")
		void test() {
				assertEquals(cities, vectorCities);
		}
}
