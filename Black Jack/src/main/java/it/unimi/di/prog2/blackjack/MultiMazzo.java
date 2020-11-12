package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Deck;

import java.util.ArrayList;
import java.util.List;


public class MultiMazzo implements DeckInterface {
  private List<Card> mazzo = new ArrayList<>();

  //@pre numMazzi>0: il multimazzo deve essere composto da almeno un mazzo
  //@post mazzo.size()!=0
  public MultiMazzo(int numMazzi) {
    assert numMazzi>0;
    for (int i = 0; i < numMazzi; i++) {
      Deck temp= new Deck();
      temp.shuffle();
      while (!temp.isEmpty()){
        mazzo.add(temp.draw());
      }
    }
    assert mazzo.size()!=0;
  }

  @Override
  public Card draw() {
    assert mazzo.size() > 0;
    return mazzo.remove(0);
  }

  @Override
  public boolean isEmpty() {
    return mazzo.size() == 0;
  }
}
