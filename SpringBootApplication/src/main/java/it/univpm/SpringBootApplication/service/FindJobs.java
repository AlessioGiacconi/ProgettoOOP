package it.univpm.SpringBootApplication.service;

import java.util.Map;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import it.univpm.SpringBootApplication.model.City;
import it.univpm.SpringBootApplication.model.Job;
import it.univpm.SpringBootApplication.service.url;

public class FindJobs {
	
		ApiCall call;
		Parse parse;
		City c;
		url u;
		
	public JSONArray getJobs() throws ParseException {
			
		String APIKey = call.readAPIKey();
		Vector<String> checkedCities = c.getNames();
		JSONArray j = new JSONArray();
		
		for(String s : checkedCities) {
			String url = u.Loc(s);
			String data = call.callAPI(url);
			j = parse.Parsing(data);
		}
		return j;
	}
	
	public JSONArray filteredJobs(Map<String,Object> body) throws ParseException {
		
		JSONArray finalOutput = new JSONArray();
		if((body.get("location") != null) && (body.get("remote") != null) && (body.get("employment_type") != null)) {
			String url = u.LocRemPtFt((String)body.get("location"), (boolean)body.get("remote"), (boolean)body.get("employment_type"));
			String data = call.callAPI(url);
			finalOutput = parse.Parsing(data);
		}else if((body.get("location") != null) && (body.get)
	}
	
}
