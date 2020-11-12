package it.unimi.di.sweng.lab08;

public abstract class AbstractRotatorFactory {

    public abstract Rotator createSimpleRotator(String line);
    public abstract Rotator createNoPunctRotator(String line);
    public abstract Rotator createRotatorWithStopWords(String line,String[] stopWords);
    public abstract Rotator createCompleteRotator(String line,String[] stopWords);
}
