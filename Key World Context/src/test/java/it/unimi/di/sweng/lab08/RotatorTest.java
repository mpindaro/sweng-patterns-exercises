package it.unimi.di.sweng.lab08;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.assertj.core.api.Assertions.*;

public class RotatorTest {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);


    @Before
    public void setUp(){
        Rotator.resetId();
    }

    private AbstractRotatorFactory factory=new RotatorFactory();

    @Test
    public void next(){
        Rotator rotator = factory.createSimpleRotator("0 1 2 3 4");
        assertThat(rotator.next()).isEqualTo("0: 0 1 2 3 4");
        assertThat(rotator.next()).isEqualTo("0: 1 2 3 4   0");
        assertThat(rotator.next()).isEqualTo("0: 2 3 4   0 1");
        assertThat(rotator.next()).isEqualTo("0: 3 4   0 1 2");
        assertThat(rotator.next()).isEqualTo("0: 4   0 1 2 3");
    }

    @Test
    public void hasNext(){
        Rotator rotator = factory.createSimpleRotator("0 1 2 3 4");
        assertThat(rotator.hasNext()).isTrue();

        while(rotator.hasNext()){
            assertThat(rotator.hasNext()).isTrue();
            rotator.next();
        }
        assertThat(rotator.hasNext()).isFalse();
    }

    @Test
    public void twoRotators(){
        Rotator rotator = factory.createSimpleRotator("0 1 2 3 4");
        Rotator rotator1 = factory.createSimpleRotator("A B C D E");
        assertThat(rotator.next()).isEqualTo("0: 0 1 2 3 4");
        assertThat(rotator1.next()).isEqualTo("1: A B C D E");

    }

    @Test
    public void noPunctRotator(){
        Rotator rotator=factory.createNoPunctRotator("0. 1! 2: 3; 4?");
        assertThat(rotator.next()).isEqualTo("0: 0 1 2 3 4");
    }

    @Test
    public void rotatorWithStopWords(){
        Rotator rotator=factory.createRotatorWithStopWords("A B C D E",new String[]{"C"});
        assertThat(rotator.next()).isEqualTo("0: A B D E");
    }

    @Test
    public void completeRotator(){
        Rotator complete=factory.createCompleteRotator("A! B? C D E,",new String[]{"B"});
        assertThat(complete.next()).isEqualTo("0: A C D E");
    }
}
