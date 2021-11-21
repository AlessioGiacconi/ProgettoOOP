package it.univpm.SpringBootApplication.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import it.univpm.SpringBootApplication.exception.JobsNotFoundException;
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
		ArrayList<Job> allJobs = new ArrayList<Job>();
		for(String s : checkedCities) {
			String url = u.Loc(s);
			String data = call.callAPI(url);
			a = parse.Parsing(data);
			allJobs.addAll(a);
			}
		return allJobs;
	}
	
	public ArrayList<Job> filteredJobs(Map<String,Object> body) throws ParseException {
			
		ArrayList<Job> finalOutput = new ArrayList<Job>();
		String url = new String();
		String data = new String();
		if((body.get("location") != null) && (body.get("remote") != null) && (body.get("employment_type") != null)) {
			url = u.LocRemPtFt((String)body.get("location"), (boolean)body.get("remote"), (String)body.get("employment_type"));
			data = call.callAPI(url);
			finalOutput = parse.Parsing(data);
		}else if((body.get("location") != null) && (body.get("remote") != null) && (body.get("employment_type") == null)) {
			url = u.LocRem((String)body.get("location"), (boolean)body.get("remote"));
			data = call.callAPI(url);
			finalOutput = parse.Parsing(data);
		}else if((body.get("location") != null) && (body.get("remote") == null) && (body.get("employment_type") == null)) {
			url = u.Loc((String)body.get("location"));
			data = call.callAPI(url);
			finalOutput = parse.Parsing(data);
		}else if((body.get("location") != null) && (body.get("remote") == null) && (body.get("employment_type") != null)) {
			url = u.LocPtFt((String)body.get("location"), (String)body.get("employment_type"));
			data = call.callAPI(url);
			finalOutput = parse.Parsing(data);
		}else if((body.get("location") == null) && (body.get("remote") != null) && (body.get("employment_type") == null)) {
			Vector<String> checkedCities = c.getNames();
			for(String s : checkedCities) {
					url = u.LocRem(s, (boolean)body.get("remote"));
					data = call.callAPI(url);
					ArrayList<Job> output = parse.Parsing(data);
					finalOutput.addAll(output);
			}
		}else if((body.get("location") == null) && (body.get("remote") == null) && (body.get("employment_type") != null)) {
			Vector<String> checkedCities = c.getNames();
			for(String s : checkedCities) {
				url = u.LocPtFt(s, (String)body.get("employment_type"));
				data = call.callAPI(url);
				ArrayList<Job> output = parse.Parsing(data);
				finalOutput.addAll(output);
			}	
		}else if(body.isEmpty()) {
			finalOutput = getJobs();
		}
	return finalOutput;
		
	}
	
}
