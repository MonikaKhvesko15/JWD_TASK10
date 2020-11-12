package com.epam.task10.parser;

import com.epam.task10.model.Component;
import com.epam.task10.model.Composite;
import com.epam.task10.model.LeafLexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class ParagraphParserTest {
    public static final String PARAGRAPH = "Germany has a population of million people.Berlin has the largest train station in Europe.";
    private static final Component SENTENCE1 = LeafLexeme.word("Germany has a population of million people.");
    private static final Component SENTENCE2 = LeafLexeme.word("Berlin has the largest train station in Europe.");
    private static final Component EXPECTED = new Composite(Arrays.asList(SENTENCE1, SENTENCE2));

    @Test
    public void testParagraphParserShouldReturnComponentList() {
        Parser successor = Mockito.mock(SentenceParser.class);
        ParagraphParser paragraphParser = new ParagraphParser(successor);
        Mockito.when(paragraphParser.parse(PARAGRAPH)).
                thenAnswer(invocationOnMock -> LeafLexeme.word((String) invocationOnMock.getArguments()[0]));
        Component actual = paragraphParser.parse(PARAGRAPH);
        Assert.assertEquals(EXPECTED, actual);
    }
}
