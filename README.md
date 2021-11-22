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
## Use Case Diagram





<a name="rotte"></a>

|Rotte    | Metodo | Descrizione | Campo |
|---------|------------|-------|---------|
|  "/Jobs"      | Get  | Rotta che restituisce tutte le offerte di lavoro presenti su FindWork||
|  "/Filters"    | Post | Rotta che restituisce le offerte di lavoro filtrate in base al parametro inserito dall'utente nel body||
|  "/allStats"     | Post | Rotta che restituisce le statistiche per una o tutte le città in base al parametro specificato dall'utente||
|  "/Cities" | Get  | Rotta che restituisce l'elenco delle città sulle quali si possono calcolare le statistiche||
|  "/filterStats"    | Post | Rotta che restituisce le statistiche filtrate in base al parametro inserito dall'utente nel body||

## Esempi di chiamate:

* GET localhost:8080/cities;

Questa rotta di tipo GET restituisce tutte le città presenti (per il progetto sono state scelte 5 città americane).
![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/5424f5ab02400eeabd4fd3770401355832732330/EsempiRotte/rottaCities.png)

* GET localhost:8080/Jobs;

Questa rotta di tipo GET restituisce tutti i lavori con la parola phyotn inclusa.

![](https://github.com/AlessioGiacconi/ProgettoOOP/blob/5424f5ab02400eeabd4fd3770401355832732330/EsempiRotte/rottaJobs.png)

  

* POST localhost:8080/Filters;

* GET localhost:8080/allStats
