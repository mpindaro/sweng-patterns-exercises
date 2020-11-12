package it.unimi.di.sweng.lab06.adapters;

import it.unimi.di.sweng.lab06.Feline;
import it.unimi.di.sweng.lab06.baseclasses.DomesticCat;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.Timeout;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.junit.Assert.*;

public class TestDomesticCatAdaptee {


    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog();

    @Test
    public void testRoar(){
        Feline sut = new FelineDomesticCat(new DomesticCat());
        sut.roar();
        assertThat(output.getLog()).isEqualTo("meow\n");
    }
}
