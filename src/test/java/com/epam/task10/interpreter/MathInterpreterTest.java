package com.epam.task10.interpreter;

import com.epam.task10.exception.TerminalExpressionException;
import org.junit.Assert;
import org.junit.Test;

public class MathInterpreterTest {

    private static final String RESTORED_EXPRESSION = "6";
    private static final String EXPRESSION = "1 2 * 10 + 2 /";
    private static final String EXPRESSION_DIVIDE_BY_ZERO = "1 2 * 10 + 0 /";

    @Test
    public void testMathInterpreterShouldReturnResolveExpression() throws TerminalExpressionException {
        //given
        MathInterpreter interpreter = new MathInterpreter();
        String expected = RESTORED_EXPRESSION;

        //when
        String actual = interpreter.calculate(EXPRESSION);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = TerminalExpressionException.class)
    public void testMathInterpreterShouldThrowExceptionWhenDivisionByZero() throws TerminalExpressionException {
        //given
        MathInterpreter interpreter = new MathInterpreter();

        //when
        String actual = interpreter.calculate(EXPRESSION_DIVIDE_BY_ZERO);
    }
}
