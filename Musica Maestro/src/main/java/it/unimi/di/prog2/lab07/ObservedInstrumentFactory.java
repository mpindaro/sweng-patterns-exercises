package it.unimi.di.prog2.lab07;

import it.unimi.di.prog2.lab06.*;
import it.unimi.di.prog2.lab06.GermaInstrument.IronRod;
import it.unimi.di.prog2.lab07.observer.ObservableInstrument;
import it.unimi.di.prog2.lab07.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObservedInstrumentFactory implements AbstractInstrumentFactory{

    List<Observer> observers =  new ArrayList<>();

    public ObservedInstrumentFactory(List<Observer> observers) {
        this.observers=observers;
    }

    @Override
    public MusicalInstrument createTrumpet() {
        ObservableInstrument trumpet=new ObservableInstrument(new Trumpet());
        for (Observer observer : observers) {
            trumpet.registerObserver(observer);
        }
        return trumpet;

    }

    @Override
    public MusicalInstrument createHorn() {
        ObservableInstrument horn=new ObservableInstrument(new Horn());
        for (Observer observer : observers) {
            horn.registerObserver(observer);
        }
        return horn;
    }

    @Override
    public MusicalInstrument createWaterGlass() {

        ObservableInstrument waterglass=new ObservableInstrument(new WaterGlassInstrument());
        for (Observer observer : observers) {
            waterglass.registerObserver(observer);
        }
        return waterglass;
    }

    @Override
    public MusicalInstrument createIronRod() {
        ObservableInstrument ironrod=new ObservableInstrument(new GermanMusicInstrument(new IronRod()));
        for (Observer observer : observers) {
            ironrod.registerObserver(observer);
        }
        return ironrod;
    }
}
