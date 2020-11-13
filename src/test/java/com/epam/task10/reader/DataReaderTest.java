package com.epam.task10.reader;

import com.epam.task10.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

public class DataReaderTest {

    private static final String CORRECT_INPUT_TXT = "src/test/resources/SourceTest.txt";
    private static final String INVALID_TXT = "src/test/resources/Source.txt";

    @Test
    public void testDataReaderShouldReturnDataStringWhenFileExists() throws DataException {
        //given
        String expected = " Germany has a population of [9 9 *] million people.\n" +
                "Germany is a member of the European Union.\n";
        Reader textReader = new DataReader();

        //when
        String actual = textReader.getData(CORRECT_INPUT_TXT);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = DataException.class)
    public void testDataReaderShouldThrowExceptionWhenFileNotExists() throws DataException {
        //given
        Reader textReader = new DataReader();

        //when
        textReader.getData(INVALID_TXT);
    }
}
