package it.unimi.di.prog2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MusicalInstrumentCounterTest {
  @Before
  public void setUp() throws Exception {
    MusicalInstrumentCounter.resetCount();
  }

  @Test
  public void countPlaySingleInstrument() {
    MusicalInstrument sut = new MusicalInstrumentCounter(new Horn());

    sut.play();
    sut.play();

    assertEquals(2, MusicalInstrumentCounter.getCount());
  }

  @Test
  public void countPlayMultiInstrument() {
    MusicalInstrument sut = new MusicalInstrumentCounter(new Horn());
    MusicalInstrument sut2 = new MusicalInstrumentCounter(new WaterGlassInstrument());

    sut.play();
    sut2.play();
    sut.play();
    sut2.play();
    sut.play();

    assertEquals(5, MusicalInstrumentCounter.getCount());
  }
}
