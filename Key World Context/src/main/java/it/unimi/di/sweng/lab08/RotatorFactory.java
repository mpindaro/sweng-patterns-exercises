package it.unimi.di.sweng.lab08;

public class RotatorFactory extends AbstractRotatorFactory {
    @Override
    public Rotator createSimpleRotator(String line) {
        return new Rotator(line);
    }

    @Override
    public Rotator createNoPunctRotator(String line) {
        return new NoPunctRotator(line);
    }

    @Override
    public Rotator createRotatorWithStopWords(String line, String[] stopWords) {
        return new RotatorWithStopWords(line,stopWords);
    }

    @Override
    public Rotator createCompleteRotator(String line, String[] stopWords) {
        return new CompleteRotator(line,stopWords);
    }
}
