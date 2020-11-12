package com.epam.task10.model;

import java.util.List;

public interface Component {
    List<Component> getChildren();
}
