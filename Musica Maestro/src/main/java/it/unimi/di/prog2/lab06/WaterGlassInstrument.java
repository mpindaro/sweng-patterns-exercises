package it.unimi.di.prog2.lab06;

public class WaterGlassInstrument extends WaterGlass implements MusicalInstrument {
  @Override
  public String play() {
    return tap();
  }
}
