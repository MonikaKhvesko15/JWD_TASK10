package com.epam.task10.logic;

import com.epam.task10.model.Component;

import java.util.Comparator;

public class SortParagraphs implements Sort {

    @Override
    public void sort(Component textRoot) {
        textRoot.getChildren().sort(Comparator.comparing((Component paragraph) -> paragraph.getChildren().size()));
    }
}
