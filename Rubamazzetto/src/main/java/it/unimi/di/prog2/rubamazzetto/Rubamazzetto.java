package it.unimi.di.prog2.rubamazzetto;

import it.unimi.di.prog2.rubamazzetto.strategies.MazzettoSelector;
import it.unimi.di.prog2.rubamazzetto.strategies.OwnMazzettoSelector;
import it.unimi.di.prog2.rubamazzetto.strategies.RandomSelector;
import it.unimi.di.prog2.rubamazzetto.strategies.TableSelector;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rubamazzetto {
  public static void main(String[] args) {
    List<Giocatore> partecipanti = new ArrayList<>();

    Scanner s=new Scanner(System.in);
    int scelta=0;
    System.out.println("Quanti partecipanti?");
    int npartecipanti=s.nextInt();


    for (int i=0; i<npartecipanti; i++) {

      System.out.println("Come ti chiami?");
      Giocatore giocatore= new Giocatore(s.next());
      System.out.println("Vuoi giocare in modo 1- Aggressivo 2- Difensivo 3-Egoista 4-Caotico ?");
      scelta=s.nextInt();
      switch (scelta){
        case 2:
          giocatore.setStrategia(  new OwnMazzettoSelector(new MazzettoSelector(new TableSelector(new RandomSelector()))));
          break;
        case 1:
          giocatore.setStrategia(  new MazzettoSelector(new OwnMazzettoSelector(new TableSelector(new RandomSelector()))));
          break;
        case 3:
          giocatore.setStrategia(new TableSelector(new OwnMazzettoSelector(new MazzettoSelector(new RandomSelector()))));
          break;
        default:giocatore.setStrategia(new RandomSelector());
          break;
      }
      partecipanti.add(giocatore);
    }

    Partita p = new Partita(partecipanti);

    p.distribuisciMano(3);
    System.out.println(p);

    while (!p.isFinita()){

      for (Giocatore giocatore : partecipanti)
        giocatore.turno();

      if (!p.notDrawable())
        p.distribuisciMano(1);

      System.out.println(p);
    }
    System.out.println(p.getVincitore());
  }


}
