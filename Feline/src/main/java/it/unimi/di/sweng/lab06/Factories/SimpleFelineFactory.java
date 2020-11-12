package it.unimi.di.sweng.lab06.Factories;

import it.unimi.di.sweng.lab06.Feline;
import it.unimi.di.sweng.lab06.adapters.FelineDomesticCat;
import it.unimi.di.sweng.lab06.adapters.FelinePelucheCat;
import it.unimi.di.sweng.lab06.baseclasses.DomesticCat;
import it.unimi.di.sweng.lab06.baseclasses.Lion;
import it.unimi.di.sweng.lab06.baseclasses.Tiger;

public class SimpleFelineFactory extends AbstractFelineFactory {
    @Override
    public Feline createLion() {
        return new Lion();
    }

    @Override
    public Feline createTiger() {
        return new Tiger();
    }

    @Override
    public Feline createDomesticCat() {
        return new FelineDomesticCat(new DomesticCat());
    }

    @Override
    public Feline createPelucheCat() {
        return new FelinePelucheCat();
    }
}
