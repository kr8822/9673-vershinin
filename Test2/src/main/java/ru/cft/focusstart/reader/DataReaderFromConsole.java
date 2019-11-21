package ru.cft.focusstart.reader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReaderFromConsole implements Reader{
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
        ArrayList<String> arrayOFParameters = new ArrayList<String>();
        arrayOFParameters.add(buffer);
        switch (arrayOFParameters.get(0)) {
            case "RECTANGLE":
                arrayOFParameters.add(readUnsignedDoubleNumber(scanner, "Input double number for first side"));
                arrayOFParameters.add(readUnsignedDoubleNumber(scanner, "Input double number for second side"));
                break;
            default:
                arrayOFParameters.add(readUnsignedDoubleNumber(scanner, "Input double number for characteristic size"));
                break;
        }
        return arrayOFParameters.toArray(new String[arrayOFParameters.size()]);
    }

    private String readUnsignedDoubleNumber(Scanner scanner, String message) {
        System.out.println(message);
        while (!scanner.hasNextDouble()) {
            scanner.nextLine();
        }
        String result = scanner.nextLine();
        if(Integer.valueOf(result) > 0){
            return result;
        } else {
            return readUnsignedDoubleNumber(scanner, message);
        }
    }
}
