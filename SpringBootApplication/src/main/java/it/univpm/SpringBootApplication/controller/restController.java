package it.univpm.SpringBootApplication.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.json.simple.parser.ParseException;

public class restController {

	@GetMapping("/Jobs")
	public ResponseEntity<Object> getAllJobs(){
		try {
			return new ResponseEntity(, HttpStatus.OK)
		}
		catch(JobNotFoundException | ParseException e) {
			System.out.println(e);
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
		
	}
}
