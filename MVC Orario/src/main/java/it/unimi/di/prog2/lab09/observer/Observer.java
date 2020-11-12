package it.unimi.di.prog2.lab09.observer;

public interface Observer<T> {
  void update(T state);
}
