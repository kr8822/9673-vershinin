package ru.cft.focusstart;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
            File fileInput = new File(args[0]);
            if (fileInput.exists() && fileInput.length() != 0) {
                result = new ParametersFigureReader(new DataReaderFromFile(new FileInputStream(fileInput))).read()[0];
            } else {
                throw new FIleNotFoundOrEmptyException("File doesn't exist or empty");
            }
        } catch (Exception e) {
            log.error("Name exception: {}, Message: {}", e.getClass().getCanonicalName(), e.getMessage());
            result = new ParametersFigureReader(new DataReaderFromConsole(System.in)).read()[0];
        }

        try {
            File fileOutput = new File(args[1]);
            new DataWriter(new DataWriterToFile(fileOutput)).write(result);
        } catch (Exception e) {
            log.error("Name exception: {}, Message: {}", e.getClass().getCanonicalName(), e.getMessage());
            new DataWriter(new DataWriterToConsole()).write(result);
        }
    }

}
