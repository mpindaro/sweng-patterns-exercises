package it.unimi.di.prog2.lab06;

import java.util.ArrayList;
import java.util.List;

public class Orchestra implements MusicalInstrument {
  private List<MusicalInstrument> instruments = new ArrayList<>();

  public void add(MusicalInstrument el) {
    instruments.add(el);
  }

  @Override
  public String play() {
    StringBuilder result = new StringBuilder();
    boolean first = true;
    for (MusicalInstrument instrument : instruments) {
      if (first) first = false;
      else result.append("\n");
      result.append(instrument.play());
    }
    return result.toString();
  }
}
