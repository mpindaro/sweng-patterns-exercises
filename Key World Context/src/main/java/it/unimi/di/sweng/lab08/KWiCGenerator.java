package it.unimi.di.sweng.lab08;

import java.io.Reader;
import java.util.*;

public class KWiCGenerator {

    private PrintStyle printStyle;
    private ArrayList<String> indexes;
    private AbstractRotatorFactory factory;
    private OrderMethod orderMethod;

    public KWiCGenerator(Reader input) {
        this(input,false,new String[]{});
    }

    public KWiCGenerator(Reader input,boolean punct){
        this(input,punct,new String[]{});
    }

    public KWiCGenerator(Reader input, boolean punct, String[] stopWords) {
       this(input,punct,stopWords,new AlphabeticOrder());
    }

    public KWiCGenerator(Reader input,OrderMethod orderMethod){
        this(input,false,null,orderMethod);
    }

    public KWiCGenerator(Reader input, boolean punct,String[] stopWords,OrderMethod orderMethod) {
       this(input,punct,stopWords,orderMethod,new ClassicPrintStyle());
    }

    public KWiCGenerator(Reader input, PrintStyle printStyle) {
        this(input,false,null, new AlphabeticOrder(),printStyle);
    }

    public KWiCGenerator(Reader input, boolean punct,String[] stopWords,OrderMethod orderMethod,PrintStyle printStyle) {
        this.orderMethod=orderMethod;
        this.printStyle=printStyle;
        factory=new RotatorFactory();
        indexes=new ArrayList<>();

        Scanner scanner=new Scanner(input);
        Rotator rotator;
        String line;
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            rotator = selectRightRotator(punct, stopWords, line);
            while(rotator.hasNext())
                indexes.add(rotator.next());
        }

        indexes=orderMethod.sort(indexes);
    }


    private Rotator selectRightRotator(boolean punct, String[] stopWords, String line) {
        return (punct && thereAreStopWords(stopWords))?factory.createCompleteRotator(line,stopWords):selectPartialOrSimpleRotator(punct,stopWords,line);
    }

    private boolean thereAreStopWords(String[] stopWords) {
        return stopWords != null && stopWords.length > 0;
    }

    private Rotator selectPartialOrSimpleRotator(boolean punct, String[] stopWords, String line) {
        return thereAreStopWords(stopWords)?factory.createRotatorWithStopWords(line,stopWords):selectNoPunctOrSimpleRotator(punct,line);
    }

    private Rotator selectNoPunctOrSimpleRotator(boolean punct, String line) {
        return punct?factory.createNoPunctRotator(line):factory.createSimpleRotator(line);
    }

    @Override
    public String toString(){
        return printStyle.print(indexes);
    }

    public void setOrderMethod(OrderMethod orderMethod) {
        this.orderMethod=orderMethod;
        orderMethod.sort(indexes);
    }

    public void setPrintStyle(PrintStyle printStyle) {
        this.printStyle=printStyle;
    }
}
