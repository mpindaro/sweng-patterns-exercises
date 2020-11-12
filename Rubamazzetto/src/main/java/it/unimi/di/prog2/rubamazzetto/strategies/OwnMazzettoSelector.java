package it.unimi.di.prog2.rubamazzetto.strategies;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import it.unimi.di.prog2.rubamazzetto.Giocatore;
import it.unimi.di.prog2.rubamazzetto.SelettoreCarta;

import java.util.List;

public class OwnMazzettoSelector implements SelettoreCarta {

    SelettoreCarta next;

    public OwnMazzettoSelector(SelettoreCarta next) {
        assert next != null;
        this.next = next;
    }

    @Override
    public Card getCard(Giocatore player, List<Card> mano) {
        assert player!=null && mano!=null && mano.size()>=1;
        for (Card card : mano) {
            if (player.getMazzettoTop()==card.getRank())
                return card;

        }
        return  next.getCard(player,mano);
    }
}
