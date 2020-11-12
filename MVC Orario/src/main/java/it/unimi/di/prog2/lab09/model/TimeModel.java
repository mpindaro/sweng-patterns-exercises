package it.unimi.di.prog2.lab09.model;

import it.unimi.di.prog2.lab09.observer.Subject;

public interface TimeModel extends Subject<Time24> {
  void setTime(Time24 time);
}
