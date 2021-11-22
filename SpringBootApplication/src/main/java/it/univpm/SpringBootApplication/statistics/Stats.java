package it.univpm.SpringBootApplication.statistics;

import java.util.ArrayList;
import java.util.Vector;

import org.json.simple.parser.ParseException;

import it.univpm.SpringBootApplication.exception.JobsNotFoundException;
import it.univpm.SpringBootApplication.model.City;
import it.univpm.SpringBootApplication.model.StatsParameters;
import it.univpm.SpringBootApplication.service.ApiCall;
import it.univpm.SpringBootApplication.service.Parse;
import it.univpm.SpringBootApplication.service.url;

public class Stats {

		ApiCall call = new ApiCall();
		City c = new City();
		url u = new url();
		Parse parse = new Parse();
		Vector<String> languages = new Vector<String>();
		
		public ArrayList<StatsParameters> getStats() throws ParseException, JobsNotFoundException{
			
			call.readAPIKey();
			Vector<String> checkedCities = c.getNames();
			ArrayList<StatsParameters> s = new ArrayList<StatsParameters>();
			ArrayList<StatsParameters> allStats = new ArrayList<StatsParameters>();
			for(String l : checkedCities) {
				String url = u.Loc(l);
				String data = call.callAPI(url);
				s = parse.StatsParsing(data, l);
				allStats.addAll(s);
			}
			return allStats;
		}
}
