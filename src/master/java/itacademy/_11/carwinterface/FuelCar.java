package itacademy._11.carwinterface;

public class FuelCar extends Car implements ConventionalVehicle {
    public FuelCar(String name, String type) {
        super(name, type);
    }

    @Override
    public void tank() {
        System.out.println("I'm getting petrol to my belly, yummy!");
    }
}
