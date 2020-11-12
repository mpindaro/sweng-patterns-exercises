package it.unimi.di.prog2.poker.evaluator;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Suit;
import it.unimi.di.prog2.poker.ChainedHandEvaluator;
import it.unimi.di.prog2.poker.HandRank;
import it.unimi.di.prog2.poker.PokerHand;

public class FlushEvaluator implements ChainedHandEvaluator {
    ChainedHandEvaluator next;

    public FlushEvaluator(ChainedHandEvaluator nextEvaluator) {
        assert next != null;
        next = nextEvaluator;
    }

    @Override
    public HandRank evaluate(PokerHand pokerHand) {
        Suit suit=null;
        for (Card card : pokerHand) {
            if (suit==null){
                suit=card.getSuit();
            }else if (suit != card.getSuit()){
                return next.evaluate(pokerHand);
            }
        }
        return HandRank.FLUSH;
    }
}
