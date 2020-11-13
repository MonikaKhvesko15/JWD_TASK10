package com.epam.task10.model;

import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    private final List<Component> components;

    public Composite(List<Component> textParts) {
        this.components = textParts;
    }

    @Override
    public List<Component> getChildren() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return Objects.equals(components, composite.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
    public String toString() {
        return "Composite{" +
                "components=" + components +
                '}';
    }
}
