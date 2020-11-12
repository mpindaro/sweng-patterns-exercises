package it.unimi.di.prog2.poker.evaluator;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;
import it.unimi.di.prog2.poker.ChainedHandEvaluator;
import it.unimi.di.prog2.poker.HandRank;
import it.unimi.di.prog2.poker.PokerHand;

public class ThreeOfKindEvaluator implements ChainedHandEvaluator {
    ChainedHandEvaluator next;

    public ThreeOfKindEvaluator(ChainedHandEvaluator nextEvaluator) {
        assert next != null;
        next = nextEvaluator;
    }

    @Override
    public HandRank evaluate(PokerHand pokerHand) {
        int[] ranks=new int[13];
        for (Card card : pokerHand) {
            ranks[card.getRank().ordinal()]++;
        }
        for (int i = 0; i < ranks.length ; i++) {
            if(ranks[i]==3){
                return HandRank.THREE_OF_A_KIND;
            }
        }
        return next.evaluate(pokerHand);
    }
}
