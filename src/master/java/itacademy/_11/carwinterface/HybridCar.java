package itacademy._11.carwinterface;

public class HybridCar extends Car implements ElectricVehicle, ConventionalVehicle {
    public HybridCar(String name, String type) {
        super(name, type);
    }

    @Override
    public void tank() {
        System.out.println("Something for Republicans.");
    }

    @Override
    public void charge() {
        System.out.println("Something for Democrats.");
    }
}
