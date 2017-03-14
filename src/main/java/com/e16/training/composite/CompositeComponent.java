package com.e16.training.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeComponent implements Component {
    private final List<Component> componentList = new ArrayList<>();
    private final String separator = System.lineSeparator();

    @Override
    public String operation() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompositeComponent operation");
        sb.append(separator);
        for (Component c : componentList) {
            sb.append(c.operation());
            sb.append(separator);
        }
        return sb.toString();
    }

    public String getSeparator() {
        return separator;
    }

    public boolean add(Component component) {
        return componentList.add(component);
    }

    public boolean remove(Component component) {
        return componentList.remove(component);
    }

    public Component getComponent(int id) {
        return componentList.get(id);
    }
}
