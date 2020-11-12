package it.unimi.di.sweng.lab06.Factories;

import it.unimi.di.sweng.lab06.Decorator.FelineCoutner;
import it.unimi.di.sweng.lab06.Feline;
import it.unimi.di.sweng.lab06.adapters.FelineDomesticCat;
import it.unimi.di.sweng.lab06.adapters.FelinePelucheCat;
import it.unimi.di.sweng.lab06.baseclasses.DomesticCat;
import it.unimi.di.sweng.lab06.baseclasses.Lion;
import it.unimi.di.sweng.lab06.baseclasses.Tiger;

public class CounterFelineFactory extends AbstractFelineFactory {
    @Override
    public Feline createLion() {
        return new FelineCoutner(new Lion());
    }

    @Override
    public Feline createTiger() {
        return new FelineCoutner(new Tiger());
    }

    @Override
    public Feline createDomesticCat() {
        return new FelineCoutner(new FelineDomesticCat(new DomesticCat()));
    }

    @Override
    public Feline createPelucheCat() {
        return new FelineCoutner(new FelinePelucheCat());
    }
}
