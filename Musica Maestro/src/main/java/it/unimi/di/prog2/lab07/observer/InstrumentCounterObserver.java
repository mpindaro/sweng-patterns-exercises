package it.unimi.di.prog2.lab07.observer;

import it.unimi.di.prog2.lab06.Horn;

import java.util.HashMap;
import java.util.Map;

public class InstrumentCounterObserver implements Observer {

    Map<String,Integer> counters = new HashMap<>();

    public InstrumentCounterObserver() {
    }

    public InstrumentCounterObserver(ObservableInstrument instrument) {
        assert instrument!=null;
        instrument.registerObserver(this);

    }

    public int getCount(final String name){
        assert counters.containsKey(name);
        return counters.get(name);
    }

    @Override
    public void update(Subject subject, Object state) {
        if (state instanceof String){
            String s=(String) state;
            counters.put(s, counters.getOrDefault(s, 0)+1);
        }
    }

    public void resetCount(){
       counters.clear();
    }
}
