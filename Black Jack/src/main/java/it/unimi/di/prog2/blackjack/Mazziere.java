package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mazziere implements GiocatoreBJ {
  private List<Card> mano = new ArrayList<>();
  private DeckInterface mazzo = new MultiMazzo(6);
  private Card coperta;


  //@post mano.size()!=0
  public Mazziere(){
    carteIniziali();
    assert mano.size()!=0;
  }

  public Card draw() {
    return mazzo.draw();
  }

  @Override
  public void carteIniziali() {
    mano.add(this.draw());
    coperta=this.draw();
  }


  //@pre mano.size()==1: è possibile chiamare 'gioca' solamente quando il mazziere ha una carta scoperta.
  @Override
  public void gioca() {

    assert mano.size()==1;
    scopri();
    while (this.getPunti()<17){
      mano.add(this.draw());
    }

  }

  private void scopri() {
    mano.add(coperta);
  }

  @Override
  public Iterator<Card> getCards() {
    return mano.iterator();
  }

  @Override
  public String getName() {
    return "Banco";
  }


}
