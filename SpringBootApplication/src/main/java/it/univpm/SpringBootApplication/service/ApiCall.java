package it.univpm.SpringBootApplication.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import it.univpm.SpringBootApplication.exception.JobsNotFoundException;

/**
        * Classe che implementa la chiamata alla API di FindWork
	*@author Alessio Giacconi
        *@author Erxhes Dedja
        **/

public class ApiCall {

		public String callAPI(String url) throws JobsNotFoundException {
			String data = "";
			String line = "";
			try {
				URLConnection openConnection = new URL(url).openConnection();
				openConnection.addRequestProperty("Authorization", "Token 16fa75d7c00de59be60942dc58aa75b4bce18639");
				openConnection.setRequestProperty("Content-Type", "application/json");
				openConnection.setRequestProperty("Accept","application/json");
				openConnection.setDoOutput(true);
				InputStream in = openConnection.getInputStream();
				
				try {
						BufferedReader buf = new BufferedReader(new InputStreamReader(in));
						while((line = buf.readLine() ) != null) {
							data += line;
						}
				}finally {
					in.close();
				}
				if(data.isEmpty()) {
					throw new JobsNotFoundException();
				}
			}
			catch(IOException e) {
				String msg = "Jobs not found, location invalid..";
				throw new JobsNotFoundException(msg);
			}
			
			return data;
		}
		
	        /**
                * metodo che permette di utilizzare l'APIKey presente nel fil "doc"
                * @return APIKey
                **/
		
		public String readAPIKey() {
			String APIKey;
			try {
				BufferedReader fileR = new BufferedReader(new FileReader("doc/" + "ApiKey.txt"));
				APIKey = fileR.readLine();
				if(APIKey == null) {
					fileR.close();
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "API Key not found in file.. ");
				}
				fileR.close();
			}catch(IOException e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File not found.. ");
			}
			return APIKey;
		}
}
