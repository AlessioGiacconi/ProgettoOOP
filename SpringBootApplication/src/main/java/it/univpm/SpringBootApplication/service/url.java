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
		String time;
		if (PtFt == "full time") {
			time = "full+time";
		}else if(PtFt == "contract") {
			time = "contract";
		}else time = " ";
		return urlJobs + "&employment_type=" + time; 	
	}
	
	public String LocRem(String loc, boolean rem) {
		loc= loc.replace(" ","+");
		return urlJobs + "&location=" + loc + "&remote=" + rem;
	}
	
	public String LocPtFt(String loc, String PtFt) {
		loc = loc.replace(" ", "+");
		String time;
		if (PtFt == "full time") {
			time = "full+time";
		}else if(PtFt == "contract") {
			time = "contract";
		}else time = " ";
		return urlJobs + "&location=" + loc + "&employment_type=" + time;
	}
	
	public String LocRemPtFt(String loc, boolean rem, String PtFt) {
		loc = loc.replace(" ", "+");
		String time;
		if (PtFt == "full time") {
			time = "full+time";
		}else if(PtFt == "contract") {
			time = "contract";
		}else time = " ";
		return urlJobs + "&location=" + loc + "&remote=" + rem + "&employment_type=" + time;
	}
}
