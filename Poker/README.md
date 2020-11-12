# Hello World!

(tempo massimo 1 ora)

Questo esercizio richiede di creare un programma molto semplice, ma *da zero*.
Il programma può essere prodotto con l'aiuto dell'IDE (IntelliJ IDEA), ma deve
rispettare le convenzioni di Gradle, in modo da essere riproducibile in ambienti
diversi.

## Funzionalità del programma

Il programma scrive sullo *standard output* il messaggio "Ciao <nome>!" per un
numero di volte passato come "argomento". Se il programma prodotto si chiama
`hello-1.0.jar` (ad esempio creato dal comando `gradle jar` nella directory `build/libs`)

```sh
java -jar hello-1.0.jar Ada 5
```

stampa:

```
Ciao Ada!
Ciao Ada!
Ciao Ada!
Ciao Ada!
Ciao Ada!
```

L'esecuzione con `gradle run` usa gli "argomenti di default" (vedi sotto) Cynthia e 2.

E' comunque possibile ridefinirli con l'opzione --args: es. `gradle run --args "Carlo 4"`

### Suggerimenti

- Creare un nuovo progetto Java, scegliendo Gradle nel menù a sinistra della finestra di creazione.
- Creare le nuove classi nella cartella `src/main/java` secondo la convenzione di Gradle
- Muovere le classi nel *package* `it.unimi.di.prog2` ("Move class") (se non si è specificato correttamente alla loro creazione)
- Aggiungere a `build.gradle` il *plugin* `application` (oltre a quello `java`
   aggiunto automaticamente da IDEA). Definire poi la classe principale da
   eseguire, per esempio:
   
```groovy
application {
   mainClassName = 'it.unimi.di.prog2.MiaApp'
}
```

- Definire gli argomenti di default

```groovy
run {
    args = ['Cynthia', '2']
}
```

- Definire la classe principale nel jar da distribuire

```groovy
jar {
    manifest {
        attributes 'Main-Class': application.mainClassName
    }
}
```

- Per convertire una stringa con un numero in un intero usare
   `Integer.parseInt` o `Integer.parseUnsignedInt`
   

# Giocare a carte

(tempo massimo 3 ore)

Il codice fornito è una versione (adattata secondo le convenzioni Gradle) del
programma Solitaire, scritto da Martin P. Robbilard. Può essere eseguito
attivando il task `run` di Gradle.

In questo esercizio si richiede di utilizzare le classi del *package*
`ca.mcgill.cs.stg.solitaire.cards` senza modificarle, nello spirito
dell'"Open/Closed Principle". Le classi prodotte dovranno far parte del
*package* `it.unimi.di.prog2.poker`.

# Obiettivi

- Si vuole avere una classe `PokerHand` che permetta di gestire un gruppo di
  carte (generalmente 5, parametro del costruttore) provenienti da un mazzo
  specifico (indicato in fase di costruzione degli oggetti `PokerHand`). Gli
  oggetti `PokerHand` forniscono un metodo `getRank()` per determinare il
  punteggio di una mano (in caso di dubbio, le regole sono riassunte qui:
  https://en.wikipedia.org/wiki/List_of_poker_hands). I possibili punteggi sono:

```java
  public enum HandRank {
   HIGH_CARD,
   ONE_PAIR,
   TWO_PAIR,
   THREE_OF_A_KIND,
   STRAIGHT,
   FLUSH,
   FULL_HOUSE,
   FOUR_OF_A_KIND,
   STRAIGHT_FLUSH
  }
```

- Definire una nuova classe principale (nel *package* `it.unimi.di.prog2.poker`)
  con la quale sperimentare l'uso degli oggetti `PokerHand`

- Gli oggetti `PokerHand` espongono il gruppo di carte di cui sono composti solo
  tramite un *iteratore* (Utilizzare il *pattern Iterator*, descritto nel
  paragrafo 3.6 del libro di testo, sfruttando l'interfaccia `Iterable` della
  libreria standard)
  
- L'implementazione del metodo `getRank()` rischia di cadere nell'anti-*pattern*
  "Switch Statement" (vedi pag. 47 del libro di testo). Per evitarlo, è
  possibile organizzare la valutazione del punteggio secondo un *pattern*
  "Chain-of-responsibility": si definisce un'interfaccia `ChainedHandEvaluator`
  che espone un metodo che, dato un oggetto `PokerHand` ne calcola il punteggio
  (`HandRank`) corrispondente; per ogni tipologia di punteggio che si vuole
  valutare, occorrerà implementare un sotto-tipo appropriato di
  `ChainedHandEvaluator`. Ciascun sotto-tipo di `ChainedHandEvaluator` conosce
  anche il "prossimo" valutatore (comunicato col proprio costruttore): ciò
  permette di costruire una catena di valutatori. Si può perciò iniziare dal
  valutatore del punteggio più alto (`STRAIGHT_FLUSH`) che avrà come prossimo
  valutatore quello di `FOUR_OF_A_KIND`, ecc. La logica di valutazione sarà: se
  il valutatore riconosce lo schema del "proprio" punteggio, restituisce il
  valore opportuno (p.es. se il valutatore del tris trova 3 carte dello stesso
  valore nella `PokerHand` restituisce `THREE_OF_A_KIND`, altrimenti richiama il
  prossimo valutatore, probabilmente il valutatore di doppie coppie). Non è
  necessario realizzare tutti i valutatori: tre a scelta sono sufficienti.
  
- Gli oggetti `PokerHand` devono implementare l'interfaccia `Comparable`,
  ordinando le `PokerHand` secondo il valore restituito da `getRank()`. Non c'è
  bisogno di definire l'ordinamento fra mani con lo stesso punteggio.
  
- Definire un costruttore di `PokerHand` a partire da una stringa tipo 
  "7H JC JH 1C 4C" -> (SEVEN of HEARTS, JACK of CLUBS, JACK of HEARTS, ACE of CLUBS, FOUR of CLUBS).
  Si suggerisce di usare la classe `Scanner` (che implementa il pattern Iterator)
  
- "Completare" il confronto di `PokerHand` in modo che risolva anche i casi di 
  parità di ranking (vedi regole spiegate nella pagina di wikipedia già citata)
  

