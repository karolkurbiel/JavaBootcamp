package itacademy._11.carwinterface;

public class ElectricCar extends Car implements ElectricVehicle {
    public ElectricCar(String name, String type) {
        super(name, type);
    }

    @Override
    public void charge() {
        System.out.println("I'm feeling buzzed and powerful!");
    }
}
