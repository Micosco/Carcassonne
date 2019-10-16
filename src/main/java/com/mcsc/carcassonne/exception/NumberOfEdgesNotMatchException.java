package com.mcsc.carcassonne.exception;

public class NumberOfEdgesNotMatchException extends Exception {
    public NumberOfEdgesNotMatchException() {
        super();
    }

    public NumberOfEdgesNotMatchException(String message) {
        super(message);
    }
}
