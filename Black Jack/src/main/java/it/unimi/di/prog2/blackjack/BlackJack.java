package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {
  public static int cardValue(Card c) {
    return Math.min(c.getRank().ordinal() + 1, 10);
  }

  public static void main(String[] args) {
    Mazziere banco = new Mazziere();

    Sfidante carlo = new Sfidante("Carlo", banco);
    carlo.setStrategia(new IngordoStrategy(Strategia.STAI,carlo));
    Sfidante mattia = new Sfidante("Mattia", banco);
    mattia.setStrategia(new SicuroStrategy(new RandomStrategy(Strategia.STAI),mattia));
    Sfidante violetta = new Sfidante("Violetta", banco);
    violetta.setStrategia(new GuardaBancoStrategy(new SicuroStrategy(Strategia.STAI,violetta),violetta));

    List<Sfidante> sfidanti = new ArrayList<>();
    sfidanti.add(carlo);
    sfidanti.add(mattia);
    sfidanti.add(violetta);


    for (Sfidante sfidante : sfidanti) {
      sfidante.gioca();
    }
    //Per le condizioni presenti nel metodo gioca, sicuramente i giocatori hanno finito il loro turno (hanno un punteggio definitivo, che può essere anche sballato) e quindi il banco può giocare
    banco.gioca();

    System.out.println(banco.asString());
    System.out.println();
    for (Sfidante sfidante : sfidanti) {

      System.out.println(sfidante.asString());
      if (sfidante.isSballato() || (sfidante.getPunti() < banco.getPunti() && !banco.isSballato()))
        System.out.println("Vince il banco.");
      else if (banco.isSballato() || sfidante.getPunti() > banco.getPunti())
        System.out.println("Il banco perde!!!");
      else
        System.out.println("Pareggio.");

    }
  }

}
