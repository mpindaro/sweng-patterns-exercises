package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;

public interface DeckInterface {
  Card draw();

  boolean isEmpty();
}
