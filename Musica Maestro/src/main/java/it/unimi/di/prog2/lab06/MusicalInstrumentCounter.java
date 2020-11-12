package it.unimi.di.prog2.lab06;

public class MusicalInstrumentCounter implements MusicalInstrument {
  private static int count = 0;
  private MusicalInstrument element;

  public MusicalInstrumentCounter(MusicalInstrument element) {
    assert element != null;
    this.element = element;
  }

  public static int getCount() {
    return count;
  }

  public static void resetCount() {
    count = 0;
  }

  @Override
  public String play() {
    count++;
    return element.play();
  }
}
