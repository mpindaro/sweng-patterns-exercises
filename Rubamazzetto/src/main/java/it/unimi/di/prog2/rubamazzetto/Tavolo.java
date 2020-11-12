package it.unimi.di.prog2.rubamazzetto;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tavolo implements Iterable<Card> {

  private List<Card> scoperte = new ArrayList<>();

  public boolean inMostra(Card aCard) {
    for (Card card : scoperte) {
      if (card.getRank() == aCard.getRank())
      return true;
    }
    return false;
  }

  public void prendi(Card aCard) {
    for (Card card : scoperte) {
      if (card.getRank() == aCard.getRank()) {
        scoperte.remove(card);
        return;
      }
    }
  }

  public void metti(Card aCard) {
    scoperte.add(aCard);
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(scoperte.size());
    s.append(" -> ");

    for (Card card : scoperte) {
      s.append(card.toString());
      s.append(", ");
    }
    return s.toString();
  }


  public int size() {
    return scoperte.size();
  }


  @Override
  public Iterator<Card> iterator() {
    return scoperte.iterator();
  }
}
