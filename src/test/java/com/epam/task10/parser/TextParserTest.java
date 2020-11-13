package com.epam.task10.parser;

import com.epam.task10.model.Component;
import com.epam.task10.model.Composite;
import com.epam.task10.model.LeafLexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class TextParserTest {
    private static final String TEXT = "Germany has a population of million people. Berlin has the largest train station in Europe.\nGermany is composed of sixteen states.\n";
    private static final Component FIRST_PARAGRAPH = LeafLexeme.word("Germany has a population of million people. Berlin has the largest train station in Europe.\n");
    private static final Component SECOND_PARAGRAPH = LeafLexeme.word("Germany is composed of sixteen states.\n");
    private static final Component EXPECTED = new Composite(Arrays.asList(FIRST_PARAGRAPH, SECOND_PARAGRAPH));

    @Test
    public void testTextParserShouldReturnComponentList() {
        Parser successor = Mockito.mock(ParagraphParser.class);
        TextParser textParser = new TextParser(successor);

        Mockito.when(successor.parse(Mockito.any())).
                thenAnswer(invocationOnMock -> LeafLexeme.word((String) invocationOnMock.getArguments()[0]));

//        Mockito.when(successor.parse(Mockito.any()))
//                .thenReturn(FIRST_PARAGRAPH)
//                .thenReturn(SECOND_PARAGRAPH);

        Component actual = textParser.parse(TEXT);
        Assert.assertEquals(EXPECTED, actual);
    }
}
