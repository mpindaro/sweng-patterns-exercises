package it.unimi.di.prog2.esame.observer;

public interface Observer<T> {
  void update(Subject<T> model);
}
