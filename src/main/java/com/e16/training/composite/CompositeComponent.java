package com.e16.training.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeComponent implements Component {
    private List<Component> componentList = new ArrayList<>();

    @Override
    public String operation() {
        return "CompositeComponent operation";
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
