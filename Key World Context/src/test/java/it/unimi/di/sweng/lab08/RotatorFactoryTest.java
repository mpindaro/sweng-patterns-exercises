package it.unimi.di.sweng.lab08;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class RotatorFactoryTest {

    @Before
    public void setUp(){
        Rotator.resetId();
    }

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    AbstractRotatorFactory factory=new RotatorFactory();

    @Test
    public void create(){
        Rotator simple=factory.createSimpleRotator("A B C D E");
        assertThat(simple.next()).isEqualTo("0: A B C D E");

        Rotator rotatorNoPunct=factory.createNoPunctRotator("A. B: C? D! E;");
        assertThat(rotatorNoPunct.next()).isEqualTo("1: A B C D E");

        Rotator rotatorWithStopWords=factory.createRotatorWithStopWords("A B C D E",new String[]{"E"});
        assertThat(rotatorWithStopWords.next()).isEqualTo("2: A B C D");
    }

    @Test
    public void completeRotator(){
        Rotator complete=factory.createCompleteRotator("A! B; C: D E?",new String[]{"A"});
        assertThat(complete.next()).isEqualTo("0: B C D E");
    }

}
