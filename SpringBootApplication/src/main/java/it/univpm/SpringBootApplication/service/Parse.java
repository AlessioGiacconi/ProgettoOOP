package it.univpm.SpringBootApplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Vector;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import it.univpm.SpringBootApplication.exception.JobsNotFoundException;
import it.univpm.SpringBootApplication.model.Job;
import it.univpm.SpringBootApplication.model.StatsParameters;
import it.univpm.SpringBootApplication.statistics.Languages;


/**
 * Classe per effettuare conversioni e la lettura del formato JSON.
 * @author Alessio Giacconi
 * @author Erxhes Dedja
 **/

public class Parse {
		
		Languages languages = new Languages();
	
	       /**
            * Metodo per parsare i dati.
            * @param data Stringa contentente i dati da parsare
            * @return array
            * @throws ParseException se avvengono errori durante il parsing dei dati
            **/
	       
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
		
	/**
	 * Metodo statico per la conversione di un JSONString in MAP
	 * @param jsonObject Stringa da convertire in Map
	 * @return Map Map derivante dalla conversione
	 */
		
	public static Map<String, Object> JSONStringToMap(String jsonObject){
		Type type = new TypeToken<Map<String,Object>>(){}.getType();
		Map<String,Object>  map = new Gson().fromJson(jsonObject, type);
		return map;
	}
	
	/**Metodo ottenere le statistiche di un lavoro.
	 * @param location città tra quelle presenti su cui è stata fatta la statistica
	 * @param data Stringa contenente i dati da parsare.
	 * @throws ParseException se il parsing del body porta a delle eccezioni.
	 * @throws JobsNotFoundException se il lavoro non è stato trovato.
	 * @return Statsarray ritorna le statistiche riguardanti le offerte di lavoro una volta scelta la città
	 */
	
	public ArrayList<StatsParameters> StatsParsing(String data, String location) throws ParseException, JobsNotFoundException{
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
		StatsParameters sp;
		if(cont_results == 0) {
			sp = new StatsParameters(location, 0,  0, 0, 0.0, 0.0, "");
		}else {
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
										if(k.equalsIgnoreCase(l)) {
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
						System.out.println("An error occured during parameter collection..");
						e.printStackTrace();	
					}
					
			}
		}
		perc_remote_true = (cont_remote_true*100)/cont_results;
		perc_remote_false = (cont_remote_false*100)/cont_results;
		sp = new StatsParameters(location, cont_results, cont_remote_true, cont_remote_false, perc_remote_true, perc_remote_false, language);
		}
		
		StatsArray.add(sp);
		return StatsArray;
	}
	
	/**Metodo ottenere il filtraggio delle statistiche di un lavoro.
	 * @param location città tra quelle presenti su cui è stata fatta la statistica
	 * @param data Stringa contentente i dati da parsare
	 * @param date_posted data di annuncio dell'offerta di lavoro
	 * @throws java.text.ParseException se avvengono degli errori durante il parsing dei dati
	 * @throws JobsNotFoundException se il lavoro non è stato trovato
	 * @return FilteredStatsArray ritorna le statistiche filtrate
	 */
	
	public ArrayList<StatsParameters> StatsParsing(String data, String location, String date_posted) throws java.text.ParseException, JobsNotFoundException{
		JSONObject obj = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			obj = (JSONObject)JSONValue.parseWithException(data);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		JSONArray infoJob = (JSONArray) obj.get("results");
		JSONArray infoJobFiltered = new JSONArray();
		ArrayList<StatsParameters> FilteredStatsArray = new ArrayList<StatsParameters>();
		int cont_remote_true = 0;
		int cont_remote_false = 0;
		double perc_remote_true;
		double perc_remote_false;
		Vector<String> languagesList = new Vector<String>();
		int high_requested_language = 0;
		languagesList = languages.getLanguages();
		String language = new String();
		StatsParameters fsp;
		for(Object o : infoJob) {
			if(o instanceof JSONObject) {
				JSONObject o3 = (JSONObject) o;
				String date = ((String)o3.get("date_posted")).substring(0,10);
				Date date_posted_converted = sdf.parse(date_posted);
				Date date_object = sdf.parse(date);
				if(date_object.after(date_posted_converted)) {
					infoJobFiltered.add(o3);
				}
			}
		}
		int cont_results = infoJobFiltered.size();
		if(cont_results == 0) {
			fsp = new StatsParameters(location, 0,  0, 0, 0.0, 0.0, "");
		}else {
					for(Object o : infoJobFiltered)
		{
			if(o instanceof JSONObject) {
				JSONObject o4 = (JSONObject) o;
				try {
					boolean remote = (boolean)o4.get("remote");
					ArrayList<String> keywords = (ArrayList<String>)o4.get("keywords");
					if(remote == true) {
						cont_remote_true++;
					}else cont_remote_false++;
					for(String k : keywords) {
						for(String l : languagesList) {
							int cont_lang = 0;
							int temp = 0;
							if(k.equalsIgnoreCase(l)) {
								cont_lang++;
							}
							temp = cont_lang;
							if(temp > high_requested_language) {
								high_requested_language = temp;
								language = l;
							}
						}
					}
				}catch(Exception e){
					System.out.println("An error occured during parameter collection..");
					e.printStackTrace();
				}
			}
		}
		perc_remote_true = (cont_remote_true*100)/cont_results;
		perc_remote_false = (cont_remote_false*100)/cont_results;
		fsp = new StatsParameters(location, cont_results, cont_remote_true, cont_remote_false, perc_remote_true, perc_remote_false, language, date_posted);
		}

		FilteredStatsArray.add(fsp);
		return FilteredStatsArray;
	}
}
