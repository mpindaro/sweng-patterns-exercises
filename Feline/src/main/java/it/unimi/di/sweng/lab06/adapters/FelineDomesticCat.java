package it.unimi.di.sweng.lab06.adapters;

import it.unimi.di.sweng.lab06.Feline;
import it.unimi.di.sweng.lab06.baseclasses.DomesticCat;

public class FelineDomesticCat implements Feline {

    private final DomesticCat adaptee;

    public FelineDomesticCat(DomesticCat adaptee) {
        assert adaptee!=null: "Non si può adattare un oggetto vuoto";
        this.adaptee = adaptee;
    }

    @Override
    public void roar() {
        adaptee.meow();
    }
}
