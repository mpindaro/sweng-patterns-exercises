package it.unimi.di.prog2.lab07.observer;

import it.unimi.di.prog2.lab06.MusicalInstrument;

import java.util.ArrayList;
import java.util.List;

public class ObservableInstrument implements MusicalInstrument, Subject{

   protected MusicalInstrument musicalInstrument;
   private List<Observer> observers = new ArrayList<>();

    public ObservableInstrument(MusicalInstrument musicalInstrument) {
        assert musicalInstrument!=null;
        this.musicalInstrument = musicalInstrument;
    }

    @Override
    public String play() {
        String s=musicalInstrument.play();
        this.notifyObservers(musicalInstrument.getClass().getSimpleName());
       return s;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String s) {
        for (Observer observer : observers) {
            observer.update(this,s);
        }
    }
}
