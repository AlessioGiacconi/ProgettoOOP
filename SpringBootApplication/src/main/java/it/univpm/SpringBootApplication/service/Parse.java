package it.univpm.SpringBootApplication.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import java.lang.reflect.Type;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import it.univpm.SpringBootApplication.model.Job;
import it.univpm.SpringBootApplication.model.StatsParameters;
import it.univpm.SpringBootApplication.statistics.Languages;


public class Parse {
		
		Languages languages = new Languages();
	
		public ArrayList<Job> Parsing(String data) throws ParseException {
			JSONObject obj = new JSONObject();
			try {
				obj = (JSONObject)JSONValue.parseWithException(data);
			}catch(ParseException e) {
				e.printStackTrace();
			}
			JSONArray infoJob = (JSONArray) obj.get("results");
			ArrayList<Job> array = new ArrayList<Job>();
			for(Object o: infoJob)
			{
				if(o instanceof JSONObject)
				{
					JSONObject o1 = (JSONObject) o;
						try
						{
							long id = (long) o1.get("id");
							String company_name = (String) o1.get("company_name");
							String num_employees = (String) o1.get("company_num_employees");
							boolean remote = (boolean) o1.get("remote");
							String employment_type;
							if(o1.get("employment_type") != "null") {
								employment_type = (String) o1.get("employment_type");
							}else {
								employment_type = "Not specified";
							}
							String location = (String) o1.get("location");
							String url = (String) o1.get("url");
							String date = (String) o1.get("date_posted");
							ArrayList<String> keywords = (ArrayList<String>) o1.get("keywords");
							
							Job j = new Job(id, company_name, num_employees, location, remote, employment_type, url, date, keywords );
							array.add(j);
						}
						catch(Exception e) {
							System.out.println("An error occured during parament collection..");
							e.printStackTrace();	
						}	
			}
			
		}
			return array;
	}
		
		
	public static Map<String, Object> JSONStringToMap(String jsonObject){
		Type type = new TypeToken<Map<String,Object>>(){}.getType();
		Map<String,Object>  map = new Gson().fromJson(jsonObject, type);
		return map;
	}
	
	public ArrayList<StatsParameters> StatsParsing(String data, String location) throws ParseException{
		JSONObject obj = new JSONObject();
		try {
			obj = (JSONObject)JSONValue.parseWithException(data);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		JSONArray infoJob = (JSONArray) obj.get("results");
		ArrayList<StatsParameters> StatsArray = new ArrayList<StatsParameters>();
		Vector<String> languagesList = new Vector<String>();
		languagesList = languages.getLanguages();
		int cont_remote_true = 0;
		int cont_remote_false = 0;
		double perc_remote_true;
		double perc_remote_false;
		int cont_results = infoJob.size();
		int high_requested_language = 0;
		String language = new String();
		for(Object o : infoJob)
		{
			if(o instanceof JSONObject) {
				JSONObject o2 = (JSONObject) o;
					try {
								boolean remote = (boolean)o2.get("remote");
								ArrayList<String> keywords = (ArrayList<String>)o2.get("keywords");
								if(remote == true) {
									cont_remote_true++;
									}else cont_remote_false++;
								for(String k : keywords) {
									for(String l : languagesList) {
										int cont_lang = 0;
										int temp = 0;
										if(k.equals(l)) {
											cont_lang++;
										}
										temp = cont_lang;
										if(temp > high_requested_language) {
											high_requested_language = temp;
											language = k;
										}
									}
								}
					}catch(Exception e) {
						System.out.println("An error occured during parament collection..");
						e.printStackTrace();	
					}
					
			}
		}
		perc_remote_true = (cont_remote_true*100)/cont_results;
		perc_remote_false = (cont_remote_false*100)/cont_results;
		StatsParameters sp = new StatsParameters(location, cont_results, cont_remote_true, cont_remote_false, perc_remote_true, perc_remote_false, language);
		StatsArray.add(sp);
		return StatsArray;
	}
}
