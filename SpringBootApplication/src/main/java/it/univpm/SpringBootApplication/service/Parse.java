package it.univpm.SpringBootApplication.service;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.google.gson.*;

import it.univpm.SpringBootApplication.model.Job;

public class Parse {
		
		
		public JSONArray Parsing(String data, String city) throws ParseException {
			JSONArray objArr = null;
			try {
				objArr = (JSONArray)JSONValue.parseWithException(data);
			}catch (ParseException e) {
				e.printStackTrace();
			}
			
			ArrayList<Job> array = new ArrayList<Job>();
			for(Object o: objArr)
			{
				if(o instanceof JSONObject)
				{
					JSONObject o1 = (JSONObject) o;
						try
						{
							String id = (String) o1.get("id");
							String company_name = (String) o1.get("company_name");
							double num_employees = (double) o1.get("num_employees");
							boolean remote = (boolean) o1.get("remote");
							boolean employment_type = (boolean) o1.get("employment_type");
							String location = city;
							String date = (String) o1.get("date");
							String url = (String) o1.get("url");
							ArrayList<String> keywords = (ArrayList<String>) o1.get("keywords");
							
							Job j = new Job(id, company_name, num_employees, location, remote, employment_type, date, url, keywords );
							array.add(j);
						}
						catch(Exception e) {
							System.out.println("An error occured during parament collection..");
								
						}
					
			}
			
		}
			JSONArray jobList = new JSONArray();
			jobList = (JSONArray) JSONValue.parseWithException(ParsingToJSON(array));
			array.clear();
			return jobList;
		}
		
		public static String ParsingToJSON(ArrayList<?> param) {
			
			Gson out = new  GsonBuilder().setPrettyPrinting().create();
			String outFinal = out.toJson(param);
			return outFinal;
		}
}
