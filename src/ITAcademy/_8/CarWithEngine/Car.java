package ITAcademy._8.CarWithEngine;

public class Car {

    private final String name;
    private final Engine engine;
    private final int fuelTank;
    private int fuelTankCurrent;

    public Car(String name, Engine engine, int fuelTank) {
        this.name = name;
        this.engine = engine;
        this.fuelTank = fuelTank;
        this.fuelTankCurrent = fuelTank;
    }

    public void refuel() {
        //assigns value from fuelTank to fuelTankCurrent
        fillUp();
        System.out.println("Car " + name + " has been refueled.");
    }

    private void fillUp() {
        this.fuelTankCurrent = fuelTank;
    }

    public void drive(int speed, int distance) {
        //if engine not          : nothing happens
        //otherwise:
        //  if range == 0        : also nothing happens
        //  if range != distance : distance driven and speed will be shown; fuelTankCurrent will be decreased
        if(!engine.isStarted()) {
            System.out.println("Car " + name + " won't go while its engine is stopped.");
        } else {
            if(range() == 0) {
                System.out.println("Car " + name + " is not going anywhere. Tank is empty!");
            } else if(range() >= distance) {
                System.out.println("Car " + name + " has been driven for " + distance + " km with speed " + engine.speedLimit(speed) + " km/h.");
                consumeFuel(distance);
            } else {
                System.out.println("Car " + name + " has been driven only for " + range() + " km with speed " + engine.speedLimit(speed) + " km/h.");
                consumeFuel(range());
            }
        }

    }

    private void consumeFuel(double dist) {
        //reduces fuelTankCurrent and prints whats remain
        if(dist <= range()) {
            this.fuelTankCurrent -= dist * engine.consumption();
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
        //calling engine.start() and prints status
        if(engine.start()) {
            System.out.println("Car " + name + " is starting " + engine.getType() + " engine.");
            System.out.println(engine.getType() + " engine has been started.");
        } else {
            System.out.println(engine.getType() + " engine is already started in " + name + ".");
        }
    }

    public void stopEngine() {
        //calling engine.stop() and prints status
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
