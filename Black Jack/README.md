# BlackJack (Prova in itinere)
  


Modificate le seguenti due righe con i vostri dati

* TEAMMATE 1: Pindaro, Margherita, 923178, mpindaro
* TEAMMATE 2: Taroni, Andrea, 923210, TaroniAndrea


Ogni **coppia** di studenti procede ad effettuare il **fork** di questo
repository. Inoltre, concede i permessi di scrittura al proprio compagno di team
e i **permessi di lettura** a **entrambi** i docenti (`carlobellettini`,
`mmonga`). Al termine dell'esercizio ricordarsi di fare **commit** e poi **push** 
(controllare anche via web sul sito di butbucket che sia presente la versione consegnata).

## Il gioco

Nel BlackJack ogni giocatore gioca contro il banco, che fa anche da mazziere,
distribuendo le carte pescate da un `MultiMazzo` composto da 6 mazzi da 52 carte.

L'obiettivo dei giocatori è avvicinarsi quanto più possibile a 21, senza
superarlo ("sballare"). Ogni carta ha il suo valore facciale, le figure valgono
10, l'asso può valere 1 o 11 a scelta.

Inizialmente ogni giocatore riceve 2 carte scoperte. Il banco scopre 1 carta
anche per sé. A questo punto ogni giocatore sfida il banco: può chiedere quante
volte vuole un'altra carta o fermarsi. Se le sue carte superano il 21, ha perso.
Altrimenti, finite le operazioni con tutti gli sfidanti, se ci sono ancora
giocatori che non hanno sballato, il banco gira una seconda carta per sé e poi
decide se girarne altre o fermarsi. Le regole del casino gli impongono di girare carte fino a quando non 
raggiunge un punteggio di almeno 17 e a quel punto si ferma. 
Se il banco sballa, tutti i giocatori rimasti hanno vinto.
Altrimenti, vincono quelli che hanno un punteggio superiore a quello del banco
(e non hanno sballato). Gli altri perdono o pareggiano, se hanno lo stesso
punteggio.

## I giocatori

Come al solito ogni vero giocatore pensa di avere elaborato una strategia che gli permetterà di vincere sempre. 
Una strategia viene implementata tramite una catena di decisori che cercano  una valida ragione per prendere una altra carta. Se la trovano restituiscono la loro scelta altrimenti passano la decisione al decisore successivo. Per evitare una ricorsione infinita in fondo alla catena dei decisori viene messo un nodo che (quando si arriva a lui e quindi non si sono trovate ragioni per rischiare di prendere altra carta) risponde di "stare", cioè finire e non prendere altre carte.
Tra i vostri compiti c'è quello di inventare tre blocchi di strategia (che si basino ad esempio sulle carte che avete in mano, oppure sulla carta visibile del banco) che potrete poi combinare per ottenere la strategia dei vari giocatori.
Una  strategia "casuale" che nel 50% dei casi che gli vengono sottoposti decide di prendere una altra carta è già stata implementata e disponibile nel codice.

## Compiti

Ad ogni esecuzione deve corrispondere la simulazione di una partita completa. 
Nella classe `BlackJack` è presente un abbozzo di main da completare nella sua parte centrale che scandisce appunto i turni dei giocatori e del mazziere.


Dopo aver esplorato le interfacce e classi fornite, rispondere alle domande e completare i punti segnalati dai vari commenti `TODO` che troverete sparsi nel codice.

