package itacademy._23.immutableobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainCarTest {
    public static void main(String[] args) {
        Engine petrolEngine = new Engine("Petrol",140,4.5);
        Engine dieselEngine = new Engine("Diesel", 135, 3.5);
        Engine electricEngine = new Engine("Electric", 150,0);
        Wheel frontWheel = new Wheel(18,225);
        Wheel rearWheel = new Wheel(18,250);
        List<Wheel> wheels = new ArrayList<>();
        wheels.add(frontWheel);
        wheels.add(frontWheel);
        wheels.add(rearWheel);
        wheels.add(rearWheel);

        Car newCar = new Car("FSO","Polonez", petrolEngine, wheels);
        Car coolCar = new Car("Saab", "94", dieselEngine, wheels);
        Car exoticCar = new Car("Ferrari", "458", petrolEngine,wheels);
        Car weirdoCar = new Car("Toyota", "CH-R",electricEngine,wheels);
        Map<Car, String> carTypes = new HashMap<>();
        carTypes.put(newCar, "SUPER");
        carTypes.put(coolCar, "ANTIQUE");
        carTypes.put(exoticCar, "EXOTIC");
        carTypes.put(weirdoCar, "INEVITABLE FUTURE");

        carTypes.entrySet().forEach(System.out::println);

        Engine polonezEngine = newCar.getEngine();
        polonezEngine.setHorsePower(300);
        carTypes.entrySet().forEach(System.out::println);
        System.out.println("Polonoez test: " + carTypes.get(newCar));
    }
}
