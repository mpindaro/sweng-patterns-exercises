package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sfidante implements GiocatoreBJ {
  final private String name;
  final private Mazziere banco;
  final private List<Card> mano = new ArrayList<>();
  private Strategia strategia;
  final static private int NCARTEINIZIALI = 2;

  //@pre name!=null && banco!=null
  //@post mano.size()!=0: ogni istanza di Sfidante ha sicuramente NCARTEINIZIALI, ovvero quante sono specificate dalle regole.
  public Sfidante(String name, Mazziere banco) {
    assert name!=null && banco!=null;

    this.name = name;
    this.banco = banco;
    this.carteIniziali();

    assert mano.size()==NCARTEINIZIALI;
  }


  public int getPuntiBanco(){
    return banco.getPunti();
  }

  //TODO: spiegare in un commento di poche righe se e perché questo setter
  // è sufficiente a garantire la proprietà di immutabilità della strategia di un giocatore

  //Il metodo setStrategy garantisce che il riferimento alla strategia non cambi, e l'immutabilità di tutte
  //le classi che implementano l'interfaccia strategia garantisce che il loro stato interno non cambi, dopo essere
  //assegnato. Quindi questo metodo di per sè non è sufficiente.

  // Inoltre abbiamo aggiunto una post condizione per evitare che un giocatore possa
  //non avere una strategia dopo aver chiamato setStrategia (nel caso venga passata una strategia vuota).


  //@pre this.strategia == null
  //@post this.strategia!=null
  public void setStrategia(Strategia strategia) {
    assert this.strategia == null: "non puoi cambiare strategia se è già settata";
    this.strategia = strategia;
    assert this.strategia!=null;
  }

  @Override
  public void carteIniziali() {
    assert mano.size()==0;
    for (int i = 0; i < NCARTEINIZIALI; i++) {
      mano.add(banco.draw());
    }
  }

  //@pre strategia != null
  @Override
  public void gioca() {
    assert strategia != null : "Per giocare serve una strategia.";
    while (strategia.chiediCarta() && playable()){
      mano.add(banco.draw());
    }

  }

  //Controlla che il giocatore non abbia sballato e che nel caso se ha 21 punti
  private boolean playable() {
    return !this.isSballato() && this.getPunti() != 21;
  }

  @Override
  public Iterator<Card> getCards() {
    return mano.iterator();
  }

  @Override
  public String getName() {
    return name;
  }

}
