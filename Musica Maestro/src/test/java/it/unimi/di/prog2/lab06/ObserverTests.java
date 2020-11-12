package it.unimi.di.prog2.lab06;

import it.unimi.di.prog2.lab07.ObservedInstrumentFactory;
import it.unimi.di.prog2.lab07.observer.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

public class ObserverTests {

    @Test
    public void observingS(){


        List<Observer> observers = new ArrayList<>();
        observers.add(mock(Observer.class));
        observers.add(mock(Observer.class));
        observers.add(mock(InstrumentLoggerObserver.class));
        observers.add(spy(new InstrumentLoggerObserver()));



        ObservedInstrumentFactory observedInstrumentFactory = new ObservedInstrumentFactory(observers);
        ObservableInstrument sut= (ObservableInstrument) observedInstrumentFactory.createHorn();

        sut.play();

        for (Observer observer : observers) {
            verify(observer).update(eq(sut), any());
        }

    }

    @Test
    public void countingTesting(){

        InstrumentCounterObserver observer = new InstrumentCounterObserver();

        List<Observer> observers = new ArrayList<>();
        observers.add(observer);
        observers.add(spy(InstrumentLoggerObserver.class));

        ObservedInstrumentFactory observedInstrumentFactory = new ObservedInstrumentFactory(observers);
        ObservableInstrument sutHorn= (ObservableInstrument) observedInstrumentFactory.createHorn();
        ObservableInstrument sutWaterGlass= (ObservableInstrument) observedInstrumentFactory.createWaterGlass();
        ObservableInstrument sutHorn2= (ObservableInstrument) observedInstrumentFactory.createHorn();

        sutHorn.play();
        sutWaterGlass.play();
        sutHorn2.play();

        int n=observer.getCount(WaterGlassInstrument.class.getSimpleName());

        assertEquals(1,n);




    }

    @Test
    public void testResetCount(){
        InstrumentCounterObserver observer = new InstrumentCounterObserver();

        List<Observer> observers = new ArrayList<>();
        observers.add(observer);

        ObservedInstrumentFactory observedInstrumentFactory = new ObservedInstrumentFactory(observers);

        ObservableInstrument sutHorn= (ObservableInstrument) observedInstrumentFactory.createHorn();
        ObservableInstrument sutWaterGlass= (ObservableInstrument) observedInstrumentFactory.createWaterGlass();
        ObservableInstrument sutHorn2= (ObservableInstrument) observedInstrumentFactory.createHorn();

        sutHorn.play();
        sutWaterGlass.play();
        sutHorn2.play();

        int sut;
        sut=observer.getCount(Horn.class.getSimpleName());
        observer.resetCount();
        sutHorn.play();
        sutWaterGlass.play();
        sut=observer.getCount(Horn.class.getSimpleName());
        sut+=observer.getCount(WaterGlassInstrument.class.getSimpleName());


        assertEquals(2,sut);

    }

    @Rule
    public SystemErrRule stderr= new SystemErrRule().enableLog().muteForSuccessfulTests();

    @Test
    public void testlogger(){


        List<Observer> observers = new ArrayList<>();
        observers.add(spy(InstrumentLoggerObserver.class));

        ObservedInstrumentFactory observedInstrumentFactory = new ObservedInstrumentFactory(observers);
        ObservableInstrument sutHorn= (ObservableInstrument) observedInstrumentFactory.createHorn();
        ObservableInstrument sutWaterGlass= (ObservableInstrument) observedInstrumentFactory.createWaterGlass();
        ObservableInstrument sutHorn2= (ObservableInstrument) observedInstrumentFactory.createHorn();

        sutHorn.play();
        sutWaterGlass.play();
        sutHorn2.play();

        assertEquals("Horn\nWaterGlassInstrument\nHorn\n", stderr.getLog());

    }
}
