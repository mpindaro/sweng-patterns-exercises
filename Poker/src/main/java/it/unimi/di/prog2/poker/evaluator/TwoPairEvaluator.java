package it.unimi.di.prog2.poker.evaluator;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import it.unimi.di.prog2.poker.ChainedHandEvaluator;
import it.unimi.di.prog2.poker.HandRank;
import it.unimi.di.prog2.poker.PokerHand;

public class TwoPairEvaluator implements ChainedHandEvaluator {
    ChainedHandEvaluator next;

    public TwoPairEvaluator(ChainedHandEvaluator nextEvaluator) {
        assert next != null;
        next = nextEvaluator;
    }

    @Override
    public HandRank evaluate(PokerHand pokerHand) {
        int[] occurence = new int[13];
        for (Card card : pokerHand) {
            occurence[card.getRank().ordinal()]++;
        }
        int cont=0;
        for (int n : occurence) {
            if (n==2) {
                cont++;
            }
        }
        if (cont==2){
            return HandRank.TWO_PAIR;
        }else{
            return next.evaluate(pokerHand);
        }
    }
}
