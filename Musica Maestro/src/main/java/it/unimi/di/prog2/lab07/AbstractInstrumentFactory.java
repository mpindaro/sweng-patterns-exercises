package it.unimi.di.prog2.lab07;

import it.unimi.di.prog2.lab06.MusicalInstrument;

interface AbstractInstrumentFactory {
  MusicalInstrument createTrumpet();

  MusicalInstrument createHorn();

  MusicalInstrument createWaterGlass();

  MusicalInstrument createIronRod();
}
