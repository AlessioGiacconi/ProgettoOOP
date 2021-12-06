package it.univpm.SpringBootApplication.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


/** classe che modella le città
 * 
 * @author Alessio Giacconi
 * @author Erxhes Dedja
 */

public class City {
		
	private String description;
	private Vector<String> names = new Vector<String>();
	
	public City() {
		this.setDescription("Monitored cities:");
	}
	
/** metodo che permette di ottente il nome della città tra le 5 presenti nell'archivio.
 */
	
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
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "An error occured reading the file..");
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
