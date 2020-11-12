package com.epam.task10.parser;

import com.epam.task10.model.Component;
import com.epam.task10.model.Composite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {

    public static final String REGEX_SENTENCE = ".*?[.!?]";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String textPart) {
        List<Component> sentences = new ArrayList<>();

        Pattern pattern = Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = pattern.matcher(textPart);

        while (matcher.find()) {
            String sentence = matcher.group();
            Component child = getSuccessor().parse(sentence);
            sentences.add(child);
        }
        return new Composite(sentences);
    }
}
