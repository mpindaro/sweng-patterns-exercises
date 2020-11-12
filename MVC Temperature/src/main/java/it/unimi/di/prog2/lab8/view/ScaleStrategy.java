package it.unimi.di.prog2.lab8.view;

public interface ScaleStrategy {
  double valueFromCelsius(double temperature);

  double valueToCelsius(double temperature);
}
