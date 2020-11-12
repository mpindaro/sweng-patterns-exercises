package it.unimi.di.prog2.lab09.model;

import it.unimi.di.prog2.lab09.model.Time24;
import it.unimi.di.prog2.lab09.view.TimeView;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static junit.framework.TestCase.assertEquals;

public class TestTime {
    @Test
    public void testSetTime(){
        Time sut = new Time(3,40);

        TimeView timeView=mock(TimeView.class);
        Time24 time24 = new Time24(4,40);
        when(timeView.getGMTTime()).thenReturn(time24);

        sut.registerObserver(timeView);

        sut.setTime(timeView.getGMTTime());

        verify(timeView).update(time24);
    }
}
