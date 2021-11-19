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
		
		Job job;
	
		public JSONArray Parsing(String data) throws ParseException {
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
							String location = (String) o1.get("location");
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
		
		/*public Job Parsing(String data) {
			JSONObject obj = null;
			try {
				obj = (JSONObject)JSONValue.parseWithException(data);
			}catch(ParseException e) {
				e.printStackTrace();
			}
			JSONObject infoJob = (JSONObject) obj.get("sys");
			String id = (String)infoJob.get("id");
			job.setId(id);
			String company_name = (String)infoJob.get("company_name");
			job.setCompany_name(company_name);
			double num_employees = (double)infoJob.get("num_employees");
			job.setNum_employees(num_employees);
			String location = (String)infoJob.get("location");
			job.setLocation(location);
			boolean remote = (boolean)infoJob.get("remote");
			job.setRemote(remote);
			boolean employment_type = (boolean)infoJob.get("employment_type");
			job.setEmployment_type(employment_type);
			String date = (String)infoJob.get("date");
			job.setDate(date);
			String url = (String)infoJob.get("url");
			job.setUrl(url);
			ArrayList<String> keywords = (ArrayList<String>)infoJob.get("keywords");
			job.setKeywords(keywords);
			
			return job;
		}*/
		
		public static String ParsingToJSON(ArrayList<?> param) {
			Gson out = new  GsonBuilder().setPrettyPrinting().create();
			String outFinal = out.toJson(param);
			return outFinal;
		}
		
		public static Map<String, Object> JSONStringToMap(String jsonObject){
			Type type = new TypeToken<Map<String,Object>>(){}.getType();
			Map<String,Object>  map = new Gson().fromJson(jsonObject, type);
			return map;
		}
}
