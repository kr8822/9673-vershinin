package ru.cft.focusstart;


import java.io.File;

import ru.cft.focusstart.exceptions.FIleNotFoundOrEmptyException;
import ru.cft.focusstart.reader.*;
import ru.cft.focusstart.writer.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        String result;
        try {
            if (args.length >= 1) {
                File fileInput = new File(args[0]);
                if (fileInput.exists() && fileInput.length() != 0) {
                    String[] parametersOfFigure = new DataReaderFromFile(fileInput).read();
                    result = FigureCreature.valueOf(parametersOfFigure[0]).createFigure(parametersOfFigure).printDescription();
                } else {
                    throw new FIleNotFoundOrEmptyException("File doesn't exist or empty");
                }
            } else {
                String[] parametersOfFigure = new DataReaderFromConsole(System.in).read();
                result = FigureCreature.valueOf(parametersOfFigure[0]).createFigure(parametersOfFigure).printDescription();
            }
        } catch (Exception e) {
            log.error("Name exception: {}, Message: {}", e.getClass().getCanonicalName(), e.getMessage());
            String[] parametersOfFigure = new DataReaderFromConsole(System.in).read();
            result = FigureCreature.valueOf(parametersOfFigure[0]).createFigure(parametersOfFigure).printDescription();
        }


        try {
            if (args.length >= 2) {
                File fileOutput = new File(args[1]);
                new DataWriterToFile(fileOutput).write(result);
            } else {
                new DataWriterToConsole().write(result);
            }
        } catch (Exception e) {
            log.error("Name exception: {}, Message: {}", e.getClass().getCanonicalName(), e.getMessage());
            new DataWriterToConsole().write(result);
        }
    }

}
