package it.unimi.di.sweng.lab06.factories;
import it.unimi.di.sweng.lab06.Decorator.FelineCoutner;
import it.unimi.di.sweng.lab06.Factories.CounterFelineFactory;
import it.unimi.di.sweng.lab06.Factories.SimpleFelineFactory;
import it.unimi.di.sweng.lab06.Feline;
import it.unimi.di.sweng.lab06.baseclasses.Lion;
import it.unimi.di.sweng.lab06.baseclasses.Tiger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.Timeout;
import static org.assertj.core.api.Assertions.*;

public class TestCountedFelineFactory {

    @Test
    public void TestAnyCountedCreate(){
        Feline feline = null;

        CounterFelineFactory counterFelineFactory = new CounterFelineFactory();

        Feline sut= counterFelineFactory.createDomesticCat();

        assertThat(feline).isNotEqualTo(sut);
        assertThat(sut).isInstanceOf(FelineCoutner.class);
    }
}
