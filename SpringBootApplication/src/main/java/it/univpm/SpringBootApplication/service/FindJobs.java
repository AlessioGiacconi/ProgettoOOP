package it.univpm.SpringBootApplication.service;

import java.util.ArrayList;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import it.univpm.SpringBootApplication.exception.JobsNotFoundException;
import it.univpm.SpringBootApplication.model.City;
import it.univpm.SpringBootApplication.model.Job;

/**
 * Classe per la ricerca di tutte le offerte di lavoro.
 * @author Alessio Giacconi
 * @author Erxhes Dedja
 */


public class FindJobs {
	
		ApiCall call = new ApiCall();
		Parse parse = new Parse();
		City c = new City();
		url u = new url();
	
	/**
        * Metodo che permette di ottenere tutte le offerte di lavoro a partire dall'url che forniamo.
        * @return allJobs tutti i lavori trovati
        * @throws JobsNotFoundException Eccezione personalizzata nel caso in cui il lavoro non fosse trovato
        * @throws ParseException Eccezione generata nel caso in cui si verifichino errori nel parsing dei dati
        */
		
	public ArrayList<Job> getJobs() throws ParseException, JobsNotFoundException {
			
		call.readAPIKey();
		Vector<String> checkedCities = c.getNames();
		ArrayList<Job> a = new ArrayList<Job>();
		ArrayList<Job> allJobs = new ArrayList<Job>();
		for(String s : checkedCities) {
			String url = u.Loc(s);
			String data = call.callAPI(url);
			a = parse.Parsing(data);
			allJobs.addAll(a);
			}
		return allJobs;
	}
	
}
