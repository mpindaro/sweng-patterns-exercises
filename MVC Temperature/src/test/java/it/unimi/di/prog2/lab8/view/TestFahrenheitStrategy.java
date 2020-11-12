package it.unimi.di.prog2.lab8.view;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestFahrenheitStrategy {
  @Test
  public void testValueFrom() {
    //	°F = °C × 1,8 + 32
    ScaleStrategy scale = FahrenheitScale.INSTANCE;
    double v = scale.valueFromCelsius(0);
    assertEquals(32, v, 0.01);
  }

  @Test
  public void testValueTo() {
    //	°C = (°F − 32) / 1,8
    ScaleStrategy scale = FahrenheitScale.INSTANCE;
    double v = scale.valueToCelsius(32);
    assertEquals(0, v, 0.01);
  }
}
