# Progetto per l'esame di Programmazione ad Oggetti
## **SpringBootApplication**

* [Introduzione](#intro)
* [Diagrammi UML](#UML)
* [Rotte](#rotte)
* [Test](#test)
* [Software utilizzati](#software)
* [Autori](#Autori)

<a name="intro"></a>
##  Introduzione
L'applicazione consiste nell'implementazione di un sistema che permette la ricerca di offerte di lavoro basate sull'utilizzo
del linguaggio phyton sfruttando l'API [Findwork](https://findwork.dev).

<a name="UML"></a>
# UML

## Diagramma D'Uso

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/main/UML/use%20case.png)

# Diagramma Delle Classi 

* Controller

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/8890b7da52d0e514277fb3a7e9992c916b52efd9/UML/controller.png)

* Eccezioni 

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/8890b7da52d0e514277fb3a7e9992c916b52efd9/UML/eccezioni.png)

* Model 

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/500909409e3a403329854468eedc33e67bc3b1d0/UML/model.png)

* Service 

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/500909409e3a403329854468eedc33e67bc3b1d0/UML/service.png)

* Filters 

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/main/UML/filter.png)

* Statistics 

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/500909409e3a403329854468eedc33e67bc3b1d0/UML/stats.png)

# Diagrammi Delle Sequenze 

* GET/Cities

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/921ac2be394cc942e7d0fd624ce9f97738f46fe9/UML/DiagrammaSeqCity.png)
<a name="rotte"></a>
# ROTTE

|Rotte    | Metodo | Descrizione | Campo |
|---------|------------|-------|---------|
|  "/Jobs"      | Get  | Rotta che restituisce tutte le offerte di lavoro presenti su FindWork||
|  "/Filters"    | Post | Rotta che restituisce le offerte di lavoro filtrate in base al parametro inserito dall'utente nel body||
|  "/allStats"     | Get | Rotta che restituisce le statistiche per una o tutte le città in base al parametro specificato dall'utente||
|  "/Cities" | Get  | Rotta che restituisce l'elenco delle città sulle quali si possono calcolare le statistiche||
|  "/filterStats"    | Post | Rotta che restituisce le statistiche filtrate in base al parametro inserito dall'utente nel body||

## Esempi di chiamate:

* GET localhost:8080/cities;

Questa rotta di tipo GET restituisce tutte le città presenti (per il progetto sono state scelte 5 città americane).
![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/365fb9dfeaad464dc984dfc79082d353ba86e21d/EsempiRotte/rottaCities.png)

* GET localhost:8080/Jobs;

Questa rotta di tipo GET restituisce tutti i lavori con la parola phyotn inclusa.

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/365fb9dfeaad464dc984dfc79082d353ba86e21d/EsempiRotte/rottaJobs.png)

  

* POST localhost:8080/Filters;

Questa rotta di tipo POST restituisce le richieste con gli opportuni filtri.

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/365fb9dfeaad464dc984dfc79082d353ba86e21d/EsempiRotte/rottaFilters.png)

* GET localhost:8080/allStats

Questa rotta di tipo GET restituisce le statistiche richieste

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/6103695df87af045109ab950381a1543f9370fb9/EsempiRotte/rottaAllStats.png) 

L'applicazione permette di generare delle statistiche sui lavori trovati : 

 Tipologia del lavoro --> numero di lavori in remoto o non con le relative percentuali.

 Possibilità di generare statistiche utilizzando altri linguaggi oltre al Phyton --> Phyton, Javascript, Kotlin, Django, React.

* POST localhost:8080/filterStats

Questa rotta restituisce le statistiche filtrate in base al parametro inserito

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/8811b8fe63ec16ba6c5641fefb66706c105d9f22/EsempiRotte/rottafilterStats.png)

Attenzione: 

{

"location" : "Los Angeles", --> si può scegliere tra le 5 città presenti nell'applicazione (Los Angeles, Chicago, New York, San Francisco, Seattle).
    
"num_employees" : "11-50", --> rappresenta il numero di dipendenti (1-10, 11-50, 51-100, 101-250, >250).
    
"date" : "2020-10-01" --> rappresenta la data di annuncio riguardante il lavoro, l'applicazione accetta il formato yyyy-mm-dd.
    
}
