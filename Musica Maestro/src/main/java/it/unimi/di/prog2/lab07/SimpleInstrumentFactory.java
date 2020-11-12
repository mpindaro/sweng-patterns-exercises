package it.unimi.di.prog2.lab07;

import it.unimi.di.prog2.lab06.*;
import it.unimi.di.prog2.lab06.GermaInstrument.IronRod;

public class SimpleInstrumentFactory implements AbstractInstrumentFactory {

    @Override
    public MusicalInstrument createTrumpet() {
        return new Trumpet();
    }

    @Override
    public MusicalInstrument createHorn() {
        return new Horn();
    }

    @Override
    public MusicalInstrument createWaterGlass() {
        return new WaterGlassInstrument();
    }

    @Override
    public MusicalInstrument createIronRod() {
        return new GermanMusicInstrument(new IronRod());
    }
}
