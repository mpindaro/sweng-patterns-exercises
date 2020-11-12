package it.unimi.di.prog2.lab06;

import it.unimi.di.prog2.lab06.GermaInstrument.GermanPercussiveInstrument;

public class GermanMusicInstrument implements MusicalInstrument {
  private GermanPercussiveInstrument adaptee;

  public GermanMusicInstrument(GermanPercussiveInstrument adaptee) {
    assert adaptee != null;
    this.adaptee = adaptee;
  }

  @Override
  public String play() {
    return adaptee.spiel();
  }
}
