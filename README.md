# Progetto per l'esame di Programmazione ad Oggetti
## **SpringBootApplication**

* [Introduzione](#intro)
* [Diagrammi UML](#UML)
* [Rotte](#rotte)
* [Eccezioni](#eccezioni)
* [Test](#test)
* [Software utilizzati](#software)
* [Autori](#Autori)

<a name="intro"></a>
##  Introduzione
L'applicazione consiste nell'implementazione di un sistema che permette la ricerca di offerte di lavoro basate sull'utilizzo
del linguaggio phyton sfruttando l'API [Findwork](https://findwork.dev). La ricerca restituisce gli annunci di lavoro e le 
statistiche riguardanti 5 grandi città americane. Sia annunci che statistiche potranno poi essere filtrati secondo alcuni 
parametri di ricerca illustrati a seguire.

<a name="UML"></a>
# UML

## Diagramma D'Uso

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/cc4c887cdade99c953a889298cd615a6fac17452/UML/diagrammafinale.png)

# Diagramma Delle Classi 

<h3>Applicationr</h3>

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/9e673b09220c8ea98e5cba30792717ea45bf3466/UML/ApplicationClass.png)

<h3>Controller</h3>

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/9e673b09220c8ea98e5cba30792717ea45bf3466/UML/controllerClass.png)

<h3>Exceptions</h3>

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/9e673b09220c8ea98e5cba30792717ea45bf3466/UML/exceptionsClass.png)

<h3>Model</h3>  

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/9e673b09220c8ea98e5cba30792717ea45bf3466/UML/modelClass.png)

<h3>Service</h3> 

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/9e673b09220c8ea98e5cba30792717ea45bf3466/UML/serviceClass.png)

<h3>Filters</h3> 

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/9e673b09220c8ea98e5cba30792717ea45bf3466/UML/filterClass.png)

<h3>Statistics</h3>

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/9e673b09220c8ea98e5cba30792717ea45bf3466/UML/classStats.png)

# Diagrammi Delle Sequenze 

<h3>GET/Cities</h3>

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/59e548f87c538b86f183dee4ac7bdf3789598c80/UML/sequenceCity.png)


<h3>GET/Jobs</h3>

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/e8bb3f277994cb088d04f855cefb90f61435ed61/UML/sequenza%20jobs.drawio.png)


<h3>POST/Filters</h3>

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/e8bb3f277994cb088d04f855cefb90f61435ed61/UML/sequenza%20filtri.drawio.png)


<h3>GET/allStats</h3>

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/4d56df2c6bfa11c1556d420b8ec5b6ec2cf5db3a/UML/stats.drawio.png)

<h3>POST/filterStats</h3>

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/bf2a65a13019b8fd8a7515a15495053394a10e23/UML/filteredStats.drawio.png)



<a name="rotte"></a>

# ROTTE

|Rotte    | Metodo | Descrizione |
|---------|------------|-------|
|  "/Jobs"      | Get  | Rotta che restituisce tutte le offerte di lavoro presenti su FindWork relative alle città monitorate||
|  "/Filters"    | Post | Rotta che restituisce le offerte di lavoro filtrate in base ai parametri inseriti dall'utente nel body||
|  "/allStats"     | Get | Rotta che restituisce le statistiche per tutte le città monitorate||
|  "/Cities" | Get  | Rotta che restituisce l'elenco delle città sulle quali sono effettuate le ricerche di annunci||
|  "/filterStats"    | Post | Rotta che restituisce le statistiche filtrate in base ai parametri inseriti dall'utente nel body||

## Esempi di chiamate:

<h3>GET localhost:8080/cities</h3>

Questa rotta di tipo GET restituisce tutte le città presenti (per il progetto sono state scelte 5 città americane).

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/365fb9dfeaad464dc984dfc79082d353ba86e21d/EsempiRotte/rottaCities.png)



<h3>GET localhost:8080/Jobs</h3>

Questa rotta di tipo GET restituisce tutti gli annunci di lavoro relativi alle città monitorate e contenenti la parola python.

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/365fb9dfeaad464dc984dfc79082d353ba86e21d/EsempiRotte/rottaJobs.png)

  

<h3>POST localhost:8080/Filters</h3>
  

Questa rotta di tipo POST restituisce gli annunci di lavoro filtrati secondo quanto è stato inserito nel body.

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/365fb9dfeaad464dc984dfc79082d353ba86e21d/EsempiRotte/rottaFilters.png)
  
Possibilità di filtraggio e utilizzo : 
 
{
  
"location" : "Chicago", --> filtraggio in base alla città scelta
  
"remote" : null, --> lavoro in remoto o no con le seguenti scelte null, true e false.
  
"employment_type" : "full time" --> lavoro "full time" o "contract"
  
}
  
Nel caso in cui vengano inseriti dei valori non validi per i filtri verrà generata un'eccezione dal programma.

N.B. All'utente è consentito anche lasciare il body vuoto: in tal caso verrano restituiti i risultati relativi a tutte le città senza essere filtrati in alcun modo.
  
N.B. L'utente può anche inserire una stringa vuota ("") nei campi "location" oppure "employment_type". I risultati verranno comunque filtrati.
  
  

<h3>GET localhost:8080/allStats</h3>

Questa rotta di tipo GET restituisce tutte le statistiche relative alle 5 città monitorate.

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/6103695df87af045109ab950381a1543f9370fb9/EsempiRotte/rottaAllStats.png) 

L'applicazione permette di generare delle statistiche sui lavori trovati : 

 Tipologia del lavoro --> numero di lavori in remoto o non con le relative percentuali.

 Possibilità di generare statistiche utilizzando altri linguaggi oltre al Phyton --> Phyton, Javascript, Kotlin, Django, React.
  
  

<h3>POST localhost:8080/filterStats</h3>

Questa rotta restituisce le statistiche filtrate in base ai parametri inseriti nel body.

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/8811b8fe63ec16ba6c5641fefb66706c105d9f22/EsempiRotte/rottafilterStats.png)

Attenzione: 

{
  

"location" : "Los Angeles", --> si può scegliere tra le 5 città presenti nell'applicazione (Los Angeles, Chicago, New York, San Francisco, Seattle).
    
"num_employees" : "11-50", --> rappresenta il numero di dipendenti (1-10, 11-50, 51-100, 101-250).
    
"date" : "2020-10-01" --> rappresenta la data di annuncio riguardante il lavoro, l'applicazione accetta il formato yyyy-mm-dd.
  
    
}

Nel caso in cui vengano inseriti dei valori non validi per i filtri verrà generata un'eccezione dal programma.

  N.B. All'utente è consentito anche lasciare il body vuoto: in tal caso verrano restituiti i risultati relativi a tutte le città senza essere filtrati in alcun modo.
  
  N.B. L'utente può lasciare una stringa vuota ("") in ciascuno dei tre campi. I risultati saranno comunque filtrati nel modo desiderato.
  
  
<a name="eccezioni"></a>
  
  # Eccezioni
  
  * JobsNotFoundException nel caso in cui non venga trovato alcun annuncio in base ai parametri immessi.
  
  * InvalidBodyException nel caso in cui sono stati inseriti parametri sbagliati nel body.
  
  * StatsErrorException nel caso in cui vengano restituiti risultati errati durante la richiesta delle stats.

<a name="test"></a>
 
 # Test
  
  Per provare il corretto funzionamento di alcune delle funzionalità del programma abbiamo anche programmato 
  3 unit test tramite il framework di testing JUnit 5.
  
  * CitiesTest: si occupa di verificare che la lettura delle città monitorate dalla SpringBoot Application,
                contenute in un file Cities.txt, avvenga correttamente.
                
  * FilterJobsException: il suo compito è di verificare che la ricerca effettuata inserendo particolari filtri
                         ritorni risultati validi. Nel caso in cui il body della richieta non fosse stato 
                         sarebbe stata lanciata una ResponseStatusException seguita da una InvalidBodyException.
                         Nel caso in cui invece la ricerca effettuata tramite quei filtri non avesse dovuto avere
                         risultati avrei ottenuto una JobsNotFoundException.
                         
  * InvalidBodyException: questo test infine verifica che, inseriti nel body della richiesta dei parametri non 
                          non validi per la ricerca, venga lanciata una ResponseStatusException che sarà 
                          immediatamente seguita da una InvalidBodyException.
  
<a name="software"></a>
    
  
  # Software utilizzati 
  
* [Eclipse](https://www.eclipse.org/downloads/) - Ambiente di sviluppo
  
* [Draw.io](https://www.diagrams.net/) - Software per la realizzazione dei diagrammi UML
  
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework per sviluppo di applicazioni in Java
  
* [Postman](https://www.postman.com/) - Ambiente di sviluppo API per effettuare richieste

* [JUnit 5](https://junit.org/junit5/) - Framework per lo sviluppo di test in Java
  
  
<a name="autori"></a>  
  # Autori
  
  | Autori | Contributo | Email |
  |--------|------------|-------|
  | Giacconi Alessio | 50% | s1092675@studenti.univpm.it |
  | Dedja Erxhes | 50% | s1078853@studenti.univpm.it |
