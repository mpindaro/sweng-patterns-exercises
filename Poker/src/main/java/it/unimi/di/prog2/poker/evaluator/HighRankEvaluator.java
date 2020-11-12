package it.unimi.di.prog2.poker.evaluator;

import it.unimi.di.prog2.poker.ChainedHandEvaluator;
import it.unimi.di.prog2.poker.HandRank;
import it.unimi.di.prog2.poker.PokerHand;

public class HighRankEvaluator implements ChainedHandEvaluator {
    @Override
    public HandRank evaluate(PokerHand pokerHand) {
        return HandRank.HIGH_CARD;
    }
}
