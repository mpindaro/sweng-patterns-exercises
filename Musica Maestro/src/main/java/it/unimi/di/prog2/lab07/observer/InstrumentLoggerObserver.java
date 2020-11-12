package it.unimi.di.prog2.lab07.observer;

public class InstrumentLoggerObserver implements Observer {

    public InstrumentLoggerObserver(/*ObservableInstrument instrument*/) {
        /*assert instrument!=null;
        instrument.registerObserver(this);*/

    }

    @Override
    public void update(Subject subject, Object state) {
        if (subject instanceof ObservableInstrument){
            ObservableInstrument observableInstrument = (ObservableInstrument)subject;
            System.err.println(observableInstrument.musicalInstrument.getClass().getSimpleName());
        }
    }
}
