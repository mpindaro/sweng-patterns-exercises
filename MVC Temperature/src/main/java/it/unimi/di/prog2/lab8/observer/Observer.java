package it.unimi.di.prog2.lab8.observer;

public interface Observer<T> {
  void update(Subject<T> subject, T state);
}
