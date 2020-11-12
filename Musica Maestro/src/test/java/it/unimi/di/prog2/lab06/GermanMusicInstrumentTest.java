package it.unimi.di.prog2.lab06;

import static org.junit.Assert.*;

import it.unimi.di.prog2.lab06.GermaInstrument.IronRod;
import it.unimi.di.prog2.lab07.SimpleInstrumentFactory;
import org.junit.Test;

public class GermanMusicInstrumentTest {
  @Test
  public void play() {
    MusicalInstrument sut = new GermanMusicInstrument(new IronRod());

    assertEquals("tatang", sut.play());
  }
}
