package it.unimi.di.sweng.lab06;

import java.util.ArrayList;
import java.util.List;

public class Gang implements Feline {

    private final List<Feline> felines= new ArrayList<>();


    public void add(Feline feline){
        felines.add(feline);
    }

    @Override
    public void roar() {
        for (Feline feline : felines) {
            feline.roar();
        }
    }
}
