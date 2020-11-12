package it.unimi.di.prog2.lab09.view;

import it.unimi.di.prog2.lab09.controller.TimeController;
import it.unimi.di.prog2.lab09.model.Time24;
import it.unimi.di.prog2.lab09.observer.Observer;

public interface TimeView extends Observer<Time24> {
  Time24 getGMTTime();
  void addHandler(TimeController handler);
}
