package ru.cft.focusstart;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FirstTaskTest{

    private final PrintStream printStream = mock(PrintStream.class);


    @Test
    public void testReadSizeFromInputStream(){
        ByteArrayInputStream streamIn = new ByteArrayInputStream("35\nHello\n15".getBytes()); //Подменяем поток ввода своим
        assertEquals(15, FirstTask.readSize(streamIn, printStream));
        verify(printStream, times(3)).println("Please enter number for 1 to 32");
    }

    @Test
    public void testPrintTable(){
        FirstTask.printTable(15,printStream);
        verify(printStream, times(29)).println();
        verify(printStream, times(15*14)).print("|");
    }

    @Test
    public void testPrintTableNumber(){
        FirstTask.printTableNumber(12,11,10,true, printStream);
        verify(printStream).printf("%3d", 11 * 10);
    }
}
