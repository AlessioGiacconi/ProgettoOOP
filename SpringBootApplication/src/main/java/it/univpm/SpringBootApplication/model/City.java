package it.univpm.SpringBootApplication.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class City {
		
	private String description;
	private Vector<String> names = new Vector<String>();
	
	public City() {
		this.setDescription("Monitored cities:");
		Vector<String> names = this.getNames();
		for(String n : names) {
			System.out.println(n);
		}
	}
	
	public Vector<String> getNames(){
		String next;
		try {
			BufferedReader fileR = new BufferedReader(new FileReader("doc/" + "Cities.txt"));
			do {
				next = fileR.readLine();
				if (next != null) {
					names.add(next);
				}
			}while(next != null);
			fileR.close();
		}catch(IOException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Errore lettura file..");
		}
		return names;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
