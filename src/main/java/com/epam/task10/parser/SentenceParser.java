package com.epam.task10.parser;

import com.epam.task10.model.Component;
import com.epam.task10.model.Composite;
import com.epam.task10.model.LeafLexeme;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {

    //public static final String EXPRESSION_REGEX = "(\\s*\\[(\\d+|\\s|\\+|\\*|\\-|\\/)+])";
    public static final String WORD_REGEX = "([\\s*]*[A-zA-Z]+\\.*|\\?)";
    public static final String ALL_LEXEMES_REGEX = "(\\s*\\[(\\d+|\\s|\\+|\\*|\\-|\\/)+])|([\\s*]*[A-zA-Z]+\\.*|\\?)";

    public SentenceParser(Parser successor) {
        super(null);
    }

    @Override
    public Component parse(String textPart) {

        List<Component> lexemes = new ArrayList<>();

        Pattern pattern = Pattern.compile(ALL_LEXEMES_REGEX);
        Matcher matcher = pattern.matcher(textPart);

        while (matcher.find()) {
            String lexeme = matcher.group();

            if (checkLexeme(lexeme)) {
                lexemes.add(LeafLexeme.word(lexeme));
            } else {
                lexemes.add(LeafLexeme.expression(lexeme));
            }
        }
        return new Composite(lexemes);
    }

    private boolean checkLexeme(String lexeme) {
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(lexeme);

        return matcher.matches();
    }
}
