package it.unimi.di.prog2.rubamazzetto.strategies;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import it.unimi.di.prog2.rubamazzetto.Giocatore;
import it.unimi.di.prog2.rubamazzetto.SelettoreCarta;

import java.util.List;

public class RandomSelector implements SelettoreCarta {

    @Override
    public Card getCard(Giocatore g, List<Card> mano) {
        assert mano!= null && g!= null && mano.size()>0;

        int random = (int)Math.random()*mano.size();

        return  mano.get(random);
    }
}
