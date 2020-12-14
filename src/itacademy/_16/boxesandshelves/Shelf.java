package itacademy._16.boxesandshelves;

import java.util.ArrayList;

public class Shelf<T extends Box> {
    private final String shelfName;
    private final ArrayList<T> content;

    public Shelf(String name) {
        this.shelfName = name;
        this.content = new ArrayList<>();
    }

    public void addBox(T newBox) {
        content.add(newBox);
    }

    public ArrayList<T> getItems() {
        return new ArrayList<>(content);
    }

    @Override
    public String toString() {
        return shelfName;
    }
}
