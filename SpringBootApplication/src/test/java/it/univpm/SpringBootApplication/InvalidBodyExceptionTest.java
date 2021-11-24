package it.univpm.SpringBootApplication;

import static org.junit.Assert.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import it.univpm.SpringBootApplication.filters.Filter;
import it.univpm.SpringBootApplication.service.Parse;

public class InvalidBodyExceptionTest {

	JSONObject body = new JSONObject();
	Filter filter = new Filter();
	Map<String,Object> bodyMap = new HashMap<String,Object>();
	
	@BeforeEach
	void setUp() throws Exception{
		body.put("location", "Boston");
		body.put("remote", false);
		body.put("employment_type", "full time");
		bodyMap = Parse.JSONStringToMap(body.toJSONString());
	}
	
	@AfterEach
	void tearDown() throws Exception{
		
	}
	
	@Test
	@DisplayName("Test Invalid Body Exception")
	void test() {
		assertThrows(ResponseStatusException.class, ()->filter.filteredJobs(bodyMap));
	}
}
