package ru.cft.focusstart;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.cft.focusstart.reader.DataReaderFromConsole;
import ru.cft.focusstart.reader.DataReaderFromFile;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class DataReaderFromFileTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testReadFromFile() {
        ByteArrayInputStream streamIn = new ByteArrayInputStream("RECTANGLE\n5\n10".getBytes());
        String[] massiveOFStringFromConsole = new DataReaderFromConsole(streamIn).read();
        String[] assertString = new String[]{"RECTANGLE", "5", "10"};
        for (int i = 0; i < assertString.length; i++) {
            assertEquals(assertString[i], massiveOFStringFromConsole[i]);
        }
    }

    @Test
    public void testReadIllegalTypeOfFigureException()  {
        ByteArrayInputStream streamIn = new ByteArrayInputStream("abs\n5\n6".getBytes());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Type of Figure in file different from standard");
        new DataReaderFromFile(streamIn).read();
    }

    @Test
    public void testReadNotEnoughFigureParametersException() {
        ByteArrayInputStream streamIn = new ByteArrayInputStream("RECTANGLE\n5".getBytes());
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Not enough arguments");
        new DataReaderFromFile(streamIn).read();
    }

}
