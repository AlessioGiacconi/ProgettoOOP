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

import it.univpm.SpringBootApplication.exception.InvalidBodyException;
import it.univpm.SpringBootApplication.exception.JobsNotFoundException;
import it.univpm.SpringBootApplication.exception.StatsErrorException;
import it.univpm.SpringBootApplication.filters.Filter;
import it.univpm.SpringBootApplication.model.City;
import it.univpm.SpringBootApplication.service.FindJobs;
import it.univpm.SpringBootApplication.service.Parse;
import it.univpm.SpringBootApplication.statistics.Stats;

/**
 * Rappresenta la classe che gestisce tutte le chiamate
 * @author Alessio Giacconi
 * @author Erxhes Dedja
 */

@RestController
public class restController {

	FindJobs fjobs = new FindJobs();
	Filter filter = new Filter();
	Stats stats = new Stats();
	
	/**Rotta di tipo GET che ritorna tutte le offerte di lavoro presenti su FindWork.
	 * @return JsonArray contenente le offerte di lavoro
	 */	
	
	@GetMapping(value="/Jobs")
	public ResponseEntity<Object> jobList() throws JobsNotFoundException {
		try {	
			return new ResponseEntity<>(fjobs.getJobs(), HttpStatus.OK);
		}catch(ParseException e) {
			System.out.println(e);
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	/**Rotta di tipo GET che ritorna tutte le città in cui è possibile cercare i vari lavori.
	 */	
	
	@GetMapping(value = "/Cities")
	public City getCities() {
		return new City();
	}
	
	/**Rotta di tipo POST che effettua il filtraggio delle offerte di lavoro in base a location, lavoro in remoto e non, part-time o full-time.
	 * @return JSONArray con le offerte che soddisfano la richiesta.
	 */
	
	@PostMapping(value="/Filters")
	public ResponseEntity<Object> filteredJobList(@RequestBody JSONObject body) throws InvalidBodyException, JobsNotFoundException{
		Map<String, Object> bodyMap = Parse.JSONStringToMap(body.toJSONString());
		try {
			return new ResponseEntity<>(filter.filteredJobs(bodyMap), HttpStatus.OK);
		}
		catch(ParseException e) {
			throw new RuntimeException("Failed", e);
		}
	}
	
	
	/**
	 * Rotta di tipo GET che effettua il calcolo delle statistiche.
	 * Ci permette di generare statistiche sui lavori trovati, riguardanti la tipologia (quantità e percentuale di lavori in remoto e non), 
	 * gli altri linguaggi richiesti insieme al python
	 * @return Ritorna le statistiche effettuate.
	 */
	
	@GetMapping(value="/allStats")
	public ResponseEntity<Object> statsList() throws JobsNotFoundException{
		try {
			return new ResponseEntity<>(stats.getStats(), HttpStatus.OK);
		}catch(ParseException e) {
			System.out.println(e);
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	/**Rotta di tipo POST che effettua il filtraggio delle statistiche in base 
	 * ad una o più città, 
	 * data di creazione degli annunci, 
	 * grandezza azienda (in base al numero di impiegati).
	 * @return le statistiche che soddisfano le richieste.
	 */
	
	@PostMapping(value="/filterStats")
	public ResponseEntity<Object> filteredStats(@RequestBody JSONObject body) throws JobsNotFoundException, InvalidBodyException, java.text.ParseException, StatsErrorException{
		Map<String, Object> bodyMap = Parse.JSONStringToMap(body.toJSONString());
		try {
			return new ResponseEntity<>(filter.filteredStats(bodyMap), HttpStatus.OK);
		}
		catch(ParseException e) {
			throw new RuntimeException("Failed", e);
		}
	}
}
