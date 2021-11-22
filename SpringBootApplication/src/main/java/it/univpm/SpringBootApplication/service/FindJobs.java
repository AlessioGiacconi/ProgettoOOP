package it.univpm.SpringBootApplication.service;

import java.util.ArrayList;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import it.univpm.SpringBootApplication.model.City;
import it.univpm.SpringBootApplication.model.Job;


public class FindJobs {
	
		ApiCall call = new ApiCall();
		Parse parse = new Parse();
		City c = new City();
		url u = new url();
		
	public ArrayList<Job> getJobs() throws ParseException {
			
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
