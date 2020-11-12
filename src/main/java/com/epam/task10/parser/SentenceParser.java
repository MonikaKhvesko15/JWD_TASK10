package com.epam.task10.parser;

import com.epam.task10.model.Component;
import com.epam.task10.model.Composite;
import com.epam.task10.model.LeafLexeme;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {
    public static final String REGEX_ALL_LEXEME = "([\\s.?!]\\w+|\\s|,|\\.|\\?)|(\\[(\\d+|\\s|\\+|\\*|-|\\\\)+])";
    public static final String REGEX_EXPRESSION = "(\\[(\\d+|\\s|\\+|\\*|\\-|\\/)+])";

    public SentenceParser(Parser successor) {
        super(null);
    }

    @Override
    public Component parse(String textPart) {
        List<Component> lexemes = new ArrayList<>();

        for (String lexeme : textPart.split(REGEX_ALL_LEXEME)) {
            if (checkLexeme(lexeme)) {
                lexemes.add(LeafLexeme.expression(lexeme));
            } else {
                lexemes.add(LeafLexeme.word(lexeme));
            }
        }
        return new Composite(lexemes);
    }

    private boolean checkLexeme(String lexeme) {
        Pattern pattern = Pattern.compile(REGEX_EXPRESSION);
        Matcher matcher = pattern.matcher(lexeme);

        return matcher.matches();
    }
}
