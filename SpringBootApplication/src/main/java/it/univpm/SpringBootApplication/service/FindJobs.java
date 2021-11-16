package it.univpm.SpringBootApplication.service;

import java.util.Vector;

import it.univpm.SpringBootApplication.model.City;
import it.univpm.SpringBootApplication.model.Job;

public class FindJobs {
	
		ApiCall call;
		Parse parse;
		City c;
		
	public Job getJobs(String city) {
		
		String ApiKey = call.readAPIKey();
		String url = "https://findwork.dev/api/jobs/?location" + city + "&search=react&sort_by=relevance" + ApiKey; //controllare se serve apikey nell url
		String data = call.callAPI(url);
		Job j = parse.Parsing(data, city);
		/*Vector<String> cities = new Vector<String>(c.getNames());
		for(int i=0; i<cities.size(); i++)
			if(cities.get(i).equalsIgnoreCase(city)) {
				
			}**/
		return j;
	}
}
