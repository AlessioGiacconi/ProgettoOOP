package it.univpm.SpringBootApplication.service;

public class url {
	
	private static String urlJobs = "https://findwork.dev/api/jobs/?search=python&source=";
	
	public url() {
		
	}
	
	public static void setUrlJobs(String url) {
		urlJobs = url;
	}
	
	public String getUrlJobs() {
		return urlJobs;
	}
	
	public String Loc(String loc) {
		loc = loc.replace(" ","+");
		return urlJobs + "&location=" + loc;
	}
	
	public String Rem(boolean rem) {
		return urlJobs + "&remote=" + rem;
	}
	
	public String PTimeFTime (String PtFt) {
		PtFt = PtFt.replace(" ", "+");
		return urlJobs + "&employment_type=" + PtFt; 	
	}
	
	public String LocRem(String loc, boolean rem) {
		loc= loc.replace(" ","+");
		return urlJobs + "&location=" + loc + "&remote=" + rem;
	}
	
	public String LocPtFt(String loc, String PtFt) {
		loc = loc.replace(" ", "+");
		PtFt = PtFt.replace(" ","+");
		return urlJobs + "&location=" + loc + "&employment_type=" + PtFt;
	}
	
	public String LocRemPtFt(String loc, boolean rem, String PtFt) {
		loc = loc.replace(" ", "+");
		PtFt = PtFt.replace(" ","+");
		return urlJobs + "&location=" + loc + "&remote=" + rem + "&employment_type=" + PtFt;
	}
	
	public String NumEmp(String nEmp) {
		return urlJobs + "&company_num_employees=" + nEmp;
		
	}
	
	public String LocNumEmp(String loc, String nEmp) {
		loc = loc.replace(" ", "+");
		return urlJobs + "location=" + loc + "&company_num_employees=" + nEmp;
	}
}
