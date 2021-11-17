package it.univpm.SpringBootApplication.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import it.univpm.SpringBootApplication.model.City;


public class FindJobs {
	
		ApiCall call;
		Parse parse;
		City c;
		
	public JSONArray getJobs(String city) throws ParseException {
			
		call.readAPIKey();
		String url = "https://findwork.dev/api/jobs/?search=python&source=&location" + city + "&sort_by=relevance"; //controllare se serve apikey nell url
		String data = call.callAPI(url);
		JSONArray j = parse.Parsing(data, city);
	
		return j;
		
	}
	
	public Vector<String> getCities(){
		Vector<String> cities = new Vector<String>();
		try {
			Scanner fileIn = new Scanner(new BufferedReader(new FileReader("doc/" + "Cities.txt")));
			while(fileIn.hasNext()) {
				cities.add(fileIn.nextLine());
			}
			fileIn.close();
		}catch (IOException e) {
			System.out.println("I/O error..");
			System.out.println(e);
		}
		return cities;
 	}
	
	
}
