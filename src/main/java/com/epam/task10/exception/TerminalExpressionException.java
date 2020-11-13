package com.epam.task10.exception;

public class TerminalExpressionException extends Exception {

    public TerminalExpressionException() {

    }

    public TerminalExpressionException(String message) {
        super(message);
    }

    public TerminalExpressionException(String message, Throwable cause) {
        super(message, cause);
    }

    public TerminalExpressionException(Throwable cause) {
        super(cause);
    }
}
