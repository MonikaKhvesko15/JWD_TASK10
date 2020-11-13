package com.epam.task10.interpreter;

import com.epam.task10.exception.TerminalExpressionException;

public interface MathExpressionInterpreter {
    void interpret(Context context) throws TerminalExpressionException;
}
