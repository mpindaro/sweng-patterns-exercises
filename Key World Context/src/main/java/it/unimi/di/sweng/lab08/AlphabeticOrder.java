package it.unimi.di.sweng.lab08;

import java.util.ArrayList;
import java.util.Comparator;

public class AlphabeticOrder implements OrderMethod{
    @Override
    public ArrayList<String> sort(ArrayList<String> list) {
        list.sort(Comparator.comparing(o->o.substring(o.indexOf(' '))));
        return list;
    }
}
