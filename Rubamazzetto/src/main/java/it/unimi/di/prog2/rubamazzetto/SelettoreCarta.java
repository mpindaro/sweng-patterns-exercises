package it.unimi.di.prog2.rubamazzetto;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.List;

public interface SelettoreCarta {
    public Card getCard(Giocatore player, List<Card> mano);
}
