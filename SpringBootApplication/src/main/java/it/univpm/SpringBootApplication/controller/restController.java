package it.univpm.SpringBootApplication.controller;


import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.univpm.SpringBootApplication.model.City;
import it.univpm.SpringBootApplication.service.FindJobs;


public class restController {

	FindJobs fjobs;
	
	@GetMapping(value="/Job/{city}")
	public ResponseEntity<Object> JobList(@PathVariable("city") String city) throws ParseException {
		return new ResponseEntity<>(fjobs.getJobs(city), HttpStatus.OK);
	}
	
	@GetMapping(value = "/Cities")
	public City getCities(){
			return new City();
	}
}
