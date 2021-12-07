package it.univpm.SpringBootApplication.model;

import java.util.Vector;

/**
 * Classe che rappresenta gli oggetti di tipo StatsParameters.
 *
 * @author Alessio Giacconi
 * @author Erxhes Dedja
 *
 */

public class StatsParameters {
	
	/**
	 * Città in cui è presente il lavoro richiesto secondo i parametri inseriti.
	 */

	private String location;
	
	/**
	 * Numero di lavori trovati
	 */
	
	private int cont_results;
	
	/**
	 * lavoro in remoto
	 */
	
	private int n_remote_true;
	
	/**
	 * lavoro non in remoto
	 */
	
	private int n_remote_false;
	
	/**
	 * percentuale di lavori in remoto
	 */
	
	private double perc_remote_true;
	
	/**
	 * percentuale di lavori non in remoto
	 */
	
	private double perc_remote_false;
	
	/**
	 * tipologia di linguaggio più richiesto
	 */
	
	private String high_requested_language;
	
	/**
	 * data da cui si desidera cercare i vari lavori
	 */
	
	private String from_date;
	
	
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
	
	public StatsParameters(String location, int cont_results, int n_remote_true, int n_remote_false, double perc_remote_true, double perc_remote_false, String high_requested_language, String from_date) {
		
		this.location = location;
		this.cont_results = cont_results;
		this.n_remote_true = n_remote_true;
		this.n_remote_false = n_remote_false;
		this.perc_remote_true = perc_remote_true;
		this.perc_remote_false = perc_remote_false;
		this.high_requested_language = high_requested_language;	
		this.from_date = from_date;
	}
	
	/**
        * metodo che restituisce la città
        * @return location
        **/
	
	public String getLocation() {
		return location;
	}
	
        /**
        * metodo che permette di impostare la città desiderata.
        **/
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
        * metodo che restituisce il numero di risultati ottenuti
        * @return cont_results
        **/
	
	public int getCont_results() {
		return cont_results;
	}
	
	/**
        * metodo per settare il count_results
        **/
	
	public void setCont_results(int cont_results) {
		this.cont_results = cont_results;
	}
	
	
	/**
        * metodo che restituisce i lavori in remoto
        * @return n_remote_true
        **/
	
	public double getN_remote_true() {
		return n_remote_true;
	}
	
	/**
        * metodo che imposta i lavori in remoto
        **/
	
	public void setN_remote_true(int n_remote_true) {
		this.n_remote_true = n_remote_true;
	}
	
	/**
        * metodo che restituisce tutti i lavori non in remoto
        * @return n_remote_false
        **/
	
	public double getN_remote_false() {
		return n_remote_false;
	}
	
	/**
        * metodo che serve per impostare la possibiltà di cercare lavori non in remoto
        **/
	
	public void setN_remote_false(int n_remote_false) {
		this.n_remote_false = n_remote_false;
	}
	
	/**
        * metodo che restituisce la percentuale di lavori in remoto
        * @return perc_remote_true
        **/
	
	public double getPerc_remote_true() {
		return perc_remote_true;
	}
	
	/**
        * metodo che serve per impostare la percentuale di lavori in remoto
        **/
	
	public void setPerc_remote_true(double perc_remote_true) {
		this.perc_remote_true = perc_remote_true;
	}
	
	/**
        * metodo che restituisce la percentuale di lavori non in remoto
        * @return perc_remote_false
        **/
	
	public double getPerc_remote_false() {
		return perc_remote_false;
	}
	
	/**
        * metodo che serve per impostare la percentuale di lavori non in remoto
        **/
	
	public void setPerc_remote_false(double perc_remote_false) {
		this.perc_remote_false = perc_remote_false;
	}
	
	/**
        * metodo che restituisce il linguaggio più richiesto
        * @return high_requested_language
        **/
	
	public String getHigh_requested_language() {
		return high_requested_language;
	}
	
	/**
        * metodo che serve per impostare la tipologia di linguaggio che si desidera
        **/
	
	public void setHigh_requested_language(String high_requested_language) {
		this.high_requested_language = high_requested_language;
	}
	
	/**
        * metodo che restituisce tutte le offerte di lavoro dalla data inserita
        * @return from-date
        **/
	
	public String getFrom_date() {
		return from_date;
	}
        
	/**
        * metodo che serve per impostare la data da cui si vuole cercare un lavoro
        **/
	
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	
}
