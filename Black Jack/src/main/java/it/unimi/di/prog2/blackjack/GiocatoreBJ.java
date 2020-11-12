package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;

import java.util.Iterator;

public interface GiocatoreBJ {
  void carteIniziali();

  void gioca();

  Iterator<Card> getCards();

  String getName();

  default int getPunti() {
    int ris = 0;
    boolean assi = false;
    for (Iterator<Card> cards = getCards(); cards.hasNext(); ) {
      Card card = cards.next();
      ris += BlackJack.cardValue(card);
      if (card.getRank() == Rank.ACE) assi = true;
    }
    if (assi && ris + 10 <= 21) return ris + 10;
    return ris;
  }

  default boolean isSballato() {
    return getPunti() > 21;
  }

  default String asString() {
    final StringBuilder sb = new StringBuilder(getName());
    sb.append(": ").append("[").append(getPunti()).append("] ");
    for (Iterator<Card> cards = getCards(); cards.hasNext(); ) {
      Card card = cards.next();
      sb.append(card).append(" ");
    }
    if (isSballato()) {
      sb.append("SBALLATO");
    }
    return sb.toString();
  }
}
