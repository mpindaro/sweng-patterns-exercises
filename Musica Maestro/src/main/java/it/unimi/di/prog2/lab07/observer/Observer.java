package it.unimi.di.prog2.lab07.observer;

public interface Observer {
    void update(Subject subject, Object state);
}
