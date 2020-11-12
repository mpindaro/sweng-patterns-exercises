# Musica maestro (con gli spettatori)!


Obiettivo dell'esercizio è *progettare* e *realizzare* un insieme di classi
che consentano di:

* **contare** il numero di *suoni* emessi per *tipologia* di strumento musicale (ossia per ogni
  nome di classe che implementa l'interfaccia `MusicalInstrument`,
* **emettere su _standard error_** un messaggio di *log* contenente il nome
  del tipo  per ogni suono emesso.

Tale obiettivo deve essere raggiunto usando il *design pattern* denominato
**_observer_**; più in dettaglio, è richiesta la realizzazione, nel *package*
`it.unimi.di.prog2.lab07`, delle seguenti classi:

1. Il *decorator* `ObservableInstrument` che implementi l'interfaccia
   `MusicalInstrument` e svolga il ruolo di **Subject** nel *pattern*
   **observer** e decori il `MusicalInstrument` passato al suo costruttore in
   modo che l'invocazione del metodo `play` possa essere osservata.

1. L'*observer* `InstrumentLoggerObserver` in modalità **_PULL_** che emetta
   sullo _standard error_, per ogni invocazione di `play`, il nome della classe
   sulla cui istanza osservata è stato invocato;

1. L'*observer* `InstrumentCounterObserver` in modalità **_PUSH_** che abbia un
   metodo con *signature* `public int getCount(final String name)` che, dato un
   nome di classe come argomento, restituisca il numero di volte per cui `play`
   è stato invocato su istanze osservate di tale classe e un metodo con
   *signature* `public void resetCount()` che azzeri tutti i conteggi;

1. La *factory* `ObservedInstrumentFactory` che implementi l'interfaccia
   `AbstractInstrumentFactory` e il cui costruttore accetti una lista di
   osservatori (entrambi i tipi) di cui sopra e costruisca le istanze di vari tipi di
   strumenti opportunamente avvolte dal *decorator* `ObservableInstrument` e poste
   sotto osservazione dagli *observer* passati al costruttore;

### Suggerimenti

Nell'implementazioni delle classi sopra specificate può essere utile tenere
conto dei seguenti suggerimenti:

1. la classe `ObservableInstrument` è bene che decori il metodo `play` usando
   almeno i metodi `setChanged` e `notifyObservers` necessari a rendere le
   invocazioni osservabili dai due *observer* da implementare;

1. la classe di cui un oggetto è istanza può essere ottenuta invocando
   `getClass`, data una classe è possibile ottenere il suo nome invocando
   `getSimpleName` detto altrimenti, dato un oggetto definito come `AClass
   anObject = new AClass()`, l'espressione `anObject.getClass().getSimpleName()`
   ha valore `AClass`;

1. la classe `InstrumentLoggerObserver` emetterà i messaggi invocando opportuni metodi di `System.err`.

1. la classe `InstrumentCounterObserver` può usare ad esempio una implementazione di `Map`
   (di tipo specifico `Map<String,Integer>`) per tener traccia del numero di invocazioni per classe;
