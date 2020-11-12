package view;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSmallDisplayStrategy {


    @Test
    public void testgetOutputText(){
        ShowStrategy sut = SmallDisplayStrategy.INSTANCE;

        StringBuilder s = new StringBuilder();
        s.append("s \n");
        s.append("d \n d \n d \n d \n ");

        String outputText = sut.getOutputText(s.toString());

        assertEquals(outputText,"s ");
    }
}
