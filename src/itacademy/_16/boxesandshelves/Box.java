package itacademy._16.boxesandshelves;

import itacademy._16.boxesandshelves.items.Item;

import java.util.ArrayList;

public class Box<T extends Item> {
    private final String boxName;
    private final ArrayList<T> content;

    public Box(String boxName) {
        this.boxName = boxName;
        this.content = new ArrayList<>();
    }

    public void addItem(T item) {
        content.add(item);
    }

    public ArrayList<T> getItems() {
        return new ArrayList<>(content);
    }

    @Override
    public String toString() {
        return boxName;
    }
}
