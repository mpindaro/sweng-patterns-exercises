package it.unimi.di.prog2.poker;

import ca.mcgill.cs.stg.solitaire.cards.Deck;

import java.util.Scanner;

public class PokerTable
{
    public static void main(String[] args) {
        Deck deck = new Deck();
        int numplayers;
        int[] players;
        PokerHand[] hands;
        Scanner scan= new Scanner(System.in);

        System.out.println("Inserire il numero di giocatori");
        numplayers = scan.nextInt();
        players =new int[numplayers];
        hands =new PokerHand[numplayers];

        deck.shuffle();
        for (int i = 0; i < numplayers; i++) {
            System.out.println("Giocatore numero " + i + ", è il turno!");
            hands[i]=new PokerHand(5, deck);
            System.out.println();
        }


        PokerHand pokerHand = new PokerHand(5, deck);
        pokerHand.order();
        System.out.println(pokerHand);
        System.out.println((pokerHand.getRank()));
    }

}
