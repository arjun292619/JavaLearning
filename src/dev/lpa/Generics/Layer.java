package dev.lpa.Generics;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable> {
    private List<T> elements;

    public Layer(T[] elements) {
        this.elements = new ArrayList<>(List.of(elements));
    }

    public void addElements(T... layerElements) {
        this.elements.addAll(List.of(layerElements));
    }

    public void addElement(T element) {
        this.elements.add(element);
    }

    public void renderLayer() {
        for (var element : elements) {
            element.render();
        }
    }
}
