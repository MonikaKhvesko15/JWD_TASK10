package com.epam.task10.logic;

import com.epam.task10.model.Component;

import java.util.Comparator;

public class SortLexemes implements Sort {

    @Override
    public void sort(Component textRoot) {
        for (Component paragraph : textRoot.getChildren()) {
            for (Component sentence : paragraph.getChildren()) {
                sentence.getChildren().sort(Comparator.comparing((Component lexeme) ->
                        sentence.getChildren().size()));
            }
        }
    }
}
