package it.unimi.di.sweng.lab08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class NaturalOrder implements OrderMethod{
    @Override
    public ArrayList<String> sort(ArrayList<String> list) {
        list.sort(Comparator.naturalOrder());
        return list;
    }
}
