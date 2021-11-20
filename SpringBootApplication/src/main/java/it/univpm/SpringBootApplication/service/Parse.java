package it.univpm.SpringBootApplication.service;

import java.util.ArrayList;
import java.util.Map;
import java.lang.reflect.Type;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import it.univpm.SpringBootApplication.model.Job;

public class Parse {
		
		Job job = new Job();
	
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
}
