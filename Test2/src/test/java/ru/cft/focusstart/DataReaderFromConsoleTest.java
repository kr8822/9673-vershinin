package ru.cft.focusstart;

import org.junit.Test;
import ru.cft.focusstart.reader.DataReaderFromConsole;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class DataReaderFromConsoleTest {

    @Test
    public void testReadFromConsole() {
        ByteArrayInputStream streamIn = new ByteArrayInputStream("Triangle\nfgd\nRECTANGLE\nabc\n5\n10".getBytes());
        String[] massiveOFStringFromConsole = new DataReaderFromConsole(streamIn).read();
        String[] assertString = new String[]{"RECTANGLE", "5", "10"};
        for (int i = 0; i < assertString.length; i++) {
            assertEquals(assertString[i], massiveOFStringFromConsole[i]);
        }
    }

    @Test
    public void testReadNegativeParameterOfFigureFromConsole() {
        ByteArrayInputStream streamIn = new ByteArrayInputStream("CIRCLE\n-15\n-5\n10".getBytes());
        String[] massiveOFStringFromConsole = new DataReaderFromConsole(streamIn).read();
        String[] assertString = new String[]{"CIRCLE", "10"};
        for (int i = 0; i < assertString.length; i++) {
            assertEquals(assertString[i], massiveOFStringFromConsole[i]);
        }
    }
}