package it.unimi.di.prog2.lab09.observer;

public interface Subject<T> {
  void registerObserver(Observer<T> o);
  void notifyObservers();
  T getState();
}
