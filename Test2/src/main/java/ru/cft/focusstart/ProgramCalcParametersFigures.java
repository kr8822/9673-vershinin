package ru.cft.focusstart;


import java.io.FileInputStream;
import java.io.IOException;

public class ProgramCalcParametersFigures {
    public static void main(String[] args) throws IOException {
        try {
            ReaderData readerData = new ReaderData(new FileInputStream(args[0]));
            try{
                new WriterData(args[1], getString(readerData)).writeData();
            } catch (IndexOutOfBoundsException e){
                new WriterData("", getString(readerData)).writeToConsole();
            }
        } catch (IndexOutOfBoundsException e) {
            ReaderData readerData = new ReaderData(System.in);
            new WriterData("", getString(readerData)).writeToConsole();
        }
    }

    public static String getString(ReaderData readerData) {
        String[] parametersOfFigure = readerData.readData();
        FigureType figureType = FigureType.valueOf(parametersOfFigure[0]);
        try {
            return figureType.printString(Double.valueOf(parametersOfFigure[1]), Double.valueOf(parametersOfFigure[2]));
        } catch (IndexOutOfBoundsException e) {
            return figureType.printString(Double.valueOf(parametersOfFigure[1]), 0.);
        }
    }
}
