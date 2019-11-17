package ru.cft.focusstart;

import java.io.FileWriter;
import java.io.IOException;

class WriterData {
    private String nameOfFile;
    private String stringForWriting;

    public WriterData(String nameOfFile, String stringForWriting) {
        this.nameOfFile = nameOfFile;
        this.stringForWriting = stringForWriting;
    }

    public void writeData() {
        try (FileWriter fileWriter = new FileWriter(this.nameOfFile)) {
            fileWriter.write(this.stringForWriting);
        } catch (IOException e) {
            this.writeToConsole();
        }
    }

    public void writeToConsole() {
        System.out.println(this.stringForWriting);
    }
}
