package it.unimi.di.prog2.poker.evaluator;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import it.unimi.di.prog2.poker.ChainedHandEvaluator;
import it.unimi.di.prog2.poker.HandRank;
import it.unimi.di.prog2.poker.PokerHand;

public class FullHouseEvaluator implements ChainedHandEvaluator {
    ChainedHandEvaluator next;

    public FullHouseEvaluator(ChainedHandEvaluator nextEvaluator) {
        assert next != null;
        next = nextEvaluator;
    }

    @Override
    public HandRank evaluate(PokerHand pokerHand) {
        int[] ranks=new int[13];
        for (Card card : pokerHand) {
            ranks[card.getRank().ordinal()]++;
        }
        boolean t1,t2;
        t1=false;
        t2=false;
        for (int i = 0; i < ranks.length ; i++) {
            if(ranks[i]==3){
                t1=true;
            }else if(ranks[i]==2){
                t2=true;
            }
        }
        if (t1 && t2){
         return HandRank.FULL_HOUSE;
        }else {
            return next.evaluate(pokerHand);
        }
    }
}
