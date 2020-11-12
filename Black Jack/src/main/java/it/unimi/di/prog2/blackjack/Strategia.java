package it.unimi.di.prog2.blackjack;



public interface Strategia {

  //NullObject Pattern
  static Strategia STAI = new Strategia() {
    @Override
    public boolean chiediCarta() {
      return false;
    }
  };

  boolean chiediCarta();
}

