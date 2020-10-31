package itacademy._8.carwithengine;

public class Car {

    private final String name;
    private final Engine engine;
    private final int fuelTankCapacity;
    private int fuelTankCurrent;

    public Car(String name, Engine engine, int fuelTankCapacity) {
        this.name = name;
        this.engine = engine;
        this.fuelTankCapacity = fuelTankCapacity;
        this.fuelTankCurrent = fuelTankCapacity;
    }

    public void refuel() {
        fillUp();
        System.out.println("Car " + name + " has been refueled.");
    }

    private void fillUp() {
        fuelTankCurrent = fuelTankCapacity;
    }

    public void drive(int desiredSpeed, int desiredDistance) {
        if(!engine.isRunning()) {
            System.out.println("Car " + name + " won't go while its engine is stopped.");
        } else {
            if(range() == 0) {
                System.out.println("Car " + name + " is not going anywhere. Tank is empty!");
            } else if(range() >= desiredDistance) {
                System.out.println("Car " + name + " has been driven for " + desiredDistance + " km with speed " + engine.producedSpeed(desiredSpeed) + " km/h.");
                consumeFuel(desiredDistance);
            } else {
                System.out.println("Car " + name + " has been driven only for " + range() + " km with speed " + engine.producedSpeed(desiredSpeed) + " km/h.");
                consumeFuel(range());
            }
        }

    }

    private void consumeFuel(double distanceTraveled) {
        if(distanceTraveled <= range()) {
            fuelTankCurrent -= distanceTraveled * engine.consumption();
            if(fuelTankCurrent == 0) {
                System.out.println("Tank is empty");
            } else {
                System.out.println("Remaining fuel: " + fuelTankCurrent + "L");
            }
        } else {
            System.out.println("Car:consumeFuel(): input error");
        }
    }

    public void startEngine() {
        if(engine.start()) {
            System.out.println("Car " + name + " is starting " + engine.getType() + " engine.");
            System.out.println(engine.getType() + " engine has been started.");
        } else {
            System.out.println(engine.getType() + " engine is already started in " + name + ".");
        }
    }

    public void stopEngine() {
        if(engine.stop()) {
            System.out.println("Car " + name + " is shutting down " + engine.getType() + " engine.");
            System.out.println(engine.getType() + " engine has been stopped.");
        } else {
            System.out.println(engine.getType() + " engine is already shut down in " + name + ".");
        }
    }

    private double range() {
        //returns how much distance you can travel on amount in fuelTankCurrent
        return fuelTankCurrent/engine.consumption();
    }
}
