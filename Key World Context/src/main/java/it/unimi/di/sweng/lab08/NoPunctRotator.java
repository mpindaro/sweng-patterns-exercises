package it.unimi.di.sweng.lab08;

public class NoPunctRotator extends Rotator {
    public NoPunctRotator(String line) {
        super(line.replaceAll("\\p{Punct}",""));
    }
}
