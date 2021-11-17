package it.univpm.SpringBootApplication.service;

import java.util.ArrayList;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import it.univpm.SpringBootApplication.model.City;
import it.univpm.SpringBootApplication.model.Job;

public class FindJobs {
	
		ApiCall call;
		Parse parse;
		City c;
		
	public JSONArray getJobs(String city) throws ParseException {
		
		String ApiKey = call.readAPIKey();
		String url = "https://findwork.dev/api/jobs/?location" + city + "&search=react&sort_by=relevance"; //controllare se serve apikey nell url
		String data = call.callAPI(url);
		JSONArray j = parse.Parsing(data, city);
		
		return j;
		
	}
}
