package it.univpm.SpringBootApplication;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.univpm.SpringBootApplication.exception.InvalidBodyException;
import it.univpm.SpringBootApplication.exception.JobsNotFoundException;
import it.univpm.SpringBootApplication.filters.Filter;
import it.univpm.SpringBootApplication.service.Parse;

public class FilterJobsTest {
	
	JSONObject body = new JSONObject();
	Filter filter = new Filter();
	Map<String,Object> bodyMap = new HashMap<String,Object>();
	
	@BeforeEach
	void setUp() throws Exception{
		body.put("location", "Los aNGELES");
		body.put("remote", false);
		body.put("employment_type", "full time");
		bodyMap = Parse.JSONStringToMap(body.toJSONString());
	}
	
	@AfterEach
	void tearDown() throws Exception{
		
	}
	
	@Test
	@DisplayName("Test Filter Jobs")
	void test() {
		try {
			assertNotNull(filter.filteredJobs(bodyMap));
		} catch (ParseException | InvalidBodyException | JobsNotFoundException e) {
			System.out.println(e);
			assertTrue(false);//quando entro nel catch di sicuro il test fallisce
		}

		
	}
}
