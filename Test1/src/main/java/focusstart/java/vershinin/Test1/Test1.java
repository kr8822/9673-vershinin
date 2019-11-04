package focusstart.java.vershinin.Test1;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        //----------------------------------------
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("Please enter number for 1 to 32");
            while (!scanner.hasNextInt()) {
                System.out.println("That not a number!");
                System.out.println("Please enter number for 1 to 32");
                scanner.next();
            }
            size = scanner.nextInt();
            if (size < 1 || size > 32) {
                System.out.println("That not a right number!");
            }
        } while (size < 1 || size > 32);
        //---------------------------------------

        for (int i = 1; i < size + 1; i++) {
            int j;
            for (j = 1; j < size; j++) {
                PrintTableNumber(size, i, j, true);
                System.out.print("|");
            }
            PrintTableNumber(size, i, j, true);
            System.out.println();
            if (i != size) {
                for (j = 1; j < size; j++) {
                    PrintTableNumber(size, i, j, false);
                    System.out.print("+");
                }
                PrintTableNumber(size, i, j, false);
                System.out.println();
            }
        }
    }

    private static void PrintTableNumber(int size, int first, int second, boolean flag) {
        if (size <= 3) {
            if (flag) System.out.printf("%d", first * second);
            else System.out.print("-");
        } else if (size < 10) {
            if (flag) System.out.printf("%2d", first * second);
            else System.out.print("--");
        } else if (size < 32) {
            if (flag) System.out.printf("%3d", first * second);
            else System.out.print("---");
        } else {
            if (flag) System.out.printf("%4d", first * second);
            else System.out.print("----");
        }
    }

}
