package it.univpm.SpringBootApplication.statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
Classe utilizata per ottenere un tipo di linguaggio tra quelli offerti dall'applicazione.
@author Alessio Giacconi
@author Erxhes Dedja
**/

public class Languages {

	Vector<String> languages = new Vector<String>();
	
	public Vector<String> getLanguages(){
		String next;
		try {
			BufferedReader fileR = new BufferedReader(new FileReader("doc/" + "Languages.txt"));
			do {
				next = fileR.readLine();
				if (next != null) {
					languages.add(next);
				}
			}while(next != null);
			fileR.close();
		}catch(IOException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Errore lettura file..");
		}
		return languages;
	}
}
