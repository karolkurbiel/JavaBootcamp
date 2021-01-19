package itacademy._10.inheritanceandpolymorphism;

import java.util.ArrayList;

public class MainPolymorphism {

    private static final ArrayList<Transport> list = new ArrayList<>();

    public static void main(String[] args) {
        Transport vehicle = new Car("Ford Focus",5);
        list.add(vehicle);

        vehicle = new Bus("Solaris Urbino 18", 176);
        list.add(vehicle);

        vehicle = new Airplane("Airbus A320neo", 189);
        list.add(vehicle);

        vehicle = new Bicycle("Romet",1);
        list.add(vehicle);

        vehicle = new Motorbike("PZI Sokol", 2);
        list.add(vehicle);

        vehicle = new Scooter("Vespa", 2);
        list.add(vehicle);

        vehicle = new Train("Alstom Pendolino", 402);
        list.add(vehicle);

        vehicle = new Tram("Bombardier NGT8", 225);
        list.add(vehicle);

        for(Transport obj : list) {
            System.out.println(obj + " goes:");
            hearFromVehicle(obj);
        }
    }

    private static void hearFromVehicle(Transport vehicle) {
        vehicle.useHorn();
    }
}
