package it.unimi.di.prog2.lab09.model;

import it.unimi.di.prog2.lab09.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Time implements TimeModel {

  private Time24 gmt;
  private final List<Observer<Time24>> observers = new ArrayList<>();

  public Time(int hour, int minute) {
    assert 0 <= hour && hour < 24;
    assert 0 <= minute && minute < 60;
    gmt = new Time24(hour, minute);
  }

  @Override
  public void setTime(Time24 time) {
    assert time!=null:"Non si può settare un'orario vuoto";
    gmt = new Time24(time.getHour(),time.getMin());
    notifyObservers();
  }

  @Override
  public void registerObserver(Observer<Time24> o) {
    observers.add(o);
  }

  @Override
  public void notifyObservers() {
    for (Observer<Time24> observer : observers) {
      observer.update(getState());
    }
  }

  @Override
  public Time24 getState() {
    return new Time24(gmt.getHour(),gmt.getMin());
  }

}
