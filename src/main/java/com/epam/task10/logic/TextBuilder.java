package com.epam.task10.logic;

import com.epam.task10.exception.TerminalExpressionException;
import com.epam.task10.interpreter.MathInterpreter;
import com.epam.task10.model.Component;
import com.epam.task10.model.LeafLexeme;
import com.epam.task10.model.LexemeType;

public class TextBuilder {

    private final Component textRoot;
    private final StringBuilder text;
    private final MathInterpreter mathInterpreter;

    public TextBuilder(Component textRoot) {
        this.textRoot = textRoot;
        this.text = new StringBuilder();
        this.mathInterpreter = new MathInterpreter();
    }

    public void buildText() throws TerminalExpressionException {
        for (Component paragraph : textRoot.getChildren()) {
            for (Component sentence : paragraph.getChildren()) {
                for (Component lexeme : sentence.getChildren()) {

                    String lexemeValue = ((LeafLexeme) lexeme).getValue();

                    if (isExpression(lexeme)) {
                        String readyExpression = mathInterpreter.calculate(lexemeValue);
                        text.append(readyExpression);
                    } else {
                        text.append(LeafLexeme.word(lexemeValue));
                    }

                }
            }
            text.append("\n");
        }
    }

    public StringBuilder getText() {
        return text;
    }

    private boolean isExpression(Component lexeme) {
        return ((LeafLexeme) lexeme).getLexemeType() == LexemeType.EXPRESSION;
    }
}
