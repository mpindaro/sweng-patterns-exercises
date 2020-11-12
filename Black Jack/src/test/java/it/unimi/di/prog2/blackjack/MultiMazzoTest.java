package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MultiMazzoTest {

  @Test
  public void draw() {
    int NUM = 6;
    MultiMazzo mazzo = new MultiMazzo(NUM);

    Map<Card,Integer> count = new HashMap<>();
    int counter=0;
    while (!mazzo.isEmpty()) {
      Card card = mazzo.draw();
      counter++;
      count.put(card, 1 + count.getOrDefault(card,0));
    }

    assertEquals(NUM*52, counter);
    for (Integer value : count.values()) {
      assertEquals(NUM , value.intValue());
    }
  }
}