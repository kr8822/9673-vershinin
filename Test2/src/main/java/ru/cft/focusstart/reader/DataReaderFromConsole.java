package ru.cft.focusstart.reader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReaderFromConsole implements Reader {
    InputStream inputStream;

    public DataReaderFromConsole(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public String[] read() {
        System.out.println("Choose and input type of Figure: CIRCLE, RECTANGLE, SQUARE");
        String buffer;
        Scanner scanner = new Scanner(this.inputStream);
        buffer = scanner.nextLine();
        while (!buffer.equals("CIRCLE") && !buffer.equals("RECTANGLE") && !buffer.equals("SQUARE")) {
            System.out.println("You input wrong type. Please, choose and input type from this: CIRCLE, RECTANGLE, SQUARE");
            buffer = scanner.nextLine();
        }
        ArrayList<String> arrayOfParameters = new ArrayList<>();
        arrayOfParameters.add(buffer);
        switch (arrayOfParameters.get(0)) {
            case "RECTANGLE":
                arrayOfParameters.add(readUnsignedDoubleNumber(scanner, "Input double number for first side above zero"));
                arrayOfParameters.add(readUnsignedDoubleNumber(scanner, "Input double number for second side above zero"));
                break;
            default:
                arrayOfParameters.add(readUnsignedDoubleNumber(scanner, "Input double number for characteristic size above zero"));
                break;
        }
        return arrayOfParameters.toArray(new String[arrayOfParameters.size()]);
    }

    private String readUnsignedDoubleNumber(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            while (!scanner.hasNextDouble()) {
                scanner.nextLine();
            }
            String result = scanner.nextLine();
            if (Double.parseDouble(result) > 0) {
                return result;
            }
        }
    }
}
