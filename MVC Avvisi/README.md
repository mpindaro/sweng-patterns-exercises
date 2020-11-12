# Corso di Ingegneria del Software a.a. 2018/19

## Laboratorio 12 (Prova in itinere III)

* TEAMMATE 1: Cognome, Nome, Matricola, Bitbucket-username
* TEAMMATE 2: Cognome, Nome, Matricola, Bitbucket-username


Ogni **coppia** di studenti procede ad effettuare il **fork** di questo repository.
Inoltre, concede i permessi di scrittura al propri compagni di team e i **permessi di lettura** a **entrambi** i docenti (`carlobellettini`, `mmonga`).

## Processo

Una volta effettuato il **clone** del repository, il gruppo esegue il comando `git flow init` all'interno della directory clonata.
Dopodiché, il gruppo implementa secondo la *metodologia TDD*
le specifiche riportate di seguito; in maggior dettaglio, ripete i passi seguenti fino ad aver implementato tutte le funzionalità richieste:

* crea un nuovo *branch* per la funzionalità corrente attraverso l'esecuzione del comando `git flow feature start`,
* implementa un test per le funzionalità richieste **procedendo nell'ordine** in cui sono specificate,
* verifica che **il codice compili correttamente**, ma l'**esecuzione del test fallisca**; solo a questo punto effettua un *commit* (usando `git add` e `git commit`) iniziando il messaggio di commit con la stringa `ROSSO:`,
* aggiunge la minima implementazione necessaria a realizzare la funzionalità, in modo che **il test esegua con successo**; solo a questo punto
  effettua un *commit* (usando `git add` e `git commit`) iniziando il messaggio di commit con la stringa `VERDE:`,
* procede, se necessario, al **refactoring** del codice, accertandosi che le modifiche non comportino il fallimento di alcun test; solo in questo caso fa seguire ad ogni
  passo un *commit* (usando `git add` e `git commit`) iniziando il messaggio di commit con la stringa `REFACTORING:`,
* esegue il *merge* del *branch* per la funzionalità sviluppata all'interno del *branch develop* attraverso il comando `git flow feature finish`,
* **solo in fase di rilascio**, esegue una *release* all'interno del *branch master* attraverso il comando `git flow release start` e successivamente `git flow release finish`,
* effettua un *push* (di tutti i *branch*) su Bitbucket con `git push origin --all --follow-tags`.

Al termine del laboratorio effettua una **ultima release**, un ultimo *push*, e **verifica su Bitbucket** che ci sia la completa traccia di *commit* effettuati.
Si suggerisce di eseguire i test non soltanto con l'IDE, ma anche eseguendo `gradle test` da riga di comando.


### Specifica dei requisiti

Creare un programma Java che gestisca il sistema di visualizzazione avvisi del dipartimento (usando il **pattern MVC**).


**MODELLO**

Ogni avviso è composto da una sola riga di testo (max 40 caratteri)

Il *modello* riceve le segnalazioni di nuovi avvisi e notifica le *viste*. Inserisce all'inizio della riga di ogni avviso la data del giorno in cui tale avviso è stato creato nel formato gg/mm/aaaa.

La notifica alle viste dell'inserimento di un nuovo avviso può essere effettuata con la modalità che preferite (push, pull. o mista).

Deve essere in grado di rispondere alla richiesta degli ultimi 10 avvisi.

**VISTE**

Esistono due *viste di input*. 

* La prima accetta una riga di testo di max 40 caratteri;
* La seconda è composta da un singolo bottone che invia l'avviso "ALLARME INCENDIO: scappare a gambe levate".

Esistono anche due tipi di *viste di output*: cioè dei display di sola lettura.

* Il primo tipo è un piccolo display (SmallDisplay) che presenta solo l'ultimo avviso
* Il secondo tipo è più grande (BigDisplay) e presenta gli ultimi 10 avvisi (in alto i più recenti).


**CONTROLLER**

I controller faranno da collante tra il model e le view.


## Indicazioni aggiuntive sul processo

Per poter effettuare *test di unità* (veloci e indipendenti il più possibile dalla GUI) isolando correttamente i vari componenti, dovete utilizzare (oltre a JUnit) la libreria di Mocking [Mockito](http://mockito.org/).

Per potere effettuare *test di integrazione* (coinvolgenti gli elementi della GUI) e simulare la interazione degli utenti, dovete usare la libreria di test per Swing assertj-swing.

La divisione tra test di unità e test di integrazione è fatta tramite il plugin di gradle `org.unbroken-dome.test-sets`. Si ricorda che per coloro che usano una versione di gradle precedente alla `4.10` (potete controllare la vostra versione con il comando `gradle --version`) deve usare la versione `1.5.2` del plugin, mentre gli altri devono usare la versione `2.1.1`.  

L'ordine di svolgimento delle classi implementate è a vostra scelta. Per ogni classe che implementate deve essere presente una relativa classe di test. Per ogni metodo che ritenete opportuno testare, deve esistere almeno un metodo di test.

Il primo rilascio di nome `REL_1` può avvenire quando avete realizzato e testato in isolamento almeno 2 classi (tra quelle di view, model e controller).

Il secondo rilascio di nome `REL_2` deve comprendere almeno una vista di input, una di output, i relativi controller e il modello.

Solo a partire dal terzo rilascio di nome `REL_3` sarà possibile procedere con i test di integrazione. Il test di integrazione provvederà a inserire uno o più avvisi con una *vista di input* a vostra scelta e farà asserzioni sulle modifiche conseguenti nelle  *viste di output*.

**Almeno** prima di effettuare ogni release (ma si consiglia prima di chiudere una qualunque feature), la coppia deve verificare che la copertura dei comandi 
da parte del proprio test raggiunga almeno l'85%.

Sul ramo master (pubblicazione delle varie release) non saranno accettati livelli inferiori a tle valore.

Per la release `REL_3` (soggetta anche ai test di integrazione) è richiesto che la copertura dei comandi raggiunga  almeno il 95%


