package ru.cft.focusstart.reader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReaderFromFile implements Reader {
    private InputStream inputStream;

    public DataReaderFromFile(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public String[] read() throws IllegalArgumentException {
        ArrayList<String> arrayOFParameters = new ArrayList<>();
        try (Scanner scanner = new Scanner(this.inputStream)) {
            arrayOFParameters.add(scanner.nextLine());
            if (!arrayOFParameters.get(0).equals("CIRCLE") && !arrayOFParameters.get(0).equals("RECTANGLE") &&
                    !arrayOFParameters.get(0).equals("SQUARE")) {
                throw new IllegalArgumentException("Type of Figure in file different from standard");
            }
            while (scanner.hasNextLine()) {
                arrayOFParameters.add(readDoubleNumber(scanner));
            }
            if (((arrayOFParameters.get(0).equals("CIRCLE") || arrayOFParameters.get(0).equals("SQUARE")) && arrayOFParameters.size() == 1) ||
                    (arrayOFParameters.get(0).equals("RECTANGLE") && arrayOFParameters.size() == 2)) {
                throw new IllegalArgumentException("Not enough arguments");
            }
        }
        return arrayOFParameters.toArray(new String[arrayOFParameters.size()]);
    }

    private String readDoubleNumber(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            scanner.nextLine();
        }
        return scanner.nextLine();
    }
}
