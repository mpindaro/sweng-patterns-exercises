package it.unimi.di.sweng.lab06.adapters;

import it.unimi.di.sweng.lab06.Feline;
import it.unimi.di.sweng.lab06.baseclasses.PelucheCat;

public class FelinePelucheCat extends PelucheCat implements Feline {
    @Override
    public void roar() {
        super.jingle();
    }
}
