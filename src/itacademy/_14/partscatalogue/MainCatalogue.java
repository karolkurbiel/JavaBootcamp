package itacademy._14.partscatalogue;

import java.util.HashMap;

public class MainCatalogue {
    public static void main(String[] args) {
        HashMap<Integer, CarPart> catalogue = new HashMap<>();
        CarPart newPart = new CarPart(1,"Air Filter","Bosch");
        catalogue.put(newPart.getPartNumber(), newPart);
        newPart = new CarPart(2,"Break Disc","Brembo");
        catalogue.put(newPart.getPartNumber(), newPart);
        newPart = new CarPart(3,"Car Battery","Varta Blue");
        catalogue.put(newPart.getPartNumber(), newPart);
        newPart = new CarPart(4,"Brake Pad","Brembo");
        catalogue.put(newPart.getPartNumber(), newPart);
        newPart = new CarPart(5,"Car Bulbs","Osram");
        catalogue.put(newPart.getPartNumber(), newPart);
        newPart = new CarPart(6,"Wiper Blade","Bosch");
        catalogue.put(newPart.getPartNumber(), newPart);
        newPart = new CarPart(7,"Oil Filter","STP");
        catalogue.put(newPart.getPartNumber(), newPart);
        newPart = new CarPart(8,"Clutch","Valeo");
        catalogue.put(newPart.getPartNumber(), newPart);

        for(int i = 1; i < 9; i++) {
            System.out.println(catalogue.get(i));
        }
    }
}
