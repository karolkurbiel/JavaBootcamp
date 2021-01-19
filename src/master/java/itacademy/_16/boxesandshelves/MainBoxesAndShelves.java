package itacademy._16.boxesandshelves;

import itacademy._16.boxesandshelves.items.*;

public class MainBoxesAndShelves {
    public static void main(String[] args) {
        Box<Toy> toyBox1 = new Box<>("Nick's toys");
        Box<Toy> toyBox2 = new Box<>("Amy's toys");
        Box<Toy> toyBox3 = new Box<>("Marianne's toys");

        Box<Food> foodBox1 = new Box<>("Cornflakes");
        Box<Food> foodBox2 = new Box<>("Spices");
        Box<Food> foodBox3 = new Box<>("Pastas");

        Box<Book> bookBox1 = new Box<>("School books");
        Box<Book> bookBox2 = new Box<>("Culinary books");
        Box<FantasyBook> bookBox3 = new Box<>("Weird stuff");


        Shelf<Box<Toy>> toysShelf = new Shelf<>("Shelf with toys.");
        toysShelf.addBox(toyBox1);
        toysShelf.addBox(toyBox2);
        toysShelf.addBox(toyBox3);

        Shelf<Box<? extends Book>> booksShelf = new Shelf<>("Shelf with books.");
        booksShelf.addBox(bookBox1);
        booksShelf.addBox(bookBox2);
        booksShelf.addBox(bookBox3);

        Shelf<Box<? extends Item>> chaoticShelf = new Shelf<>("Shelf with everything.");
        chaoticShelf.addBox(foodBox1);
        chaoticShelf.addBox(foodBox2);
        chaoticShelf.addBox(foodBox3);
        chaoticShelf.addBox(toyBox2);
        chaoticShelf.addBox(bookBox3);

        System.out.println(toysShelf);
        System.out.println("\t" + toysShelf.getItems());

        System.out.println(booksShelf);
        System.out.println("\t" + booksShelf.getItems());

        System.out.println(chaoticShelf);
        System.out.println("\t" + chaoticShelf.getItems());
    }
}
