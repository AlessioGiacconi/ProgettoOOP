package it.univpm.SpringBootApplication.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import it.univpm.SpringBootApplication.model.City;
import it.univpm.SpringBootApplication.model.Job;
import it.univpm.SpringBootApplication.service.url;

public class FindJobs {
	
		ApiCall call = new ApiCall();
		Parse parse = new Parse();
		City c = new City();
		url u = new url();
		
	public ArrayList<Job> getJobs() throws ParseException {
			
		call.readAPIKey();
		Vector<String> checkedCities = c.getNames();
		ArrayList<Job> a = new ArrayList<Job>();
		for(String s : checkedCities) {
			String url = u.Loc(s);
			String data = call.callAPI(url);
			a = parse.Parsing(data);
			}
		return a;
	}
	
	/*public JSONArray filteredJobs(Map<String,Object> body) throws ParseException {
		
		JSONArray finalOutput = new JSONArray();
		if((body.get("location") != null) && (body.get("remote") != null) && (body.get("employment_type") != null)) {
			String url = u.LocRemPtFt((String)body.get("location"), (boolean)body.get("remote"), (boolean)body.get("employment_type"));
			String data = call.callAPI(url);
			finalOutput = parse.Parsing(data);
		}else if((body.get("location") != null) && (body.get)
	}*/
	
}
