package it.univpm.SpringBootApplication.model;

import java.util.ArrayList;

/**
 * Rappresenta la classe che modella un lavoro 
 * @author Alessio Giacconi
 * @author Erxhes Dedja
 */

public class Job {
	
	/**
	 * Id lavoro
	 */

	private long id;
	
	/**
	 * Nome compagnia di lavoro
	 */
	
	private String company_name;
	
	/**
	 * Numero di lavoratori
	 */
	
	private String num_employees;
	
	/**
	 * Luogo di lavoro
	 */
	
	private String location;
	
	/**
	 * Tipo di lavoro : remoto o non
	 */
	
	private boolean remote;
	
	/**
	 * Tipo di lavoro :full time o part time
	 */
	
	private String employment_type;
	
	/**
	 * data annuncio di lavoro
	 */
	
	private String date;
	
	/**
	 * url che rimanda al sito della compagnia offrente il lavoro
	 */
	
	private String url;
	
	/**
	 * Tipo di linguaggio
	 */
	
	private ArrayList<String> keywords = new ArrayList<String>();
	
	
	 /**
		 * Costruttore della classe Job che inizializza un'istanza.
     **/
	
	public Job() {
		
	}
	
	public Job(long id, String company_name, String num_employees, String location, boolean remote, String employment_type, String url, String date, ArrayList<String> keywords) {
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
	
	/** metodo che restituisce l'id del lavoro
	 * @return id Ritorna l'identificativo dell'offerta di lavoro
	 */
	
	public long getId() {
		return id;
	}
	
	/** metodo che serve per impostare l'id
	 * @param id Id passato dal chiamante
	 */
	
	public void setId(long id) {
		this.id = id;
	}
	
	/** metodo che restituisce il nome della compagnia che offre il lavoro
	 * @return company_name nome azienda 
	 */
	
	public String getCompany_name() {
		return company_name;
	}

	/** metodo che permette di scegliere il nome dell'azienda
	 * @return company_name nome azienda 
	 */
	
	
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	/** metodo che restituisce il numero di lavoratori
	 * @return num_employees 
	 */
	
	public String getNum_employees() {
		return num_employees;
	}
	
	/** metodo utilizzato per impostare il numero di lavoratori
	 * @return nume_employees
	 */
	
	
	public void setNum_employees(String num_employees) {
		this.num_employees = num_employees;
		
	}
	
	/**
	 * metodo che restituisce valore attributo city
	 * @return location
	 */
	
	public String getLocation() {
		return location;
	}
	
	/**
	 * metodo che permette di impostare la città desiderata dove cercare lavoro
	 * @return location
	 */
	
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	/**
	 * metodo che restituisce la presenza o meno del lavoro in remoto.
	 * @return remoto
	 */
	
	
	public boolean isRemote() {
		return remote;
	}
	
	/**
	 * metodo che permette di impostare se il lavoro deve essere in remoto o non.
	 * @return remote
	 */
	
	public void setRemote(boolean remote) {
		this.remote = remote;
	}
	
	/**
	 * metodo che restituisce il numero di lavoratori
	 * @return employment_type
	 */
	
	public String getEmployment_type() {
		return employment_type;
	}
	
	/**
	 * metodo che permette di impostare il numero di lavoratori
	 * @return employment_type
	 */
	
	public void setEmployment_type(String employment_type) {
		this.employment_type = employment_type;
	}
	
	/**
	 * metodo che restituisce la data di annuncio del lavoro
	 * @return date
	 */
	
	
	public String getDate() {
		return date;
	}
	
	/**
	 * metodo che permette di impostare la data
	 * @return date
	 */
	
	
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * metodo che restituisce l'url 
	 * @return url
	 */
	
	public String getUrl() {
		return url;
	}
	
	/**
	 * metodo che serve per impostare il valore attributo url
	 * @return url
	 */
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * metodo che restituisce la tipologia di linguaggio
	 * @return keywords
	**/
	
	public ArrayList<String> getKeywords() {
		return keywords;
	}
	
	/**
	 * metodo che serve per impostare il linguaggio desiderato
	 * @return keywords
	 */
	public void setKeywords(ArrayList<String> keywords) {
		this.keywords = keywords;
	}
}
