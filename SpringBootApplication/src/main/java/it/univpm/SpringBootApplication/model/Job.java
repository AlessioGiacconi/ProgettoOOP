package it.univpm.SpringBootApplication.model;

import java.util.ArrayList;

public class Job {
	

	private long id;
	private String company_name;
	private double num_employees;
	private String location;
	private boolean remote;
	private String employment_type;
	private String date;
	private String url;
	private ArrayList<String> keywords = new ArrayList<String>();
	
	public Job() {
		
	}
	
	public Job(long id, String company_name, double num_employees, String location, boolean remote, String employment_type, String url, String date, ArrayList<String> keywords) {
		this.id = id;
		this.company_name = company_name;
		this.num_employees = num_employees;
		this.location = location;
		this.remote = remote;
		this.employment_type = employment_type;
		this.date = date;
		this.url = url;
		this.keywords = keywords;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCompany_name() {
		return company_name;
	}

	
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	
	public double getNum_employees() {
		return num_employees;
	}
	
	public void setNum_employees(double num_employees) {
		this.num_employees = num_employees;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public boolean isRemote() {
		return remote;
	}
	
	public void setRemote(boolean remote) {
		this.remote = remote;
	}
	
	public String getEmployment_type() {
		return employment_type;
	}
	
	public void setEmployment_type(String employment_type) {
		this.employment_type = employment_type;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public ArrayList<String> getKeywords() {
		return keywords;
	}
	
	public void setKeywords(ArrayList<String> keywords) {
		this.keywords = keywords;
	}
}
