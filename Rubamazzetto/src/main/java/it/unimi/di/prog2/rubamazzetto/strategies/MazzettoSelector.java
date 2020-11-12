package it.unimi.di.prog2.rubamazzetto.strategies;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import it.unimi.di.prog2.rubamazzetto.Giocatore;
import it.unimi.di.prog2.rubamazzetto.SelettoreCarta;

import java.util.Iterator;
import java.util.List;

public class MazzettoSelector implements SelettoreCarta {

    SelettoreCarta next;

    public MazzettoSelector(SelettoreCarta next) {
        assert next != null;
        this.next = next;
    }

    @Override
    public Card getCard(Giocatore g, List<Card> mano) {
        assert g!=null && mano!=null && mano.size()>=1;
        Iterator<Giocatore> altri= g.getAltri();
        while (altri.hasNext()){
            Giocatore altro=altri.next();
            for (Card card : mano) {
                if (card.getRank() ==  altro.getMazzettoTop())
                    return card;
            }

        }
        return next.getCard(g,mano);

    }
}
