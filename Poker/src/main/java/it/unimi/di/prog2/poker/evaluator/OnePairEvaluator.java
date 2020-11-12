package it.unimi.di.prog2.poker.evaluator;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;
import it.unimi.di.prog2.poker.ChainedHandEvaluator;
import it.unimi.di.prog2.poker.HandRank;
import it.unimi.di.prog2.poker.PokerHand;

public class OnePairEvaluator implements ChainedHandEvaluator {
    ChainedHandEvaluator next;

    public OnePairEvaluator(ChainedHandEvaluator nextEvaluator) {
            assert next != null;
            next = nextEvaluator;
    }

    @Override
    public HandRank evaluate(PokerHand pokerHand) {
        boolean[] present = new boolean[Rank.values().length];
        for (Card card : pokerHand) {
            if (present[card.getRank().ordinal()])
                return HandRank.ONE_PAIR;
            else
                present[card.getRank().ordinal()] = true;}
        return next.evaluate(pokerHand);
    }
}
