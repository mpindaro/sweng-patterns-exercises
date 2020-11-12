package it.unimi.di.prog2.lab07;

import it.unimi.di.prog2.lab06.*;
import it.unimi.di.prog2.lab06.GermaInstrument.IronRod;

public class DecoratedInstrumentFactory implements AbstractInstrumentFactory {
    @Override
    public MusicalInstrument createTrumpet() {
        return new MusicalInstrumentCounter(new Trumpet());
    }

    @Override
    public MusicalInstrument createHorn() {
        return new MusicalInstrumentCounter(new Horn());
    }

    @Override
    public MusicalInstrument createWaterGlass() {
        return new MusicalInstrumentCounter(new WaterGlassInstrument());
    }

    @Override
    public MusicalInstrument createIronRod() {
        return new MusicalInstrumentCounter(new GermanMusicInstrument(new IronRod())) ;
    }
}
