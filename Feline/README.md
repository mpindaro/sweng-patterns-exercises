# CORSO DI INGEGNERIA DEL SOFTWARE A.A. 2018/19

## LABORATORIO 6

* TEAMMATE 1: Cognome, Nome, Matricola, Bitbucket-username
* TEAMMATE 2: Cognome, Nome, Matricola, Bitbucket-username

Ogni coppia di studenti procede ad effettuare il **fork** di questo repository.
L'utente che ha effettuato il fork modifica questo README inserendo le opportune **informazioni sui membri del team** Segundo lo schema sopra riportato.
Inoltre, concede i permessi di scrittura al proprio compagno di team e i **permessi di lettura** a **tutti** i docenti (`carlobellettini`, `mmonga`, `matteocamilli`).

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
Si suggerisce di eseguire i test non soltanto con la IDE, ma anche eseguendo `gradle test` da riga di comando.


## Specifica dei requisiti

Obiettivo dell'esercizio è *progettare* e *realizzare* un insieme di classi
che consentano di simulare un insieme di *felini*, seguendo passo passo le specifiche di seguito riportate:

#### Step 1
Implementare due diverse classi che rappresentano due diverse specie di felini: `Lion` e `Tiger`. Entrambe le classi implementano l'interfaccia [Feline](src/main/java/it/unimi/di/sweng/lab06/Feline.java) e rispondono alla chiamata del metodo 
```
#!java
public void roar()
```
scrivendo su [System.out](https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#out) la stringa `"roar"`.

#### Step 2
Implementare altre due classi `DomesticCat` e `PelucheCat`. Esse, pur NON implementando l'interfaccia `Feline` hanno un comportamento molto simile: `DomesticCat` possiede un metodo
```
#!java
public void meow()
```
la cui invocazione scrive su *System.out* la stringa `"meow"`; `PelucheCat` invece possiede un metodo
```
#!java
public void jingle()
```
la cui invocazione scrive su *System.out* la stringa `"singsong-miao"`.

#### Step 3
Aggiungere la possibilità di **usare** istanze delle classi `DomesticCat` e `PelucheCat` come oggetti di tipo `Feline`. Tale obiettivo deve essere raggiunto usando il *design pattern* denominato
**adapter**; più in dettaglio, è richiesta la realizzazione di due diversi adapter: `FelineDomesticCat` che realizza un *Class adapter* e `FelinePelucheCat` che realizza invece un *Object adapter*.

Le funzionalità fino ad ora sviluppate rappresentano la prima release del software che deve essere etichettata come `v1.0-adapter`.

#### Step 4
Aggiungere la possibilità di **contare** il numero di volte che un qualsiasi oggetto di tipo `Feline` emetta un *verso*. Tale obiettivo deve essere raggiunto usando il *design pattern* denominato
**decorator**; più in dettaglio, è richiesta la realizzazione di una classe `FelineCounter` che implementa l'interfaccia `Feline` e *decora* un'istanza di `Feline` in modo che venga conteggiato il numero di *versi* emessi da una qualsiasi istanza decorata.
La classe `FelineCounter` deve implementare anche i metodi:
```
#!java
public static int getCount()
```
che restituisce il conteggio attuale;
```
#!java
public static void resetCount()
```
che resetta il conteggio attuale.

Le funzionalità fino ad ora sviluppate rappresentano la seconda release del software che deve essere etichettata come `v2.0-decorator`.

#### Step 5
Creare due diverse classi `SimpleFelineFactory` e `CounterFelineFactory` adibite rispettivamente alla **creazione** di semplici oggetti `Feline` e oggetti `Feline` incapsulati nel *decorator* introdotto al punto precedente. Tale obiettivo deve essere raggiunto usando il *design pattern* denominato **abstract factory**. Nello specifico le due factory concrete devono estendere la seguente classe astratta:
```
#!java
public abstract class AbstractFelineFactory {
  abstract public Feline createLion();
  abstract public Feline createTiger();
  abstract public Feline createDomesticCat();
  abstract public Feline createPelucheCat();
}
```

All'interno della fase di *refactoring* dell'iterazione corrente, ricordarsi di sostituire, ogni creazione di istanze `Feline` presente nei *test*, con l'uso della *factory* opportuna.

Le funzionalità fino ad ora sviluppate rappresentano la terza release del software che deve essere etichettata come `v3.0-factory`.


#### Step 6
Creare una classe che rappresenti un *branco* di oggetti di tipo `Feline`. Tale obiettivo deve essere raggiunto usando il *design pattern* denominato **composite**; più in dettaglio, è richiesta la realizzazione di una classe `Gang` che deve implementare l'interfaccia `Feline` e deve rispondere all'invocazione del metodo `void roar()` demandando la chiamata agli oggetti `Feline` *aggregati*.
Le istanze della classe `Gang` devono consentire l'aggiunta di elementi tramite l'invocazione del metodo:
```
#!java
public void add(Feline feline)
```

Le funzionalità fino ad ora sviluppate rappresentano la quarta release del software che deve essere etichettata come `v4.0-composite`.


## Quality Assurance (QA) Test

Si osservi che le classi implementate dovranno **rispettare strettamente le
specifiche** sopra elencate, in particolare riguardo a: il *package* in cui
devono essere collocate, il nome che devono avere, i parametri dei costruttori
e le *signature* dei metodi addizionali.

Al fine di verificare tale richiesta, nonché la corretta implementazione della specifica, sono stati realizzati dei *test di accettazione*.
Seguiranno maggiori informazioni durante l'esercitazione.
