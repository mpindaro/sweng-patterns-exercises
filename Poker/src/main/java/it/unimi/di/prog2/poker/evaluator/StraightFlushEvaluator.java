package it.unimi.di.prog2.poker.evaluator;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Suit;
import it.unimi.di.prog2.poker.ChainedHandEvaluator;
import it.unimi.di.prog2.poker.HandRank;
import it.unimi.di.prog2.poker.PokerHand;

public class StraightFlushEvaluator implements ChainedHandEvaluator {
    ChainedHandEvaluator next;

    public StraightFlushEvaluator(ChainedHandEvaluator nextEvaluator) {
        assert next != null;
        next = nextEvaluator;
    }

    @Override
    public HandRank evaluate(PokerHand pokerHand) {
        pokerHand.order();
        int count=0;
        int i=0;
        int suit=pokerHand.getCards().get(0).getSuit().ordinal();;
        int last = pokerHand.getCards().get(0).getRank().ordinal();
        for (Card card : pokerHand) {
            if(card.getRank().ordinal()==last+1 && i!=0 && suit!=card.getSuit().ordinal()){
                last=card.getRank().ordinal();
                suit=card.getSuit().ordinal();
                count++;
            }else if (i!=0){
                break;
            }
            i++;

        }
        if (count<pokerHand.getCards().size()){
            return next.evaluate(pokerHand);
        }else{
            return HandRank.STRAIGHT;
        }
    }
}
