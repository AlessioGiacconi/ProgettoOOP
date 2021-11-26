package it.univpm.SpringBootApplication.filters;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import it.univpm.SpringBootApplication.exception.InvalidBodyException;
import it.univpm.SpringBootApplication.exception.JobsNotFoundException;
import it.univpm.SpringBootApplication.exception.StatsErrorException;
import it.univpm.SpringBootApplication.model.City;
import it.univpm.SpringBootApplication.model.Job;
import it.univpm.SpringBootApplication.model.StatsParameters;
import it.univpm.SpringBootApplication.service.ApiCall;
import it.univpm.SpringBootApplication.service.FindJobs;
import it.univpm.SpringBootApplication.service.Parse;
import it.univpm.SpringBootApplication.service.url;
import it.univpm.SpringBootApplication.statistics.Stats;


/**
 * Classe contenente metodi per il filtraggio delle offerte di lavoro.
 * @author Alessio Giacconi
 * @author Erxhes Dedja
 *
 */

public class Filter {

	ApiCall call = new ApiCall();
	Parse parse = new Parse();
	City c = new City();
	url u = new url();
	FindJobs fjobs = new FindJobs();
	Stats stats = new Stats();
	Vector<String> cities = c.getNames();
	
	/**
	 * Metodo che restituisce gli url con tutti i lavori filtrati in base alle richieste possibili.
	 * @return ArrayList contenente gli url filtrati in base alle richieste possibili.
	 * @throws InvalidBodyException body vuoto o null.
	 * @throws JobsNotFoundException nel caso in cui non viene trovato un lavoro con i filtri richiesti.
	 */
	
	
	public ArrayList<Job> filteredJobs(Map<String,Object> body) throws ParseException, InvalidBodyException, JobsNotFoundException {
		
		call.readAPIKey();
		ArrayList<Job> finalOutput = new ArrayList<Job>();
		String url = new String();
		String data = new String();
		boolean flag = false;
		
		if (body.isEmpty()) {
			
			finalOutput = fjobs.getJobs();
			
		} else {
			
			if(((String)body.get("location")).equals("")) {
				
				flag = true;
			}
			
			for(String l : cities) {
				
			if (((String)body.get("location")).equalsIgnoreCase(l)) {
				
				flag = true;
			}
		}
		if ((flag == true) && (((String)body.get("employment_type")).equalsIgnoreCase("full time")) == true || (((String)body.get("employment_type")).equalsIgnoreCase("contract")) == true  || (((String)body.get("employment_type")).equals(""))){
			
			if((body.get("location") != "") && (body.get("remote") != null) && (body.get("employment_type") != "")) {
				
			url = u.LocRemPtFt((String)body.get("location"), (boolean)body.get("remote"), (String)body.get("employment_type"));
				
			data = call.callAPI(url);
				
			finalOutput = parse.Parsing(data);
				
		}
			else 
			        if((body.get("location") != "") && (body.get("remote") != null) && (body.get("employment_type") == "")) {
				
			        url = u.LocRem((String)body.get("location"), (boolean)body.get("remote"));
				
			        data = call.callAPI(url);
				
			        finalOutput = parse.Parsing(data);
				
		}       else 
		  		if((body.get("location") != "") && (body.get("remote") == null) && (body.get("employment_type") == "")) {
					
			        url = u.Loc((String)body.get("location"));
					
			        data = call.callAPI(url);
					
			       finalOutput = parse.Parsing(data);
			
					
		}      else 
			      if((body.get("location") != "") && (body.get("remote") == null) && (body.get("employment_type") != "")) {
				      
			      url = u.LocPtFt((String)body.get("location"), (String)body.get("employment_type"));
				      
			      data = call.callAPI(url);
				      
			      finalOutput = parse.Parsing(data);
				 
		}else if((body.get("location") == "") && (body.get("remote") != null) && (body.get("employment_type") == "")) {
				
			for(String s : cities) {
				
					url = u.LocRem(s, (boolean)body.get("remote"));
				
					data = call.callAPI(url);
				
					ArrayList<Job> output = parse.Parsing(data);
				
					finalOutput.addAll(output);
			}
				
		} else 
			if((body.get("location") == "") && (body.get("remote") == null) && (body.get("employment_type") != "")) { 
				
			 for(String s : cities) {
				 
				url = u.LocPtFt(s, (String)body.get("employment_type"));
				 
				data = call.callAPI(url);
				 
				ArrayList<Job> output = parse.Parsing(data);
				 
				finalOutput.addAll(output);
			}	
				
		}else 
			if((body.get("location") == "") && (body.get("remote") != null) && (body.get("employment_type") != "")) {
				
			for(String s : cities) {
				
				url = u.LocRemPtFt(s, (boolean)body.get("remote"), (String)body.get("employment_type"));
				
				data = call.callAPI(url);
				
				ArrayList<Job> output = parse.Parsing(data);
				
				finalOutput.addAll(output);
			}
		}
	if(finalOutput.isEmpty()) {
		
		String msg = "Jobs not found..";
		
		throw new JobsNotFoundException(msg);
	}
		}
			else {
				
			throw new InvalidBodyException("An invalid body has been inserted..");
		}
			
		}
		
	return finalOutput;	
		
		
	}
	
	/**
	 * Metodo che restituisce le statistiche filtrate in base a location, num_employees e date.
	 * @return ArrayList contenente gli url con le statistiche filtrate in base alle richieste possibili.
	 */

	
	
	public ArrayList<StatsParameters> filteredStats(Map<String,Object> body) throws ParseException, JobsNotFoundException, InvalidBodyException, java.text.ParseException, StatsErrorException{
		
		call.readAPIKey();
		String url = new String();
		String data = new String();
		ArrayList<StatsParameters> finalOutputStats = new ArrayList<StatsParameters>();
		boolean flag = false; 
		
		if(body.isEmpty()) {
			finalOutputStats = stats.getStats();
			
		} else {
			
			if(((String)body.get("location")).equals("")) {
				
				flag = true;
			}
			
			for(String s : cities) {
				
				if(((String)body.get("location")).equalsIgnoreCase(s)) {
					
					flag = true;
				}
			}
			
			if(((String)body.get("date")).length() > 10) {
				
				String msg = "An invalid body has been inserted..";
				
				throw new InvalidBodyException(msg);
				
			}
			
		if((flag == true) && (((String)body.get("num_employees")).equals("1-10") == true || ((String)body.get("num_employees")).equals("11-50") == true || ((String)body.get("num_employees")).equals("51-100") == true || ((String)body.get("num_employees")).equals("101-250") == true || ((String)body.get("num_employees")).equals("") == true)){
			if((body.get("location") != "") && (body.get("num_employees") != "") && (body.get("date") != "")){
				
			url = u.LocNumEmp((String)body.get("location"), (String)body.get("num_employees"));
				
			data = call.callAPI(url);
				
			finalOutputStats = parse.StatsParsing(data, (String)body.get("location"), (String)body.get("date"));
				
		} else 
			if((body.get("location") != "") && (body.get("num_employees") != "") && (body.get("date") == "")) {
				
			url = u.LocNumEmp((String)body.get("location"),(String)body.get("num_employees"));
				
			data = call.callAPI(url);
				
			finalOutputStats = parse.StatsParsing(data, (String)body.get("location"));
				
		} else 
			if((body.get("location") != "") && (body.get("num_employees") == "") && (body.get("date") == "")) {
				
			url = u.Loc((String)body.get("location"));
				
			data = call.callAPI(url);
				
			finalOutputStats = parse.StatsParsing(data, (String)body.get("location"));
				
		} else 
			if((body.get("location") == "") && (body.get("num_employees") != "") && (body.get("date") == "")) {
				
			for(String s : cities) {
				
				url = u.LocNumEmp(s, (String)body.get("num_employees"));
				
				data = call.callAPI(url);
				
				ArrayList<StatsParameters> OutputStats = parse.StatsParsing(data, s);
				
				finalOutputStats.addAll(OutputStats);
				
			}
		 }else 
			if((body.get("location") == "") && (body.get("num_employees") != "") && (body.get("date") != "")) {
				
			for(String s : cities) {
				
				url = u.LocNumEmp(s, (String)body.get("num_employees"));
				
				data = call.callAPI(url);
				
				ArrayList<StatsParameters> OutputStats = parse.StatsParsing(data, s, (String)body.get("date"));
				
				finalOutputStats.addAll(OutputStats);
			}
		} else 
			if((body.get("location") != "") && (body.get("num_employees") == "") && (body.get("date") != "")) {
				
			url = u.Loc((String)body.get("location"));
				
			data = call.callAPI(url);
				
			finalOutputStats = parse.StatsParsing(data, (String)body.get("location"), (String)body.get("date"));
				
		} else
			if((body.get("location") == "") && (body.get("num_employees") == "") && (body.get("date") != "")) {
				
			for(String s : cities) {
				
				url = u.Loc(s);
				
				data = call.callAPI(url);
				
				ArrayList<StatsParameters> OutputStats = parse.StatsParsing(data, s, (String)body.get("date"));
				
				finalOutputStats.addAll(OutputStats);
			}
		}
			
		if(finalOutputStats.isEmpty()) {
			String msg = "An error occured during elaboration of stats..";
			throw new StatsErrorException(msg);
		}
			 
		} else {
			
			String msg = "An invalid body has been inserted..";
			
			throw new InvalidBodyException(msg);
		}
		}
		return finalOutputStats;
	}
}

