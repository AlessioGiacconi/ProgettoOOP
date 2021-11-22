package it.univpm.SpringBootApplication.filters;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import it.univpm.SpringBootApplication.exception.InvalidBodyException;
import it.univpm.SpringBootApplication.exception.JobsNotFoundException;
import it.univpm.SpringBootApplication.model.City;
import it.univpm.SpringBootApplication.model.Job;
import it.univpm.SpringBootApplication.service.ApiCall;
import it.univpm.SpringBootApplication.service.FindJobs;
import it.univpm.SpringBootApplication.service.Parse;
import it.univpm.SpringBootApplication.service.url;

public class Filter {

	ApiCall call = new ApiCall();
	Parse parse = new Parse();
	City c = new City();
	url u = new url();
	FindJobs fjobs = new FindJobs();
	
	public ArrayList<Job> filteredJobs(Map<String,Object> body) throws ParseException, InvalidBodyException, JobsNotFoundException {
		
		call.readAPIKey();
		ArrayList<Job> finalOutput = new ArrayList<Job>();
		String url = new String();
		String data = new String();
		Vector<String> cities = new Vector<String>();
		cities = c.getNames();
		boolean flag = false;
		for(String l : cities) {
			if (((String)body.get("location")).equals(l)) {
				flag = true;
			}
		}
		if ((flag == true) && (((String)body.get("employment_type")).equals("full time")) == true || (((String)body.get("employment_type")).equals("contract")) == true){
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
			finalOutput = fjobs.getJobs();
		}
	if(finalOutput.isEmpty()) {
		String msg = "Jobs not found..";
		throw new JobsNotFoundException(msg);
	}
	return finalOutput;
		}else {
			String msg = "An invalid body has been inserted..";
			throw new InvalidBodyException(msg);
		}
		
		
	}
}
