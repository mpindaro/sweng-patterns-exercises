package it.unimi.di.prog2.lab09.view;

import it.unimi.di.prog2.lab09.model.Time;
import it.unimi.di.prog2.lab09.model.Time24;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestTimeZone {

    @Test
    public void testConvertToGMT(){
        TimeZone sut = new TimeZone("Milano",90);
        Time24 time = sut.convertToGMT(new Time24(23,59));
        assertEquals("22:29",time.toString());
    }

    @Test
    public void testConvertFromGMT(){
        TimeZone sut = new TimeZone("Milano",90);
        Time24 time = sut.convertFromGMT(new Time24(23,59));
        assertEquals("01:29",time.toString());
    }
}
