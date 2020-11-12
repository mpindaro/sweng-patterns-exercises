package it.unimi.di.prog2.rubamazzetto.strategies;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import it.unimi.di.prog2.rubamazzetto.Giocatore;
import it.unimi.di.prog2.rubamazzetto.Partita;
import it.unimi.di.prog2.rubamazzetto.SelettoreCarta;

import java.util.List;

public class TableSelector implements SelettoreCarta {

    private SelettoreCarta next;

    public TableSelector(SelettoreCarta next) {
        assert next != null;
        this.next = next;
    }

    @Override
    public Card getCard(Giocatore giocatore, List<Card> mano) {
        assert mano!= null && giocatore!= null && mano.size()>0;

        for (Card card : mano) {
            if (Partita.TAVOLO.inMostra(card))
                return card;
        }

        return  next.getCard(giocatore,mano);


    }
}
