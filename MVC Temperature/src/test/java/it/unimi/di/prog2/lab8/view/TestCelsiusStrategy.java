package it.unimi.di.prog2.lab8.view;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestCelsiusStrategy {

  @Test
  public void testValueFrom() {
    ScaleStrategy scale = CelsiusScale.INSTANCE;
    double v = scale.valueFromCelsius(100.12);
    assertEquals(100.12, v, 0.01);
  }

  @Test
  public void testValueTo() {
    ScaleStrategy scale = CelsiusScale.INSTANCE;
    double v = scale.valueToCelsius(100.12);
    assertEquals(100.12, v, 0.01);
  }
}
