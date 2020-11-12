package view;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestBigDisplayStrategy {

    @Test
    public void testgetOutputText(){
        ShowStrategy sut = BigDisplayStrategy.INSTANCE;

        StringBuilder s = new StringBuilder();
        s.append("s \n");
        s.append("d \n d \n d \n d \n ");

        String outputText = sut.getOutputText(s.toString());

        assertEquals(outputText,"s \nd \n d \n d \n d \n ");
    }
}
