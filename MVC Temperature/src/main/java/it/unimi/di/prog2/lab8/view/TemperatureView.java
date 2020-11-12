package it.unimi.di.prog2.lab8.view;

import it.unimi.di.prog2.lab8.controller.AbstractController;

public interface TemperatureView {
  void addListener(AbstractController controller);

  double getTempValue();
}
