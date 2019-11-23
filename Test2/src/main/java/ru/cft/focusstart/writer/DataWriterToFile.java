package ru.cft.focusstart.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriterToFile implements Writer {
    private File fileOutput;

    public DataWriterToFile(File fileOutput) {
        this.fileOutput = fileOutput;
    }

    @Override
    public void write(String stringForWriting) throws IOException {
        try (FileWriter fileWriter = new FileWriter(this.fileOutput)) {
            fileWriter.write(stringForWriting);
        }
    }
}
