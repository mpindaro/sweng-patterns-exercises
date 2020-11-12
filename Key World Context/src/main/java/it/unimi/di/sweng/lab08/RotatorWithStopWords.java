package it.unimi.di.sweng.lab08;

public class RotatorWithStopWords extends Rotator {

    public RotatorWithStopWords(String line, String[] stopWords) {
        super(RotatorWithStopWords.deleteStopWords(line,stopWords));
    }

    static String deleteStopWords(String line,String[] stopWords){
        boolean firstWordIsStopWord=false;
        String[] words=line.split(" ");
        for (int i = 0; i <stopWords.length ; i++) {
            if(stopWords[i].equals(words[0])){
                line=" "+line;
                firstWordIsStopWord= true;
                break;
            }
        }
        for(String stopWord: stopWords)
            line=line.replaceAll("\\s+"+stopWord,"");
        if(firstWordIsStopWord)
            line=line.substring(1);
        return line;
    }
}
