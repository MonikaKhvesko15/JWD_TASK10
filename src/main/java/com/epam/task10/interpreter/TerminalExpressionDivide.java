package com.epam.task10.interpreter;

import com.epam.task10.exception.TerminalExpressionException;

public class TerminalExpressionDivide implements MathExpressionInterpreter {
    @Override
    public void interpret(Context context) throws TerminalExpressionException {
        Integer firstValue = context.popValue();
        Integer secondValue = context.popValue();
        try {
            context.pushValue(secondValue / firstValue);
        } catch (ArithmeticException e) {
            throw new TerminalExpressionException(e.getMessage(), e);
        }
    }
}
