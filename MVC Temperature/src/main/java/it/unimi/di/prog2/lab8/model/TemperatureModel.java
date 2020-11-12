package it.unimi.di.prog2.lab8.model;

import it.unimi.di.prog2.lab8.observer.Observer;
import it.unimi.di.prog2.lab8.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class TemperatureModel implements Model, Subject<Double> {

    private double temperature;
    private  List<Observer<Double>> observers=new ArrayList<>();

    @Override
    public double getTemp() {
        return temperature;
    }

    @Override
    public void setTemp(double temp) {
        if (Math.abs(temperature-temp)>0.01) {
            temperature = temp;
            notifyObservers();
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer<Double> observer : observers) {
            observer.update(this,getState());
        }
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public Double getState() {
        return getTemp();
    }
}
