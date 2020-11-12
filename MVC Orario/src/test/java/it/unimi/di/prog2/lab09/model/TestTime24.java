package it.unimi.di.prog2.lab09.model;

import it.unimi.di.prog2.lab09.view.TimeZone;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestTime24 {

    @Test
    public void testToStringTimeZone(){
        Time24 sut = new Time24(2,20);
        TimeZone timeZone = new TimeZone("Milano",60);
        assertEquals("Milano 03:20", timeZone.getLabel() + " " + timeZone.convertFromGMT(sut));
    }
}
