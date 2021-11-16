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

public class ApiCall {

		public String callAPI(String url) {
			String data = "";
			String line = "";
			try {
				URLConnection openConnection = new URL(url).openConnection();
				InputStream in = openConnection.getInputStream();
				
				
				try {
						BufferedReader buf = new BufferedReader(new InputStreamReader(in));
						while((line = buf.readLine() ) != null) {
							data += line;
						}
				}finally {
					in.close();
				}
			}catch(Exception e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Città non trovata");
			}
			return data;
		}
		
		
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
