# CORSO DI INGEGNERIA DEL SOFTWARE A.A. 2018/19

## LABORATORIO 8

* TEAMMATE 1: Dileo, Manuel, 908984, manueldileo
* TEAMMATE 2: Cucchi, Matteo, 909720, matteocucchi1

Ogni coppia di studenti procede ad effettuare il **fork** di questo repository.
L'utente che ha effettuato il fork modifica questo README inserendo le opportune **informazioni sui membri del team** Segundo lo schema sopra riportato.
Inoltre, concede i permessi di scrittura al proprio compagno di team e i **permessi di lettura** ai docenti (`carlobellettini`, `matteocamilli`, `mmonga` ).

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

Un indice **KWiC** (*Key Word in Context*) è uno strumento che consente di
cercare, in un *corpus* di documenti, una stringa nel *contesto* in cui
compare. Se assumimamo per semplicità che ogni documento sia dato da una
singola linea di testo e numerato (a partire da 0), un possibile corpus è:
```
0: Maramao, perche sei morto?
1: Pan e vin non ti mancava!
```
cui corrisponde l'indice KWiC:
```
0:                       Maramao perche sei morto
1:                       Pan e vin non ti mancava
1:                Pan    e vin non ti mancava
1:   Pan e vin non ti    mancava
0: Maramao perche sei    morto
1:          Pan e vin    non ti mancava
0:            Maramao    perche sei morto
0:     Maramao perche    sei morto
1:      Pan e vin non    ti mancava
1:              Pan e    vin non ti mancava
```
che è ottenuto "spezzando in due" ad ogni parola ciascun documento ed
ordinando il risultato alfabeticamente in base al "secondo pezzo".

Dato un indice KWiC è molto efficiente (dato che è ordinato) cercare una
parola nel suo contesto; nell'esempio precedente, si può trovare che "sei
morto" compare nel documento 0 applicando, ad esempio, una banale ricerca
dicotomica.

Obiettivo dell'esercizio è progettare e realizzare (secondo la **metodologia
TDD** e facendo uso di opportuni **design pattern**) una gerarchia di classi
atte a produrre un indice KWiC a partire da un corpus assegnato.

#### Esempio di esecuzione

Le classi progettate devono poter essere esercitate da "riga di comando", ad esempio
invocando
```
java it.unimi.di.sweng.lab08.KWiCGenerator
```
ed avendo
```
Maramao perche sei morto
Pan e vin non ti mancava
```
nel flusso *standard input*, il flusso *standard output* deve contenere
```
0: Maramao perche sei morto
1: Pan e vin non ti mancava
1: e vin non ti mancava   Pan
1: mancava   Pan e vin non ti
0: morto   Maramao perche sei
1: non ti mancava   Pan e vin
0: perche sei morto   Maramao
0: sei morto   Maramao perche
1: ti mancava   Pan e vin non
1: vin non ti mancava   Pan e
```


### Requisiti informali

Il progetto deve tener conto dei seguenti requisiti:

*  La lettura dell'*input* deve avvenire usando un
   [Reader](https://docs.oracle.com/javase/8/docs/api/java/io/Reader.html),
   non necessariamente [System.in](https://docs.oracle.com/javase/7/docs/api/java/lang/System.html#in),
   questo per rendere più agevole sia il testing che l'eventuale estensione a
   casi in cui l'input non provenga dalla console.

*  In una versione preliminare è ragionevole che i documenti vengano letti
   testualmente, ma è bene progettare la lettura così che possa essere estesa
   (nelle eventuali versioni successive) in modo da: trascurare i segni di
   interpunzione (punto, virgola, due punti...) e da eliminare le *stop word*
   (ossia le parole ricorrenti come le preposizioni, gli articoli...,
   specificate in un apposito elenco).

*  Il formato dell'*output* non deve essere unico e prefissato:
   in prima istanza può avere il formato descritto nell'esempio di esecuzione,
   ma un ulteriore formato da prevedere potrebbe essere quello dell'esempio
   presente all'inizio delle specifiche; è pertanto bene prevedere la
   possibilità di future estensioni in questo senso.

*  In una versione preliminare è ragionevole che l'ordine alfabetico
   sia fissato, ma è opportuno anticipare la possibiltà di eventuali
   estensioni future in cui, ad esempio, l'ordine tenga conto, o meno,
   della differenza tra maiuscole e minuscole, sia anteponendo che
   postponendo le maiuscole rispetto alle minuscole, o così via.

*  In prima approssimazione è plausibile memorizzare interamente il
   corpus, così da consentire una implementazione più elementare dei
   passi di spezzamento ed ordinamento dei documenti. Dovendo però
   trattare testi provenienti da un linguaggio naturale è
   ragionevole attendersi che essi siano costituiti da un "piccolo"
   numero di parole *distinte* (potenzialmente molto minore della
   dimensione complessiva del corpus); sarebbe bene che questo fatto
   si riflettesse sulle scelte progettuali, in modo che eventuali
   implementazioni successive a quella preliminare ottimizzino l'uso
   della memoria.


### Suggerimenti

Fermo restando che ciascun gruppo può scegliere i *design pattern* che ritiene
più opportuni nel realizzare l'esercizio, di seguito si accenna ad alcuni tra
essi che potrebbero risultare particolarmente indicati:

*  La lettura dell'*input* potrebbe essere fatta tramite diverse
   implementazioni di un **iterator**, a seconda che si voglia leggere
   il corpus testualmente, oppure eliminando la punteggiatura o le
   *stop words*; le varie implementazioni potrebbero essere istanziate
   grazie a delle **factory**, eventualmente raccolte sotto il cappello di
   una **abstract factory**.

*  L'*output* potrebbe essere prodotto, a seconda del formato desiderato, da
   una serie di implementazioni di differenti **strategy**.

*  Le varie possibilità di ordinamento potrebbero essere definite facendo
   uso di diverse **strategy**.

*  Le diverse possibilità con cui l'indice va costruito potrebbero essere
   gestite con un **builder**.


### Rilasci del software

Il primo rilascio del software (`v1.0`) è previsto al termine dello sviluppo delle funzionalità di base,
ovvero una volta che il primo test di accettazione esegue con successo.

Per ogni funzionalità aggiuntiva sviluppata, qualora il gruppo lo ritenga opportuno, è possibile effettuare ulteriori release,
ad esempio a fronte di modifiche sostanziali dalla precedente versione, dovute a refactoring e/o introduzione di *design pattern*.

