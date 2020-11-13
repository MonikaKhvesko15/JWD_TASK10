package com.epam.task10.logic;

import com.epam.task10.model.Component;

import java.util.Comparator;
import java.util.List;

public class SortParagraphs implements Sort {

    @Override
    public void sort(Component textRoot) {
        Comparator<Component> comparator = Comparator.comparing(paragraph -> {
            List<Component> children = paragraph.getChildren();
            return children.size();
        });
        textRoot.getChildren().sort(comparator);
    }
}
