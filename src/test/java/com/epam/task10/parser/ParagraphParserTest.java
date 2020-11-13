package com.epam.task10.parser;

import com.epam.task10.model.Component;
import com.epam.task10.model.Composite;
import com.epam.task10.model.LeafLexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class ParagraphParserTest {
    public static final String PARAGRAPH = "Germany has a population of million people. Berlin has the largest train station in Europe.";
    private static final Component FIRST_SENTENCE = LeafLexeme.word("Germany has a population of million people.");
    private static final Component SECOND_SENTENCE = LeafLexeme.word(" Berlin has the largest train station in Europe.");
    private static final Component EXPECTED = new Composite(Arrays.asList(FIRST_SENTENCE, SECOND_SENTENCE));

    @Test
    public void testParagraphParserShouldReturnComponentList() {
        Parser successor = Mockito.mock(SentenceParser.class);
        ParagraphParser paragraphParser = new ParagraphParser(successor);

        Mockito.when(successor.parse(Mockito.any())).
                thenAnswer(invocationOnMock -> LeafLexeme.word((String) invocationOnMock.getArguments()[0]));

//        Mockito.when(successor.parse(Mockito.any()))
//                .thenReturn(SENTENCE1)
//                .thenReturn(SENTENCE2);

        Component actual = paragraphParser.parse(PARAGRAPH);
        Assert.assertEquals(EXPECTED, actual);
    }
}
