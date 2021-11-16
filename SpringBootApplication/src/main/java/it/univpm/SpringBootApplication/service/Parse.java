package it.univpm.SpringBootApplication.service;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import it.univpm.SpringBootApplication.model.Job;

public class Parse {
		
		Job job;
		
		public Job Parsing(String data, String city) {
			JSONObject obj = null;
			try {
				obj = (JSONObject)JSONValue.parseWithException(data);
			}catch (ParseException e) {
				e.printStackTrace();
			}
			
			JSONObject infoJobs = (JSONObject) obj.get("sys");
			
			job.setLocation(city);
			
			String id = (String)infoJobs.get("id");
			job.setId(id);
			
			String company_name = (String)infoJobs.get("company_name");
			job.setCompany_name(company_name);
			
			double num_employees = (double)infoJobs.get("num_employees");
			job.setNum_employees(num_employees);
			
			String remote = (String)infoJobs.get("remote");
			if (remote == "true") {
				job.setRemote(true);
			}else {
				job.setRemote(false);
			}
			
			String employment_type = (String)infoJobs.get("employment_type");
			if (employment_type == "true") {
				job.setEmployment_type(true);
			}else {
				job.setEmployment_type(false);
			}
			
			String date = (String)infoJobs.get("date");
			job.setDate(date);
			
			String url = (String)infoJobs.get("url");
			job.setUrl(url);
			
			ArrayList<String> keywords = (ArrayList<String>)infoJobs.get("keywords");
			job.setKeywords(keywords);
			
			return job;
			
		}
		
}
