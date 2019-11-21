package ru.cft.focusstart.reader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.nio.file.Files;

public class DataReaderFromFile implements Reader {
    private File file;

    public DataReaderFromFile(File file) {
        this.file = file;
    }

    @Override
    public String[] read() throws IllegalArgumentException, IOException {
        List<String> listOfParameters = Files.readAllLines(file.toPath());
        if (!listOfParameters.get(0).equals("CIRCLE") && !listOfParameters.get(0).equals("RECTANGLE") &&
                !listOfParameters.get(0).equals("SQUARE")) {
            throw new IllegalArgumentException("Type of Figure in file different from standard");
        }
        if (((listOfParameters.get(0).equals("CIRCLE") || listOfParameters.get(0).equals("SQUARE")) && listOfParameters.size() == 1) ||
                (listOfParameters.get(0).equals("RECTANGLE") && listOfParameters.size() == 2)) {
            throw new IllegalArgumentException("Not enough arguments");
        }
        return listOfParameters.toArray(new String[listOfParameters.size()]);
    }
}
