package it.unimi.di.prog2.lab07.observer;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String s);
}
