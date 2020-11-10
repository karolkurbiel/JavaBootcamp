package itacademy._11.carwinterface;

import java.util.ArrayList;

public class MainCar {
    public static void main(String[] args) {

        ArrayList<Car> garage = new ArrayList<>();

        Car car = new FuelCar("Ford","Mondeo");
        garage.add(car);

        car = new FuelCar("Mercedes","GLA");
        garage.add(car);

        car = new ElectricCar("Porshe","Tycan");
        garage.add(car);

        car = new ElectricCar("VW","eGolf");
        garage.add(car);

        car = new HybridCar("Toyota","Prius");
        garage.add(car);

        car = new HybridCar("Toyota","C-HR");
        garage.add(car);

        for(Car automobile : garage) {
            System.out.println(automobile.getName() + " " + automobile.getType() + " says: ");
            if(automobile instanceof ElectricVehicle) {
                ((ElectricVehicle) automobile).charge();
            }
            if( automobile instanceof ConventionalVehicle) {
                ((ConventionalVehicle) automobile).tank();
            }
        }
    }
}
