package com.epam.task10.parser;

import com.epam.task10.model.Component;
import com.epam.task10.model.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends AbstractParser {

    public static final String REGEX_PARAGRAPH = "(.|\\n)+?\\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String textPart) {
        Pattern pattern = Pattern.compile(REGEX_PARAGRAPH);
        Matcher matcher = pattern.matcher(textPart);

        List<Component> paragraphs = new ArrayList<>();

        while (matcher.find()) {
            String paragraph = matcher.group();
            Component child = getSuccessor().parse(paragraph);
            paragraphs.add(child);
        }

        return new Composite(paragraphs);
    }
}