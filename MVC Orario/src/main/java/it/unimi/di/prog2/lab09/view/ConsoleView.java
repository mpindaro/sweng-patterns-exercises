package it.unimi.di.prog2.lab09.view;

import it.unimi.di.prog2.lab09.model.Time24;
import it.unimi.di.prog2.lab09.observer.Observer;

public class ConsoleView implements Observer<Time24> {

    private final TimeZone timeZone;

    public ConsoleView(TimeZone timeZone) {
        assert timeZone!=null:"Non si può assegnare una timezone nulla";
        this.timeZone = timeZone;
    }

    @Override
    public void update(Time24 state) {
        System.out.println(timeZone.getLabel() + " " + timeZone.convertFromGMT(state).toString());
    }

}
