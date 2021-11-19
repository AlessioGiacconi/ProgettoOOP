package it.univpm.SpringBootApplication.controller;


import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.SpringBootApplication.model.City;
import it.univpm.SpringBootApplication.service.FindJobs;
import it.univpm.SpringBootApplication.service.Parse;


@RestController
public class restController {

	FindJobs fjobs;
	
	@GetMapping(value="/Jobs")
	public ResponseEntity<Object> jobList() {
		try {	
			return new ResponseEntity<>(fjobs.getJobs(), HttpStatus.OK);
		}catch(ParseException e) {
			System.out.println(e);
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/Cities")
	public City getCities() {
		return new City();
	}
	
	@PostMapping(value="/Filters")
	public ResponseEntity<Object> filteredJobList(@RequestBody JSONObject body){
		Map<String, Object> bodyMap = Parse.JSONStringToMap(body.toJSONString());
		
	}
}
