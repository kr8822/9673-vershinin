package ru.cft.focusstart.exceptions;

import java.io.IOException;

public class FIleNotFoundOrEmptyException extends IOException {
    public FIleNotFoundOrEmptyException(String message){
        super(message);
    }
}
