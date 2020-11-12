package it.unimi.di.prog2.rubamazzetto;

import ca.mcgill.cs.stg.solitaire.cards.CardStack;
import ca.mcgill.cs.stg.solitaire.cards.Deck;

import java.util.ArrayList;
import java.util.List;

public class Partita {
  private final Deck mazzo = new Deck();
  private List<Giocatore> giocatori;

  public static final Tavolo TAVOLO = new Tavolo();
  public Partita(List<Giocatore> partecipanti) {

    giocatori = partecipanti;
    for (Giocatore giocatore : giocatori) {
      for (Giocatore other : giocatori) {
       if (!other.equals(giocatore))
         giocatore.addAltro(other);
      }
    }
    for (int i = 0; i < 4; i++) {
      TAVOLO.metti(mazzo.draw());
    }
  }

  private void distribuisciCarta(){
    assert deckSize() >= giocatori.size();

    for (Giocatore giocatore : giocatori) {
      giocatore.daiCarta(mazzo.draw());
    }
  }

  public void distribuisciMano(int num){
    // PRE CONDIZIONI
    assert num <= 3;

    //distribuisce fino a num carte per giocatore con il vincolo di dare a tutti lo stesso numero di carte
    if (deckSize()>=num*giocatori.size()) {
      for (Giocatore giocatore : giocatori) {
        for (int i = 0; i < num; i++) {
          giocatore.daiCarta(mazzo.draw());
        }
      }
    }


    // POST CONDIZIONI
    int numcards = -1;
    for (Giocatore giocatore : giocatori) {
      assert giocatore.numCards() <= 3 : "non si possono avere più di tre carte in mano";

      if (numcards == -1) numcards = giocatore.numCards();
      else assert numcards == giocatore.numCards() : "non è stato dato stesso numero di carte a tutti";

      assert giocatore.numCards() == 3 || notDrawable() : "si possono avere meno di tre carte solo se nel mazzo non ce ne sono abbastanza per fare un altro giro";
    }
  }


  public boolean isFinita(){

    assert giocatori.size() > 1;
    return notDrawable() && areEmptyHands(getCartegiocate());

  }

  private int getCartegiocate() {
    int cartegiocate = TAVOLO.size();

    for (Giocatore giocatore : giocatori) {
      cartegiocate += giocatore.getPunti();
    }
    return cartegiocate;
  }


  private boolean areEmptyHands(int cartegiocate) {
    return 52 - cartegiocate == deckSize();
  }


  public boolean notDrawable() {
    return deckSize() < giocatori.size();
  }

  private int deckSize(){
    int s = 0;
    CardStack tmp = new CardStack();
    while (!mazzo.isEmpty()){
      tmp.push(mazzo.draw());
      s += 1;
    }
    while (!tmp.isEmpty()){
      mazzo.push(tmp.pop());
    }
    return s;
  }

  public String getVincitore(){
    List<Integer> punteggi = new ArrayList<>();
    getPunti(punteggi);
    String vincitore=null;
    int max = getMaxPunteggio(punteggi);

    for (Giocatore giocatore : giocatori) {
      if (max==giocatore.getPunti()){
        vincitore=giocatore.getNome();
      }
    }

    return vincitore;
  }

  private void getPunti(List<Integer> punteggi) {
    for (Giocatore giocatore : giocatori) {
      punteggi.add(giocatore.getPunti());
    }
  }

  private int getMaxPunteggio(List<Integer> punteggi) {
    int max=Integer.MIN_VALUE;
    for (Integer punteggio : punteggi) {
      if (punteggio > max){
        max=punteggio;
      }
    }
    return max;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Giocatore giocatore : giocatori) {
      s.append(giocatore.toString());
      s.append("\n");
    }
    s.append("Tavolo: ");
    s.append(TAVOLO.toString());
    s.append("\n");
    s.append("Finita: ");
    s.append(isFinita());
    return s.toString();
  }
}
