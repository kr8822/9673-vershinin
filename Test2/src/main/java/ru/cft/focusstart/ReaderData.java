package ru.cft.focusstart;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class ReaderData {
    private InputStream inputStream;

    public ReaderData(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String[] readData() {
        if (inputStream instanceof FileInputStream) {
            try {
                return this.readFromFile(this.inputStream);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                this.inputStream = System.in;
                return this.readFromConsole(this.inputStream);
            }
        } else {
            return readFromConsole(this.inputStream);
        }
    }

    private String[] readFromFile(InputStream inputStream) throws IOException {
        ArrayList<String> arr = new ArrayList<String>();
        try (Scanner scanner = new Scanner(inputStream)) {
            if (scanner.hasNextLine()) {
                arr.add(scanner.nextLine());
                if (!arr.get(0).equals("CIRCLE") && !arr.get(0).equals("RECTANGLE") && !arr.get(0).equals("SQUARE")) {
                    throw new IOException("Type of Figure in file different from standart");
                }
            } else {
                throw new IOException("File is empty");
            }
            while (scanner.hasNextLine()) {
                arr.add(readDoubleNumber(scanner));
            }
            if (((arr.get(0).equals("CIRCLE") || arr.get(0).equals("SQUARE")) && arr.size() == 1) ||
                    (arr.get(0).equals("RECTANGLE") && arr.size() == 1)) {
                throw new IOException("Not enough arguments");
            }
        }
        return arr.toArray(new String[arr.size()]);
    }

    private String[] readFromConsole(InputStream inputStream) {
        System.out.println("Choose and input type of Figure: CIRCLE, RECTANGLE, SQUARE");
        String buffer;
        Scanner scanner = new Scanner(inputStream);
        buffer = scanner.nextLine();
        while (!buffer.equals("CIRCLE") && !buffer.equals("RECTANGLE") && !buffer.equals("SQUARE")) {
            System.out.println("You input wrong type. Please, choose and input type from this: CIRCLE, RECTANGLE, SQUARE");
            buffer = scanner.nextLine();
        }
        ArrayList<String> arr = new ArrayList<String>();
        arr.add(buffer);
        switch (arr.get(0)) {
            case "RECTANGLE":
                System.out.println("Input double number");
                arr.add(readDoubleNumber(scanner));
                System.out.println("Input double number");
                arr.add(readDoubleNumber(scanner));
                break;
            default:
                arr.add(readDoubleNumber(scanner));
                break;
        }
        return arr.toArray(new String[arr.size()]);
    }

    private String readDoubleNumber(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            scanner.nextLine();
        }
        return scanner.nextLine();
    }
}
