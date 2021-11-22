package it.univpm.SpringBootApplication.model;

import java.util.Vector;

public class StatsParameters {

	private String location;
	private int cont_results;
	private int n_remote_true;
	private int n_remote_false;
	private double perc_remote_true;
	private double perc_remote_false;
	private String high_requested_language;
		
	Vector<String> languages = new Vector<String>();
	
	public StatsParameters() {
		
	}
	
	public StatsParameters(String location, int cont_results, int n_remote_true, int n_remote_false, double perc_remote_true, double perc_remote_false, String high_requested_language) {
		
		this.location = location;
		this.cont_results = cont_results;
		this.n_remote_true = n_remote_true;
		this.n_remote_false = n_remote_false;
		this.perc_remote_true = perc_remote_true;
		this.perc_remote_false = perc_remote_false;
		this.high_requested_language = high_requested_language;	
	}
	
	
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getCont_results() {
		return cont_results;
	}
	
	public void setCont_results(int cont_results) {
		this.cont_results = cont_results;
	}
	
	public double getN_remote_true() {
		return n_remote_true;
	}
	
	public void setN_remote_true(int n_remote_true) {
		this.n_remote_true = n_remote_true;
	}
	
	public double getN_remote_false() {
		return n_remote_false;
	}
	
	public void setN_remote_false(int n_remote_false) {
		this.n_remote_false = n_remote_false;
	}
	
	public double getPerc_remote_true() {
		return perc_remote_true;
	}
	
	public void setPerc_remote_true(double perc_remote_true) {
		this.perc_remote_true = perc_remote_true;
	}
	
	public double getPerc_remote_false() {
		return perc_remote_false;
	}
	
	public void setPerc_remote_false(double perc_remote_false) {
		this.perc_remote_false = perc_remote_false;
	}
	
	public String getHigh_requested_language() {
		return high_requested_language;
	}
	
	public void setHigh_requested_language(String high_requested_language) {
		this.high_requested_language = high_requested_language;
	}
	
	
	
}
