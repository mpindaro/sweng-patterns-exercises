package it.unimi.di.sweng.lab08;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.Reader;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateKWiCTest {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Before
    public void setUp(){
        Rotator.resetId();
    }

    @Test
    public void kwicWithDeletedPunct(){
        Reader input = new StringReader("Maramao, perche sei morto.\n" +
                "Pan e vin non ti mancava!");

        KWiCGenerator kwic=new KWiCGenerator(input,true,new String[]{});

        String output="0: Maramao perche sei morto\n" +
                "1: Pan e vin non ti mancava\n" +
                "1: e vin non ti mancava   Pan\n" +
                "1: mancava   Pan e vin non ti\n" +
                "0: morto   Maramao perche sei\n" +
                "1: non ti mancava   Pan e vin\n" +
                "0: perche sei morto   Maramao\n" +
                "0: sei morto   Maramao perche\n" +
                "1: ti mancava   Pan e vin non\n" +
                "1: vin non ti mancava   Pan e";

        assertThat(kwic.toString()).isEqualTo(output);

    }

    @Test
    public void kwicWithStopWords(){
        Reader input = new StringReader("Maramao perche sei morto\n" +
                "Pan e vin non ti mancava");

        KWiCGenerator kwic=new KWiCGenerator(input, false, new String[]{"e"});

        String output="0: Maramao perche sei morto\n" +
                "1: Pan vin non ti mancava\n" +
                "1: mancava   Pan vin non ti\n" +
                "0: morto   Maramao perche sei\n" +
                "1: non ti mancava   Pan vin\n" +
                "0: perche sei morto   Maramao\n" +
                "0: sei morto   Maramao perche\n" +
                "1: ti mancava   Pan vin non\n" +
                "1: vin non ti mancava   Pan";

        assertThat(kwic.toString()).isEqualTo(output);
    }

    @Test
    public void kwicCompleteRotator(){
        Reader input = new StringReader("Maramao! perche? sei morto\n" +
                "Pan e vin non ti mancava;");

        KWiCGenerator kwic=new KWiCGenerator(input, true, new String[]{"e"});

        String output="0: Maramao perche sei morto\n" +
                "1: Pan vin non ti mancava\n" +
                "1: mancava   Pan vin non ti\n" +
                "0: morto   Maramao perche sei\n" +
                "1: non ti mancava   Pan vin\n" +
                "0: perche sei morto   Maramao\n" +
                "0: sei morto   Maramao perche\n" +
                "1: ti mancava   Pan vin non\n" +
                "1: vin non ti mancava   Pan";

        assertThat(kwic.toString()).isEqualTo(output);
    }
}
