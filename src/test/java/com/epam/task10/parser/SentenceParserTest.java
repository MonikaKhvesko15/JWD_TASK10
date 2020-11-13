package com.epam.task10.parser;

import com.epam.task10.model.Component;
import com.epam.task10.model.Composite;
import com.epam.task10.model.LeafLexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SentenceParserTest {
    private static final String SENTENCE = "Germany has a population of [9 9 *] million people.";

    public static final LeafLexeme FIRST_LEXEME = LeafLexeme.word("Germany");
    public static final LeafLexeme SECOND_LEXEME = LeafLexeme.word(" has");
    public static final LeafLexeme THIRD_LEXEME = LeafLexeme.word(" a");
    public static final LeafLexeme FOURTH_LEXEME = LeafLexeme.word(" population");
    public static final LeafLexeme FIFTH_LEXEME = LeafLexeme.word(" of");
    public static final LeafLexeme SIXTH_LEXEME = LeafLexeme.expression(" [9 9 *]");
    public static final LeafLexeme SEVENTH_LEXEME = LeafLexeme.word(" million");
    public static final LeafLexeme EIGHTH_LEXEME = LeafLexeme.word(" people.");

    private static final Component EXPECTED = new Composite(Arrays.asList(FIRST_LEXEME, SECOND_LEXEME, THIRD_LEXEME, FOURTH_LEXEME, FIFTH_LEXEME, SIXTH_LEXEME, SEVENTH_LEXEME, EIGHTH_LEXEME));

    @Test
    public void testSentenceParserShouldReturnComponentList() {
        //given
        SentenceParser parser = new SentenceParser(null);

        //when
        Component actual = parser.parse(SENTENCE);

        //then
        Assert.assertEquals(EXPECTED, actual);
    }
}
