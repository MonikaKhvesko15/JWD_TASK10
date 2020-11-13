package com.epam.task10.logic;

import com.epam.task10.model.Component;

import java.util.Comparator;
import java.util.List;

public class SortLexemes implements Sort {

    @Override
    public void sort(Component textRoot) {
        for (Component paragraph : textRoot.getChildren()) {
            for (Component sentence : paragraph.getChildren()) {

                sentence.getChildren().sort(Comparator.comparing(lexeme -> {
                    List<Component> children;
                    children = sentence.getChildren();
                    return children.size();
                }));
            }
        }
    }
}
