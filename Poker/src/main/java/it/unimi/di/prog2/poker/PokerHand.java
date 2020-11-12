package it.unimi.di.prog2.poker;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Deck;
import it.unimi.di.prog2.poker.evaluator.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PokerHand implements Iterable<Card>{
    private List<Card> cards;

    public PokerHand(int numCards, Deck deck) {
        cards = new ArrayList<>();
        for (int i = 0; i < numCards && !deck.isEmpty(); i++) {
            cards.add(deck.draw());
        }
    }

    public HandRank getRank() {

        ChainedHandEvaluator start= new StraightFlushEvaluator(new FourOfKindEvaluator(new FullHouseEvaluator(new FlushEvaluator(new StraightEvaluator(new ThreeOfKindEvaluator(new TwoPairEvaluator(new OnePairEvaluator(new HighRankEvaluator()))))))));
        return start.evaluate(this);
    }

    @Override
    public String toString() {
        StringBuilder ris = new StringBuilder();
        for (Card card : cards) {
            ris.append(card.toString());
            ris.append("\n");
        }
        return ris.toString();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void order(){
        PokerHand temp=this;
        cards.sort(new CardComperator());
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }
}
