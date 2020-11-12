package it.unimi.di.prog2.lab06;

import static org.junit.Assert.*;

import org.junit.Test;

public class WaterGlassInstrumentTest {

  @Test
  public void play() {
    MusicalInstrument sut = new WaterGlassInstrument();

    assertEquals("diding", sut.play());
  }
}
