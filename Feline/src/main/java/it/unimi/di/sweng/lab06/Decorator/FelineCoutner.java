package it.unimi.di.sweng.lab06.Decorator;

import it.unimi.di.sweng.lab06.Feline;

public class FelineCoutner implements Feline {

    private final Feline feline;
    private static int count;

    public FelineCoutner(Feline feline) {
        assert feline!=null:"Decoro un feline nullo?";
        this.feline=feline;
    }

    public static int getCount(){
        return count;
    }

    public static void resetCount(){
        count=0;
    }

    @Override
    public void roar() {
        count ++;
        feline.roar();
    }
}
