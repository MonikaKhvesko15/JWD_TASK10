package com.epam.task10.interpreter;

import com.epam.task10.exception.TerminalExpressionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MathInterpreter {
    public static final String DELIMITER = "\\s";
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTIPLY = '*';
    public static final char DIVIDE = '/';

    private final List<MathExpressionInterpreter> expressionList = new ArrayList<>();

    public MathInterpreter(){

    }
    private void parse(String expression) {
        for (String lexeme : expression.split(DELIMITER)) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case PLUS:
                    expressionList.add(new TerminalExpressionPlus());
                    break;
                case MINUS:
                    expressionList.add(new TerminalExpressionMinus());
                    break;
                case MULTIPLY:
                    expressionList.add(new TerminalExpressionMultiply());
                    break;
                case DIVIDE:
                    expressionList.add(new TerminalExpressionDivide());
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        int number = scanner.nextInt();
                        expressionList.add(new NonTerminalExpression(number));
                    }
            }
        }
    }

    public String calculate(String expression) throws TerminalExpressionException {
        parse(expression);
        Context context = new Context();
        for (MathExpressionInterpreter terminal : expressionList) {
            terminal.interpret(context);
        }
        return context.popValue().toString();
    }
}
