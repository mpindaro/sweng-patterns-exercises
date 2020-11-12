package it.unimi.di.sweng.lab08;

import java.util.Iterator;

public class Rotator implements Iterator<String>{

    protected final String[] words;
    private int pos;
    protected static int id;
    protected int myId;

    public Rotator(String line) {
        words = line.split("\\s+");
        myId=id;
        id++;
    }

    @Override
    public boolean hasNext() {
        return pos<words.length;
    }

    @Override
    public String next() {
        StringBuilder result = new StringBuilder(myId+": ");
        addFromPosToLast(result);
        addFromFirstToPos(result);
        pos++;
        return result.toString();
    }

    private void addFromFirstToPos(StringBuilder result) {
        if(pos!=0){
            result.append("   ");
            for (int i = 0; i <pos ; i++) {
                addSeparatorIfNotFirst(result, i!=0);
                result.append(words[i]);
            }
        }
    }

    private void addFromPosToLast(StringBuilder result) {
        for (int i = pos; i < words.length ; i++) {
            addSeparatorIfNotFirst(result, i != pos);
            result.append(words[i]);

        }
    }

    private void addSeparatorIfNotFirst(StringBuilder result, boolean notFirst) {
        if (notFirst)
            result.append(" ");
    }

    public static void resetId() {
        id=0;
    }
}
