# Coda dal Fruttivendolo (MVC)
  

Creare un programma Java che permetta di gestire unsupportare *clienti* 
(Customer) e *commessi* (Clerks) di un negozio nella gestione della *coda*
(unica, il "modello" del sistema). In particolare i clienti vengono serviti in modo FIFO in  
base al numero che ottengono tramite uno specifico *dispenser* (una delle "viste" del sistema).
Ci possono essere chiaramente più dispenser, ma naturalmente devono essere *coordinati**, 
cioè distribuire il numero corretto. Ogni dispenser ha un bottone e un display: Il display mostra 
l'ultimo numero consegnato a livello globale, il bottone serve per farsi assegnare il numero successivo.

Anche i commessi hanno una "vista" a loro assegnata, che consiste anche essa in un bottone e un display: il display mostra 
l'ultimo numero che si sta servendo a livello globale, il bottone serve a *chiamare* il prossimo numero da servire.
Anche dei commessi (e relativi bottoni/display) ce ne possono essere diversi.


### Ulteriori indicazioni


* Le viste associate a *clienti* e *commessi* possono essere realizzate tramite una unica classe. Attraverso un `Button` e una `Label` ci permettono di richiedere e di leggere il prossimo numero di *biglietto*. 
La classe  è già parzialmente deinita e presente: `DisplayView`.

* La vista di cui sopra può essere resa flessibile tramite delle strategie (ruoli) che forniscono azioni corrette da farsi alla pressione del bottone e alla richiesta dello stato del modello.

* Model e vista si "parlano" tramite una implementazione del pattern Observer con modalità **pull** in modo che ogni vista chieda al modello la parte di stato che gli serve.

* La componente `Model` si occupa di mantenere i dati riguardo ai `Ticket` da erogare/servire. E' unica e comune a tutte le viste. Il `Model` a fronte di un cambiamento di stato, deve occuparsi di *notificare* tutte le viste.

* Il `Controller` reagisce all’input dell’utente (pressione di un bottone) e richiama le operazioni opportune (definite dalla `View` tramite il suo ruolo) sul `Model`.

* Lo svolgimento dell'esercizio richiede l'uso del *compound pattern* Model-View-Controller (MVC).



## Verifica e Convalida


### Integration Test

Il test di integrazione simulerà la pressione del bottone in una *view* e farà asserzioni sulle modifiche conseguenti nelle altre *view*. E' già definito e può essere usato per verificare almeno in parte la correttezza del programma.


## Compiti

Dopo aver esplorato le interfacce e classi fornite, rispondere alle domande e completare i punti segnalati dai vari commenti `TODO` che troverete sparsi nel codice.
