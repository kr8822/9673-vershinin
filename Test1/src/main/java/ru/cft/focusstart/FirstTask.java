package ru.cft.focusstart;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        int size = readSize(System.in, System.out);
        printTable(size, System.out);
    }

    public static int readSize(InputStream stream, PrintStream printStream){
        Scanner scanner = new Scanner(stream);
        int size;
        do {
            printStream.println("Please enter number for 1 to 32");
            while (!scanner.hasNextInt()) {
                printStream.println("That not a number!");
                printStream.println("Please enter number for 1 to 32");
                scanner.next();
            }
            size = scanner.nextInt();
            if (size < 1 || size > 32) {
                printStream.println("That not a right number!");
            }
        } while (size < 1 || size > 32);
        return size;
    }

    public static void printTable(int size, PrintStream printStream){
        for (int i = 1; i < size + 1; i++) {
            int j;
            for (j = 1; j < size; j++) {
                printTableNumber(size, i, j, true, printStream);
                printStream.print("|");
            }
            printTableNumber(size, i, j, true, printStream);
            printStream.println();
            if (i != size) {
                for (j = 1; j < size; j++) {
                    printTableNumber(size, i, j, false, printStream);
                    printStream.print("+");
                }
                printTableNumber(size, i, j, false, printStream);
                printStream.println();
            }
        }
    }

    public static void printTableNumber(int size, int first, int second, boolean flag, PrintStream printStream) {
        if (size <= 3) {
            if (flag) {
                printStream.printf("%d", first * second);
            } else {
                printStream.print("-");
            }
        } else if (size < 10) {
            if (flag) {
                printStream.printf("%2d", first * second);
            } else {
                printStream.print("--");
            }
        } else if (size < 32) {
            if (flag) {
                printStream.printf("%3d", first * second);
            } else {
                printStream.print("---");
            }
        } else {
            if (flag) {
                printStream.printf("%4d", first * second);
            } else {
                printStream.print("----");
            }
        }
    }

}
