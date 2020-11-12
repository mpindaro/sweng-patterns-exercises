package it.unimi.di.sweng.lab08;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.Reader;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferentKWiCTest {

    @Before
    public void setUp(){
        Rotator.resetId();
    }

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Test
    public void differentSort(){
        Reader input = new StringReader("Maramao perche sei morto\n" +
                "Pan e vin non ti mancava");

        KWiCGenerator kwic=new KWiCGenerator(input,new AlphabeticOrder());

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

        Rotator.resetId();

        input = new StringReader("Maramao perche sei morto\n" +
                "Pan e vin non ti mancava");

        kwic=new KWiCGenerator(input,new NaturalOrder());

        output= "0: Maramao perche sei morto\n" +
                "0: morto   Maramao perche sei\n" +
                "0: perche sei morto   Maramao\n" +
                "0: sei morto   Maramao perche\n" +
                "1: Pan e vin non ti mancava\n" +
                "1: e vin non ti mancava   Pan\n" +
                "1: mancava   Pan e vin non ti\n" +
                "1: non ti mancava   Pan e vin\n" +
                "1: ti mancava   Pan e vin non\n" +
                "1: vin non ti mancava   Pan e";

        assertThat(kwic.toString()).isEqualTo(output);
    }

    @Test
    public void setOrderMethod(){
        Reader input = new StringReader("Maramao perche sei morto\n" +
                "Pan e vin non ti mancava");

        KWiCGenerator kwic=new KWiCGenerator(input,new AlphabeticOrder());

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

        input = new StringReader("Maramao perche sei morto\n" +
                "Pan e vin non ti mancava");

        kwic.setOrderMethod(new NaturalOrder());

        output= "0: Maramao perche sei morto\n" +
                "0: morto   Maramao perche sei\n" +
                "0: perche sei morto   Maramao\n" +
                "0: sei morto   Maramao perche\n" +
                "1: Pan e vin non ti mancava\n" +
                "1: e vin non ti mancava   Pan\n" +
                "1: mancava   Pan e vin non ti\n" +
                "1: non ti mancava   Pan e vin\n" +
                "1: ti mancava   Pan e vin non\n" +
                "1: vin non ti mancava   Pan e";

        assertThat(kwic.toString()).isEqualTo(output);
    }

    @Test
    public void classicPrint(){
        Reader input = new StringReader("Maramao perche sei morto\n" +
                "Pan e vin non ti mancava");

        KWiCGenerator kwic=new KWiCGenerator(input,new ClassicPrintStyle());

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
    public void newStylePrint(){
        Reader input = new StringReader("Maramao perche sei morto\n" +
                "Pan e vin non ti mancava");

        KWiCGenerator kwic=new KWiCGenerator(input,new WhiteLineSeparatorPrintStyle());

        String output="0: Maramao perche sei morto\n\n" +
                "1: Pan e vin non ti mancava\n\n" +
                "1: e vin non ti mancava   Pan\n\n" +
                "1: mancava   Pan e vin non ti\n\n" +
                "0: morto   Maramao perche sei\n\n" +
                "1: non ti mancava   Pan e vin\n\n" +
                "0: perche sei morto   Maramao\n\n" +
                "0: sei morto   Maramao perche\n\n" +
                "1: ti mancava   Pan e vin non\n\n" +
                "1: vin non ti mancava   Pan e";

        assertThat(kwic.toString()).isEqualTo(output);
    }

    @Test
    public void setPrintStyle(){
        Reader input = new StringReader("Maramao perche sei morto\n" +
                "Pan e vin non ti mancava");

        KWiCGenerator kwic=new KWiCGenerator(input,new ClassicPrintStyle());

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

        kwic.setPrintStyle(new WhiteLineSeparatorPrintStyle());

        input = new StringReader("Maramao perche sei morto\n" +
                "Pan e vin non ti mancava");

        output="0: Maramao perche sei morto\n\n" +
                "1: Pan e vin non ti mancava\n\n" +
                "1: e vin non ti mancava   Pan\n\n" +
                "1: mancava   Pan e vin non ti\n\n" +
                "0: morto   Maramao perche sei\n\n" +
                "1: non ti mancava   Pan e vin\n\n" +
                "0: perche sei morto   Maramao\n\n" +
                "0: sei morto   Maramao perche\n\n" +
                "1: ti mancava   Pan e vin non\n\n" +
                "1: vin non ti mancava   Pan e";

        assertThat(kwic.toString()).isEqualTo(output);

    }
}
