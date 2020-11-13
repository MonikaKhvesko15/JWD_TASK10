package com.epam.task10.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LeafLexeme implements Component {

    private final String value;
    private final LexemeType lexemeType;

    private LeafLexeme(String value, LexemeType lexemeType) {
        this.value = value;
        this.lexemeType = lexemeType;
    }

    public static LeafLexeme word(String value) {
        return new LeafLexeme(value, LexemeType.WORD);
    }

    public static LeafLexeme expression(String value) {
        return new LeafLexeme(value, LexemeType.EXPRESSION);
    }

    public String getValue() {
        return value;
    }

    public LexemeType getLexemeType() {
        return lexemeType;
    }

    @Override
    public List<Component> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeafLexeme that = (LeafLexeme) o;
        return Objects.equals(value, that.value) &&
                lexemeType == that.lexemeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, lexemeType);
    }

    @Override
    public String toString() {
        return "LeafLexeme{" +
                "value='" + value + '\'' +
                ", lexemeType=" + lexemeType +
                '}';
    }
}



