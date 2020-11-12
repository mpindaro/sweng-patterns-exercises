package it.unimi.di.sweng.lab06.factories;

import it.unimi.di.sweng.lab06.Decorator.FelineCoutner;
import it.unimi.di.sweng.lab06.Factories.SimpleFelineFactory;
import it.unimi.di.sweng.lab06.Feline;
import it.unimi.di.sweng.lab06.adapters.FelineDomesticCat;
import it.unimi.di.sweng.lab06.baseclasses.DomesticCat;
import it.unimi.di.sweng.lab06.baseclasses.Lion;
import it.unimi.di.sweng.lab06.baseclasses.Tiger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.Timeout;
import static org.assertj.core.api.Assertions.*;


public class testSimpleFelineFactory {
    @Test
    public void testCreateAnyFeline(){
        Feline f=null;
        SimpleFelineFactory simpleFelineFactory = new SimpleFelineFactory();
        Feline sut=simpleFelineFactory.createDomesticCat();

        assertThat(f).isNotEqualTo(sut);
        assertThat(sut).isInstanceOf(FelineDomesticCat.class);

    }
}
