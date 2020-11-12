package it.unimi.di.sweng.lab06.composite;
import it.unimi.di.sweng.lab06.Decorator.FelineCoutner;
import it.unimi.di.sweng.lab06.Factories.CounterFelineFactory;
import it.unimi.di.sweng.lab06.Factories.SimpleFelineFactory;
import it.unimi.di.sweng.lab06.Feline;
import it.unimi.di.sweng.lab06.Gang;
import it.unimi.di.sweng.lab06.adapters.FelineDomesticCat;
import it.unimi.di.sweng.lab06.adapters.FelinePelucheCat;
import it.unimi.di.sweng.lab06.baseclasses.DomesticCat;
import it.unimi.di.sweng.lab06.baseclasses.Lion;
import it.unimi.di.sweng.lab06.baseclasses.Tiger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.Timeout;

import java.security.Signature;

import static org.assertj.core.api.Assertions.*;

public class testGang {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Rule
    public final SystemOutRule output = new SystemOutRule().enableLog();

    @Test
    public  void testGangRoar(){
        Gang sut = new Gang();
        SimpleFelineFactory simpleFelineFactory = new SimpleFelineFactory();
        sut.add(simpleFelineFactory.createLion());
        sut.add(simpleFelineFactory.createDomesticCat());
        sut.add(simpleFelineFactory.createTiger());
        sut.add(simpleFelineFactory.createPelucheCat());

        sut.roar();

        assertThat(output.getLog()).isEqualTo("ROAR\nmeow\nROAR\nsingsong-miao\n");

    }

    @Test
    public void testCountedGangRoar(){
        Gang sut = new Gang();
        CounterFelineFactory counterFelineFactory = new CounterFelineFactory();
        sut.add(counterFelineFactory.createLion());
        sut.add(counterFelineFactory.createDomesticCat());
        sut.add(counterFelineFactory.createTiger());
        sut.add(counterFelineFactory.createPelucheCat());

        sut.roar();

        assertThat(output.getLog()).isEqualTo("ROAR\nmeow\nROAR\nsingsong-miao\n");
        assertThat(FelineCoutner.getCount()).isEqualTo(4);
    }

    @Test
    public void TestCompositedComposite(){

        Gang tigers = new Gang();
        Gang lions= new Gang();
        Gang peluchecat = new Gang();
        Gang domesticcat= new Gang();

        CounterFelineFactory counterFelineFactory = new CounterFelineFactory();

        tigers.add(counterFelineFactory.createTiger());
        tigers.add(counterFelineFactory.createTiger());
        tigers.add(counterFelineFactory.createTiger());
        tigers.add(counterFelineFactory.createTiger());

        lions.add(counterFelineFactory.createLion());
        lions.add(counterFelineFactory.createLion());
        lions.add(counterFelineFactory.createLion());

        peluchecat.add(counterFelineFactory.createPelucheCat());
        peluchecat.add(counterFelineFactory.createPelucheCat());

        domesticcat.add(counterFelineFactory.createDomesticCat());

        Gang sut = new Gang();

        sut.add(tigers);
        sut.add(lions);
        sut.add(peluchecat);
        sut.add(domesticcat);

        sut.roar();

        assertThat(FelineCoutner.getCount()).isEqualTo(10);

        assertThat(output.getLog()).isEqualTo("ROAR\nROAR\nROAR\nROAR\nROAR\nROAR\nROAR\nsingsong-miao\nsingsong-miao\nmeow\n");




    }

}
