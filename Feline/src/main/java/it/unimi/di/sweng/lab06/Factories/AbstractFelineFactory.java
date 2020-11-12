package it.unimi.di.sweng.lab06.Factories;

import it.unimi.di.sweng.lab06.Feline;

public abstract class AbstractFelineFactory {
    abstract public Feline createLion();
    abstract public Feline createTiger();
    abstract public Feline createDomesticCat();
    abstract public Feline createPelucheCat();
}
