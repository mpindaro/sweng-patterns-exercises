# Rubamazzetto

Il codice fornito simula partite a rubamazzetto. Ogni giocatore inizialmente
riceve 3 carte, e 4 carte vengono poste scoperte sul tavolo. A turno i giocatori
devono giocare una delle loro carte: se tale carta ha lo stesso valore di una
sul tavolo, il giocatore pone le due carte con lo stesso valore in un mazzetto
davanti a sé in modo che tutti possano vedere l'ultima "presa". Se non c'è una
carta dello stesso valore sul tavolo e invece uno dei mazzetti degli altri
giocatori ha in cima una carta dello stesso valore di quella giocata, il
giocatore può "rubare" il mazzetto all'avversario, sottraendolo all'avversario e
ponendolo insieme alla carta giocata in cima al proprio. Altrimenti la carta
viene posta insieme alle altre scoperta sul tavolo. Quando tutti i giocatori
hanno finito il loro turno, viene distribuita a ciascuno una nuova carta presa
dal mazzo, finché ce ne sono abbastanza; poi si gioca fino a che tutti hanno
esaurito le loro carte. Vince il giocatore che alla fine ha più carte nel
proprio mazzetto.

# Obiettivi

## Esame e comprensione del codice

Esaminare il codice e poi rispondere alle seguenti domande:

- come si chiama il metodo che permette di controllare se una carta con un certo Rank è sul tavolo?

- qual è il significato dell'attributo `punti` della classe `Giocatore`?

- qual è la condizione che viene testata per capire se una partita è finita? 
  Potete pensare a una formulazione diversa (più semplice o più chiara)?

## Scrittura del codice 
(la maggior parte dei punti in cui dovete intervenire nel codice sono segnalati da un commento`//TODO` )

Le classe principale è `Rubamazzetto`, che crea una nuova `Partita`, cioè un
insieme di `Giocatore` che gioca allo stesso `Tavolo`. Si chiede di:

- far sì che `Tavolo` implementi l'interfaccia `Iterable<Card>`, permettendo di
  iterare sulle carte scoperte sul tavolo.

- completare `Giocatore.turno` in maniera che ogni giocatore giochi una carta
  (decisa da una strategia di gioco) in maniera conforme alle regole del gioco,
  descritte sopra.
  
- usare il pattern "Chain of Responsibility" per creare almeno 4 strategie di
  gioco che implementino l'interfaccia `SelettoreCarta` (da definire ma già citata nella classe `Giocatore`) per decidere 
  quale tra le carte **in mano** al giocatore verrà giocata. Per
  esempio, potete definire le seguenti strategie: 
  
    1) scegli un carta a caso (strategia che "funziona" sempre);
    1) se c'è, scegli una carta che ha lo stesso valore di una di quelle sul tavolo;
    1) se c'è, scegli una carta che ha lo stesso valore della cima del mazzetto di uno degli avversari; 
    1) se c'è, scegli una carta che ha lo stesso valore della cima del tuo mazzetto (per proteggerlo).
  
- in `Rubamazzetto` crea i giocatori componendo diverse catene di strategie di
  base implementate al punto precedente (quali strategie e in che ordine le comporrai determineranno le strategie globali dei giocatori).
  
