package it.unimi.di.prog2.poker;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.Comparator;

public class CardComperator implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
       if (c1.getSuit().ordinal()>c2.getSuit().ordinal()){
           return 1;
       }else if (c1.getSuit().ordinal()<c2.getSuit().ordinal()){
           return -1;
       }else{
           if (c1.getRank().ordinal()>c2.getRank().ordinal()){
               return 1;
           }else if (c1.getRank().ordinal()<c2.getRank().ordinal()) {
               return -1;
           }else
               return 0;
       }


    }
}
