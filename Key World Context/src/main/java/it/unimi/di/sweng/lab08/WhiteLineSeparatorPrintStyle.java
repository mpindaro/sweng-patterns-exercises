package it.unimi.di.sweng.lab08;

import java.util.ArrayList;

public class WhiteLineSeparatorPrintStyle implements PrintStyle {
    @Override
    public String print(ArrayList<String> list) {
        StringBuilder result = fromKwicToDesideredOutput(list);
        return result.toString();
    }

    private StringBuilder fromKwicToDesideredOutput(ArrayList<String> indexes) {
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < indexes.size(); i++) {
            result.append(indexes.get(i));
            addLineSeparatorIfNotLast(result, i,indexes);
        }
        return result;
    }

    private void addLineSeparatorIfNotLast(StringBuilder result, int pos, ArrayList<String> indexes) {
        if(pos!=indexes.size()-1)
            result.append("\n\n");
    }
}
