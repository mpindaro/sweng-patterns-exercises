package it.unimi.di.sweng.lab06.decorator;

import it.unimi.di.sweng.lab06.Decorator.FelineCoutner;
import it.unimi.di.sweng.lab06.Factories.CounterFelineFactory;
import it.unimi.di.sweng.lab06.Feline;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.Timeout;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.Assert.*;

public class FelineCounterTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog();

    @Test
    public void testGetCount(){
        CounterFelineFactory counterFelineFactory = new CounterFelineFactory();
        Feline cat = counterFelineFactory.createDomesticCat();
        Feline lion = counterFelineFactory.createLion();

        cat.roar();
        lion.roar();

        assertEquals(2, FelineCoutner.getCount());

    }

}
