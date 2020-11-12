package it.unimi.di.sweng.lab08;

public class CompleteRotator extends Rotator {
    public CompleteRotator(String line, String[] stopWords) {
        super(RotatorWithStopWords.deleteStopWords(line.replaceAll("\\p{Punct}",""),stopWords));
    }
}
