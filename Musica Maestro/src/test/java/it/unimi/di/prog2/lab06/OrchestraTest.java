package it.unimi.di.prog2.lab06;

import it.unimi.di.prog2.lab07.DecoratedInstrumentFactory;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.junit.Test;

import javax.tools.OptionChecker;

import static org.junit.Assert.*;

public class OrchestraTest {
  @Test
  public void testOrchestra() {

    DecoratedInstrumentFactory decoratedInstrumentFactory= new DecoratedInstrumentFactory();
    Orchestra orchestra= new Orchestra();
    for (int i = 0; i < 5; i++) {
      orchestra.add(decoratedInstrumentFactory.createHorn());
    }

    for (int i = 0; i < 5; i++) {
      orchestra.add(decoratedInstrumentFactory.createWaterGlass());
    }

    orchestra.play();

    assertEquals(10, MusicalInstrumentCounter.getCount());
  }
}