package com.epam.task10.interpreter;

public class NonTerminalExpression implements MathExpressionInterpreter {
    private final int number;

    public NonTerminalExpression(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
