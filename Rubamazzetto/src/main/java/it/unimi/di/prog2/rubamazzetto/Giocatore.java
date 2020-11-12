package it.unimi.di.prog2.rubamazzetto;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Giocatore {

  private final String nome;
  private List<Card> mano = new ArrayList<>();
  private Rank mazzettoTop;
  private List<Giocatore> altri = new ArrayList<>();
  private int punti;
  private SelettoreCarta strategia;

  public Giocatore(String nome) {
    this.nome = nome;
  }

  public Rank getMazzettoTop() {
    return mazzettoTop;
  }

  public Iterator<Giocatore> getAltri() {
    return altri.iterator();
  }

  public void addAltro(Giocatore g) {
    if (!altri.contains(g))
      altri.add(g);
  }

  public int getPunti() {
    return punti;
  }

  public void daiCarta(Card carta) {
    mano.add(carta);
  }

  public void setStrategia(SelettoreCarta strategia) {
    this.strategia = strategia;
  }


  public void turno() {
    assert strategia != null;
    final Card aCard = strategia.getCard(this, mano);

    boolean stop = false;
    if (Partita.TAVOLO.inMostra(aCard)) {
      prendi(aCard);
      stop = true;
    }

    if (!stop) {
      Iterator<Giocatore> giocatori = this.getAltri();
      while (giocatori.hasNext()) {
        Giocatore g = giocatori.next();
        if (g.getMazzettoTop() == aCard.getRank()) {
          ruba(aCard, g);
          stop = true;
        }
      }
    }
    if (!stop) {
      cala(aCard);
    }

  }

  private void prendi(Card aCard) {
    Partita.TAVOLO.prendi(aCard);
    mano.remove(aCard);
    punti += 2;
    this.mazzettoTop = aCard.getRank();
  }

  private void ruba(Card aCard, Giocatore g) {
    assert this != null;
    this.punti += g.punti + 1;
    this.mazzettoTop = g.getMazzettoTop();
    g.punti = 0;
    g.mazzettoTop = null;
    mano.remove(aCard);
  }

  private void cala(Card aCard) {
    Partita.TAVOLO.metti(aCard);
    mano.remove(aCard);
  }


  @Override
  public String toString() {
    StringBuilder s = new StringBuilder(nome);
    s.append(": ");
    s.append("[").append(mano.size()).append("]");
    if (punti > 0) {
      s.append("mazzetto con ");
      s.append(punti);
      s.append(" carte, cima ");
      s.append(mazzettoTop);
      s.append("; ");
    }
    for (Card card : mano) {
      s.append(card.toString());
      s.append(", ");
    }
    return s.toString();
  }

  public int numCards() {
    return mano.size();
  }

  public String getNome() {
    return nome;
  }
}