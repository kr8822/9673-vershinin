package ru.cft.focusstart.writer;

public class DataWriter implements Writer{
    Writer writer;

    public DataWriter(Writer writer){
        this.writer = writer;
    }

    @Override
    public void write(String string) throws Exception{
        writer.write(string);
    }
}
