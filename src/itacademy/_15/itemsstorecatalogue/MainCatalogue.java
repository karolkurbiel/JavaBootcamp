package itacademy._15.itemsstorecatalogue;

import java.util.Scanner;
import java.util.TreeMap;

public class MainCatalogue {
    public static void main(String[] args) {
        getMenu(populateList());
    }

    private static void getMenu(TreeMap<String, Item> itemList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while(!quit) {
            System.out.println("To sort item list, please press on keyboard:");
            System.out.println("\t0 - to quit" +
                    "\n\t1 - to sort by name" +
                    "\n\t2 - to sort by name in reverse order" +
                    "\n\t3 - to sort in ascending order" +
                    "\n\t4 - to sort in descending order");
            int chose = scanner.nextInt();
            scanner.nextLine();

            switch(chose) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("List sorted by name: " + itemList);
                    break;
                case 2:
                    System.out.println("List sorted by name descending:" + itemList.descendingMap());
                    break;
                case 3:
                    TreeMap<String, Item> ascendingList = new TreeMap<>(new ItemByPriceComparator(itemList));
                    ascendingList.putAll(itemList);
                    System.out.println("List sorted by price:" + ascendingList);
                    break;
                case 4:
                    TreeMap<String, Item> descendingList = new TreeMap<>(new ItemByPriceComparator(itemList));
                    descendingList.putAll(itemList);
                    System.out.println("List sorted by price descending:" + descendingList.descendingMap());
                    break;
            }
        }
    }

    private static TreeMap<String, Item> populateList() {
        TreeMap<String, Item> itemList = new TreeMap<>();

        Item newItem = new Item("Pierogi", 2.4);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Herring", 4.5);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Flour", 1.25);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Pasta", 1.9);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Sausages", 1.3);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Salomon", 6.48);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Tuna", 8.2);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Frankfurters", 1.75);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Neapolitan sauce", 5.5);
        itemList.put(newItem.getName(), newItem);
        newItem = new Item("Cheese", 3.69);
        itemList.put(newItem.getName(), newItem);

        return itemList;
    }
}
